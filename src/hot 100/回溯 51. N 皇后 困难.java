// 题解
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n]; // 皇后放在 (r,queens[r])
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n * 2 - 1];
        boolean[] diag2 = new boolean[n * 2 - 1];
        dfs(0, queens, col, diag1, diag2, ans);
        return ans;
    }

    private void dfs(int r, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> ans) {
        int n = col.length;
        if (r == n) {
            List<String> board = new ArrayList<>(n); // 预分配空间
            for (int c : queens) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            ans.add(board);
            return;
        }
        // 在 (r,c) 放皇后
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!col[c] && !diag1[r + c] && !diag2[rc]) { // 判断能否放皇后
                queens[r] = c; // 直接覆盖，无需恢复现场
                col[c] = diag1[r + c] = diag2[rc] = true; // 皇后占用了 c 列和两条斜线
                dfs(r + 1, queens, col, diag1, diag2, ans);
                col[c] = diag1[r + c] = diag2[rc] = false; // 恢复现场
            }
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/n-queens/solutions/2079586/hui-su-tao-lu-miao-sha-nhuang-hou-shi-pi-mljv/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// 自己写的循环遍历
class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] b = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, n, b, path, ans);
        return ans;
    }

    private void dfs(int i, int n, boolean[][] b, List<String> path, List<List<String>> ans) {
        if (i == n) {
            ans.add(new ArrayList(path));
            return;
        }
        char[] arr = new char[n];
        Arrays.fill(arr, '.');
        for(int j = 0; j < n; j++) {
            if (isOk(b, i, j, n)) {
                b[i][j] = true;
                arr[j] = 'Q'; 
                path.add(new String(arr));
                dfs(i + 1, n, b, path, ans);
                b[i][j] = false;
                arr[j] = '.'; 
                path.removeLast();
            }
        }
    }
    private boolean isOk(boolean[][] b, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if (b[k][j]) return false;
        }
        // for (int k = i + 1, m = j + 1; k < n && m < n; k++, m++) {
        //     if (b[k][m]) return false;
        // }
        for (int k = i - 1, m = j - 1; k >= 0 && m >= 0; k--, m--) {
            if (b[k][m]) return false;
        }
        for (int k = i - 1, m = j + 1; k >= 0 && m < n; k--, m++) {
            if (b[k][m]) return false;
        }
        // for (int k = i + 1, m = j - 1; k < n && m >= 0; k++, m--) {
        //     if (b[k][m]) return false;
        // }
        return true;
    }
}