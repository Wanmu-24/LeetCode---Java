// lowerBound 返回最小的满足 nums[i] >= target 的下标 i
// 如果数组为空，或者所有数都 < target，则返回 nums.length

class Solution {
    public int searchInsert(int[] nums, int target) {
        // 如果所有数都小于 target，那么循环中更新的只有 left，无论下面哪种二分写法，最后都一定会返回数组长度，所以无需特判这种情况。
        
        // 闭区间写法
        // int left = 0;
        // int right = nums.length - 1;
        // while (left <= right) {
        //     int mid = left + (right - left) /2;
        //     if (nums[mid] < target) {
        //         left = mid + 1;
        //     } else {
        //         right = mid - 1;
        //     }
        // }
        // return left;

        // 开区间写法
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