// 灵茶题解 前后缀分解
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] preMax = new int[n];
        preMax[0] = height[0];
        for(int i = 1; i < n; i++){
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        int[] sufMax = new int[n];
        sufMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.min(preMax[i],sufMax[i]) - height[i];
        }
        return ans;
    }
}


// 灵茶题解 双指针 
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int ans = 0;
        int preMax = 0;
        int sufMax = 0;
        int left = 0;
        int right = n - 1;
        while(left < right){
            preMax = Math.max(preMax,height[left]);
            sufMax = Math.max(sufMax,height[right]);
            if(preMax < sufMax){
                ans += preMax - height[left];
                left++;
            }else{
                ans += sufMax - height[right];
                right--;
            }
        }
        return ans;
    }
}