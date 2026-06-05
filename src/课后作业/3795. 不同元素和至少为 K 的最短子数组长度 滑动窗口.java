// 第一次就写错了 思路不对 没好好审题

// 题解
class Solution {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>(); // 更快的写法见【Java 数组】
        int sum = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // 1. 入
            int x = nums[i];
            int c = cnt.merge(x, 1, Integer::sum);
            if (c == 1) {
                sum += x;
            }

            while (sum >= k) {
                // 2. 更新答案
                ans = Math.min(ans, i - left + 1);

                // 3. 出
                int out = nums[left];
                c = cnt.merge(out, -1, Integer::sum);
                if (c == 0) {
                    sum -= out;
                }
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimum-subarray-length-with-distinct-sum-at-least-k/solutions/3872139/bu-ding-chang-hua-dong-chuang-kou-python-ioop/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。














// 错误思路和示范 别学！ 以及最简单的反例
class Solution {
    public int minLength(int[] nums, int k) {
        int ans = 100000;
        long sum = 0;
        int left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int right = 0; right < nums.length; right++){
            cnt.merge(nums[right], 1, Integer::sum);
            while (left <= right && cnt.get(nums[right]) > 1) {
                sum -= nums[left];
                cnt.merge(nums[left], -1, Integer::sum);
                left++;
            }
            sum += nums[right];
            while (left <= right && sum - nums[left] >= k) {
                sum -= nums[left];
                cnt.merge(nums[left], -1, Integer::sum);
                left++;
            }
            if (sum >= k) {
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans == 100000 ? -1 : ans; 
    }
}

// 反例
输入
nums = [10,11,12,13,13,1]
k = 47

输出 -1
预期结果 6

// 其实还有另一种反例 这种是重新开始 但是后面的有子数组 但是还是不如两个相同的连在一起短
输入
nums =
[154,163,156,47,151,151,22,203,149,130,115,71,3,14,30,132,208,100,125,160,36,103,125,51,187,137,157,217,53,4,146,14,20,59,224,129,161,29]
k =
1247


输出
12
预期结果
11