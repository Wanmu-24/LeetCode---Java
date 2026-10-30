// https://www.bilibili.com/video/BV1hd4y1r7Gq
// 滑动窗口【基础算法精讲 03】 课上例题

// 在 while 循环结束后更新答案
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            sum += nums[right];
            while(sum >= target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans <= n ? ans : 0; 
    }
}


/*
在 while 循环内更新答案
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int sum = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            sum += nums[right];
            while(sum - nums[left] >= target){
                sum -= nums[left];
                left++;
            }
            if(sum >= target){
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans <= n ? ans : 0; 
    }
}
*/