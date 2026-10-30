// 自己写 直接复制数组 导致超时 没全过
// 灵茶题解
class RangeFreqQuery {
    private final Map<Integer, List<Integer>> pos = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pos.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> a = pos.get(value);
        if (a == null) {
            return 0;
        }
        // > right 等价于 >= right+1
        return lowerBound(a, right + 1) - lowerBound(a, left);
    }

    // 开区间写法
    // 请看 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(List<Integer> a, int target) {
        // 开区间 (left, right)
        int left = -1;
        int right = a.size();
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // a[left] < target
            // a[right] >= target
            int mid = (left + right) >>> 1;
            if (a.get(mid) < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right; // right 是最小的满足 a[right] >= target 的下标
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/range-frequency-queries/solutions/1113439/tong-ji-wei-zhi-er-fen-wei-zhi-by-endles-8l9u/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */