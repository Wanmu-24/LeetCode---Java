class Solution {
    public int findMin(int[] nums) {
        int left = -1; // 最小值左侧
        int right = nums.length - 1;  // 最小值或最小值右侧
        // 区间内是不确定的 区间外是确定的 最小值左侧（-1，n-1） 最小值或最小值右侧 
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                if(nums[right-1] == nums[right]) {
                    right--;
                }else{
                    left = mid;
                }
            }
        }
        return nums[right];
    }
}

// 题解
class Solution {
    public int findMin(int[] nums) {
        int left = -1;
        int right = nums.length - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = (left + right) >>> 1;
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right];
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/solutions/2131553/zhi-yao-ni-hui-153-jiu-neng-kan-dong-pyt-qqc6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。