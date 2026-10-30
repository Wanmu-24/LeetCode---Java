// 自己写没想出来

// 灵茶题解
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);
        }
        while (left + 1 < right) { // 开区间不为空
            int mid = left + (right - left) / 2;
            if (check(mid, piles, h)) {
                right = mid; // 循环不变量：恒为 true
            } else {
                left = mid; // 循环不变量：恒为 false
            }
        }
        return right; // 最小的 true
    }

    private boolean check(int mid, int[] piles, int h) {
        int sum = piles.length;
        for (int pile : piles) {
            sum += (pile - 1) / mid;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/koko-eating-bananas/solutions/2710324/er-fen-da-an-fu-ti-dan-pythonjavacgojsru-eb18/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。