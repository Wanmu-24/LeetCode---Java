// 自己没写出来 没想到还能逆向思维 正难则反

// 灵茶题解
class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) {
            return -1; // 全部移除也无法满足要求
        }

        int n = nums.length;
        int ans = -1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++; // 缩小子数组长度
            }
            if (sum == target) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : n - ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/solutions/2048811/ni-xiang-si-wei-pythonjavacgo-by-endless-b4jt/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 自己下午看了题解思路后 晚上重新单独写的
class Solution {
    public int minOperations(int[] nums, int x) {
        int ans = -1;
        int left = 0;
        int sum = 0;
        for (int j : nums) {
            sum += j;
        }
        if (sum < x) return -1;
        if(sum == x) return nums.length;
        int k = sum - x;
        int cnt = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt += nums[right];
            while (cnt > k) {
                cnt -= nums[left];
                left++;
            }
            if (cnt == k) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans == -1 ? -1 : nums.length - ans;
    }
} 