// 灵茶题解 
// 数组内单个整数太大 用int[1e9] 会超内存
// 没想到 可以用 Map<Integer, Integer>

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int right = 0; right < nums.length; right++){
            cnt.merge(nums[right], 1, Integer::sum);
            while (cnt.get(nums[right]) > k) {
                cnt.merge(nums[left], -1, Integer::sum);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}