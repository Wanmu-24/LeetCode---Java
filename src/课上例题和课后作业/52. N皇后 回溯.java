// 题解 思路和51一样
class Solution {
    private int ans;

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n * 2 - 1];
        boolean[] diag2 = new boolean[n * 2 - 1];
        dfs(0, col, diag1, diag2);
        return ans;
    }

    private void dfs(int r, boolean[] col, boolean[] diag1, boolean[] diag2) {
        int n = col.length;
        if (r == n) {
            ans++; // 找到一个合法方案
            return;
        }
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!col[c] && !diag1[r + c] && !diag2[rc]) {
                col[c] = diag1[r + c] = diag2[rc] = true;
                dfs(r + 1, col, diag1, diag2);
                col[c] = diag1[r + c] = diag2[rc] = false; // 恢复现场
            }
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/n-queens-ii/solutions/2381883/hui-su-miao-sha-nhuang-hou-yi-ge-shi-pin-l41l/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。