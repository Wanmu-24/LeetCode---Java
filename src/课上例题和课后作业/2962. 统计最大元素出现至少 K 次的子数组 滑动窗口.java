// 自己第一次写 没写出来 思路错了
// 应该用最简单的思路的 固定右端点  不要想太复杂 自己怎么操作得到题目的答案就怎么写 还好一点
// 固定右端点！！！！！！
// 灵茶题解 
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        long ans = 0;
        int cntMx = 0, left = 0;
        for (int x : nums) {
            if (x == mx) {
                cntMx++;
            }
            while (cntMx == k) {
                if (nums[left] == mx) {
                    cntMx--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/solutions/2560940/hua-dong-chuang-kou-fu-ti-dan-pythonjava-xvwg/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。