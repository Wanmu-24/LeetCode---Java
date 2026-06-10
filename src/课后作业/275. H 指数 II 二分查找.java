// 自己第一次写 过了 但是有可以优化的地方
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(mid, citations)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public boolean check(int mid, int[] citations) {
        int sum = 0;
        for (int x : citations) {
            if (x >= mid) {
                sum++;
            }
            if (sum >= mid) {
                return true;
            }
        }
        return false;
    }
}

// 灵茶题解
class Solution {
    public int hIndex(int[] citations) {
        // 在区间 (left, right) 内询问
        int n = citations.length;
        int left = 0;
        int right = n + 1;
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // left 的回答一定为「是」
            // right 的回答一定为「否」
            int mid = (left + right) >>> 1;
            // 引用次数最多的 mid 篇论文，引用次数均 >= mid
            if (citations[n - mid] >= mid) {
                left = mid; // 询问范围缩小到 (mid, right)
            } else {
                right = mid; // 询问范围缩小到 (left, mid)
            }
        }
        // 根据循环不变量，left 现在是最大的回答为「是」的数
        return left;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/h-index-ii/solutions/2504326/tu-jie-yi-tu-zhang-wo-er-fen-da-an-si-ch-d15k/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。