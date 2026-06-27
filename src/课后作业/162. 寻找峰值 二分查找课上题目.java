// 听了题解自己重写一遍

// 统一用 mid + 1 写法
// 即下面这种
class Solution {
    public int findPeakElement(int[] nums) {
        // left 为 峰顶左侧
        // right 为峰顶或峰顶右侧
        // 采用开区间写法 (left,right) 区间内为不确定的范围
        int left = -1;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[mid  + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}

// class Solution {
//     public int findPeakElement(int[] nums) {
//         // left 为 峰顶或峰顶左侧
//         // right 为峰顶右侧
//         // 采用开区间写法 (left,right) 区间内为不确定的范围
//         int left = 0;
//         int right = nums.length;

//         while (left + 1 < right) {
//             int mid = (left + right) >>> 1;
//             if (nums[mid] > nums[mid  - 1]) {
//                 left = mid;
//             } else {
//                 right = mid;
//             }
//         }
//         return left;
//     }
// }


// 灵茶题解
class Solution {
    public int findPeakElement(int[] nums) {
        int left = -1;
        int right = nums.length - 1; // 开区间 (-1, n-1)
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) { // 下坡，峰顶位置 <= mid
                right = mid;
            } else { // 上坡，峰顶位置 > mid
                left = mid;
            }
        }
        return right;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/find-peak-element/solutions/1987497/by-endlesscheng-9ass/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。