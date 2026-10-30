// https://leetcode.cn/problems/minimize-maximum-of-array/description/
// 自己第一次写 没写出来

// 二分查找
class Solution {
    public int minimizeArrayValue(int[] nums) {
        int left = nums[0] - 1;
        int right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }

        // 开区间二分，原理见 https://www.bilibili.com/video/BV1AP41137w7/
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(nums, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private boolean check(int[] nums, int limit) {
        long extra = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            long newNum = nums[i] + extra; // 把多出的积木堆到 nums[i] 上
            extra = Math.max(newNum - limit, 0); // 如果 newNum - limit > 0，那么多出的积木继续丢给左边
        }
        return nums[0] + extra <= limit;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimize-maximum-of-array/solutions/1895244/liang-chong-zuo-fa-er-fen-da-an-fen-lei-qhee6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 分类讨论 前缀和写法
class Solution {
    public int minimizeArrayValue(int[] nums) {
        long ans = 0;
        long s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            ans = Math.max(ans, (s + i) / (i + 1));
        }
        return (int) ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimize-maximum-of-array/solutions/1895244/liang-chong-zuo-fa-er-fen-da-an-fen-lei-qhee6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。