// https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/description/
// 自己第一次写 没写出来

// 题解
class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0;
        int right = (price[price.length - 1] - price[0]) / (k - 1) + 1;
        while (left + 1 < right) { // 开区间不为空
            // 循环不变量：
            // f(left) >= k
            // f(right) < k
            int mid = left + (right - left) / 2;
            if (f(price, mid) >= k) {
                left = mid; // 下一轮二分 (mid, right)
            } else {
                right = mid; // 下一轮二分 (left, mid)
            }
        }
        return left; // 最大的满足 f(left) >= k 的数
    }

    private int f(int[] price, int d) {
        int cnt = 1;
        int pre = price[0]; // 先选一个价格最小的糖果
        for (int p : price) {
            if (p - pre >= d) { // 可以选 p
                cnt++;
                pre = p;
            }
        }
        return cnt;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/solutions/2031994/er-fen-da-an-by-endlesscheng-r418/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。