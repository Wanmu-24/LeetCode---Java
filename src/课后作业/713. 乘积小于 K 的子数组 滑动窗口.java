// https://www.bilibili.com/video/BV1hd4y1r7Gq
// 滑动窗口【基础算法精讲 03】 课上例题

// 自己第一次写
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int n = nums.length;
        int sum = 1;
        for(int right = 0; right < n; right++){
            sum *= nums[right];
            while(sum >= k && left <= right){
                sum /= nums[left];
                left++;
            }
            if(sum < k){
                ans += right - left + 1;
            }
            
        }
        return ans;
    }
}


// 灵茶题解
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) {
            return 0;
        }
        int ans = 0;
        int prod = 1;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            prod *= nums[right];
            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}