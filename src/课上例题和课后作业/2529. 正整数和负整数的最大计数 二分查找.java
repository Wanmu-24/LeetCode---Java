// 自己写
class Solution {
    public int maximumCount(int[] nums) {
        int neg = lower_bound(nums, 0);
        int pos = lower_bound(nums, 1);
        pos = nums.length - pos;
        return Math.max(neg, pos);
    }

    // 返回数组里 大于等于 target 的第一个数的下标 如果没有 则返回数组的长度(或者说 target该插入的位置 正序)
    public int lower_bound(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        while (left + 1 != right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

}

//灵茶题解
class Solution {
    public int maximumCount(int[] nums) {
        int neg = lowerBound(nums, 0);
        // 第一个 > 0 的位置，等价于第一个 >= 1 的位置
        int pos = nums.length - lowerBound(nums, 1);
        return Math.max(neg, pos);
    }

    // 返回 nums 中第一个 >= target 的数的下标
    // 如果不存在这样的数，返回 nums.length
    // 详见 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[] nums, int target) {
        // 二分范围：开区间 (left, right)
        int left = -1;
        int right = nums.length;
        // 开区间不为空
        while (left + 1 < right) {
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                // 二分范围缩小至 (left, mid)
                right = mid;
            } else {
                // 二分范围缩小至 (mid, right)
                left = mid;
            }
        }
        // 此时 left 等于 right - 1
        // 因为 nums[right - 1] < target 且 nums[right] >= target，所以答案是 right
        return right;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/solutions/2050916/mo-ni-by-endlesscheng-8e43/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。