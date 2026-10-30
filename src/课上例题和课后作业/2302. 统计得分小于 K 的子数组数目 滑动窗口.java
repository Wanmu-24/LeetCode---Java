// 自己第一次写 思路一样 过是过了 不过 耗时和内存太多了
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


// 灵茶题解
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/solutions/1595722/by-endlesscheng-b120/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 根据题解 修改了一下自己的代码 优化一下空间和时间
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int left = 0;
        int n = nums.length;
        long sum = 0;
        long cnt = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            cnt =  (right - left + 1) * sum;
            while (cnt >= k) {
                sum -= nums[left];
                left++;
                cnt = (right - left + 1) * sum;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}