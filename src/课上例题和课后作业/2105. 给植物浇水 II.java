// 自己第一次写
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int i = 0;
        int j = plants.length - 1;
        int left_water = capacityA;
        int right_water = capacityB;
        while(i < j){
            if(left_water < plants[i]){
                ans++;
                left_water = capacityA - plants[i];
                i++;
            }else{
                left_water -= plants[i]; 
                i++;
            }

            if(right_water < plants[j]){
                ans++;
                right_water = capacityB - plants[j];
                j--;
            }else{
                right_water -= plants[j];
                j--;
            }
        }
        if(i == j && Math.max(left_water,right_water) < plants[i]){
            int max_water = ;
            if(max_water < plants[i])ans++;
        }
        return ans;
    }
}

// 看题解后的优化代码
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int i = 0;
        int j = plants.length - 1;
        int leftWater = capacityA;
        int rightWater = capacityB;
        while(i < j){
            if(leftWater < plants[i]){
                ans++;
                leftWater = capacityA;
            }
            leftWater -= plants[i];
            i++;

            if(rightWater < plants[j]){
                ans++;
                rightWater = capacityB;
            }
            rightWater -= plants[j];
            j--;
        }
        if(i == j && Math.max(leftWater,rightWater) < plants[i]){
            ans++;
        }
        return ans;
    }
}