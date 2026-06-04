class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int left = 0;
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int j = 1; j <= n; j++){
            prefix[j] = prefix[j - 1] + nums[j - 1];
        }
        for (int right = 0; right < n; right++) {
            if (nums[right] >= k) continue;
            long sum = prefix[right + 1] - prefix[left];      // 返回 long
            long cnt =  (right - left + 1) * sum;
            while (cnt >= k) {
                left++;
                long temp =   prefix[right + 1] - prefix[left];
                 cnt = (right - left + 1) * temp;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}