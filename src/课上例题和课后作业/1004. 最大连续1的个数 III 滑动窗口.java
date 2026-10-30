// 自己第一次没写出来
// 滑动窗口的核心在 构造窗口 这个名词概念  然后想清楚 什么条件下滑动什么 maybe吧 自己的理解
// 灵茶题解
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int cnt0 = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right]; // 0 变成 1，用来统计 cnt0
            while (cnt0 > k) {
                cnt0 -= 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/max-consecutive-ones-iii/solutions/2126631/hua-dong-chuang-kou-yi-ge-shi-pin-jiang-yowmi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。