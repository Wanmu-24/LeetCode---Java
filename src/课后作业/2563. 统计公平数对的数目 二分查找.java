// 第一次写 就差一点 循环条件 后面看了题解才知道 循环条件写错了
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            // 范围 在[low, high] 才能算答案
            int low = lower - nums[i];
            int high = upper - nums[i];
            int start = lowerBound(nums, low, i);
            int end = lowerBound(nums, high + 1, i);
            ans += end - start;
        }
        return ans;
    }
    
    // 如果都大于 target 最后 left = i right = i + 1
    // 如果都小于 target 最后 left = n - 1  right = n
    public int lowerBound(int[] nums, int target,int i) {
        int left = i;
        int right = nums.length;
        while (left + 1 < right) {
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


// 灵茶题解
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int j = 0; j < nums.length; j++) {
            // 注意要在 [0, j-1] 中二分，因为题目要求两个下标 i < j
            int r = lowerBound(nums, j, upper - nums[j] + 1);
            int l = lowerBound(nums, j, lower - nums[j]);
            ans += r - l;
        }
        return ans;
    }

    // 原理请看 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[] nums, int right, int target) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/count-the-number-of-fair-pairs/solutions/2107079/er-fen-cha-zhao-de-ling-huo-yun-yong-by-wplbj/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。