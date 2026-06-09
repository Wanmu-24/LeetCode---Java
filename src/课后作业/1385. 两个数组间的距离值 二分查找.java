// 自己写
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            // 不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
            // 即arr[2] 不能 存在 [low,high]
            int low = arr1[i] - d;
            int high = arr1[i] + d;
            int start = lower_bound(arr2, low);
            if (start == arr2.length || arr2[start] > high) {
                ans++;
            }
        }
        return ans;
    }

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


// 灵茶题解
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int x : arr1) {
            int i = Arrays.binarySearch(arr2, x - d);
            if (i < 0) {
                i = ~i; // -i - 1
            }
            if (i == arr2.length || arr2[i] > x + d) {
                ans++;
            }
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/solutions/3010185/liang-chong-fang-fa-er-fen-cha-zhao-san-15u9b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// Arrays.binarySearch(数组,目标值)
// 找到了目标值  返回值 ≥ 0 目标值在数组中的索引
// 没找到目标值  返回值 < 0 -(应该插入点) - 1