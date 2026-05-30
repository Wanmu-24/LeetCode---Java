// 灵茶题解的思路
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int sum = (right - left) * Math.min(height[left], height[right]);
            ans =Math.max(sum,ans);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}