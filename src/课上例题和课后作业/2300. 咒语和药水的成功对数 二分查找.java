// 自己写
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int len = potions.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            long target = (success + spells[i] - 1L) / spells[i];
            ans[i] = len - lower_bound(potions,target);
        }
        return ans;
    }
    
    public int lower_bound(int nums[], long target) {
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

// 灵茶题解
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            spells[i] = potions.length - lowerBound(potions, (double) success / spells[i]);
        }
        return spells;
    }

    // 返回 nums 中的第一个大于等于 target 的元素下标
    private int lowerBound(int[] nums, double target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] <= target
            // nums[right] > target
            int mid = (left + right) >>> 1; // 比 left+(right-left)/2 更快的写法
            if (nums[mid] >= target) {
                right = mid; // 二分范围缩小到 (left, mid)
            } else {
                left = mid; // 二分范围缩小到 (mid, right)
            }
        }
        return right;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/solutions/1595712/by-endlesscheng-1kbp/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。