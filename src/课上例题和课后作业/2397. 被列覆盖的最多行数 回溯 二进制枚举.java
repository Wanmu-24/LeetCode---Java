// 题解
class Solution {
    public int maximumRows(int[][] mat, int numSelect) {
        int m = mat.length, n = mat[0].length;
        int[] mask = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mask[i] |= mat[i][j] << j;
            }
        }

        int ans = 0;
        for (int subset = 0; subset < (1 << n); subset++) {
            if (Integer.bitCount(subset) == numSelect) {
                int coveredRows = 0;
                for (int row : mask) {
                    if ((row & subset) == row) {
                        coveredRows++;
                    }
                }
                ans = Math.max(ans, coveredRows);
            }
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public int maximumRows(int[][] mat, int numSelect) {
        int m = mat.length, n = mat[0].length;
        int[] mask = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mask[i] |= mat[i][j] << j;
            }
        }

        int ans = 0;
        int subset = (1 << numSelect) - 1;
        while (subset < (1 << n)) {
            int coveredRows = 0;
            for (int row : mask) {
                if ((row & subset) == row) {
                    coveredRows++;
                }
            }
            ans = Math.max(ans, coveredRows);
            int lb = subset & -subset;
            int x = subset + lb;
            subset = ((subset ^ x) / lb >> 2) | x;
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 自己写的 但是是回溯 还是看题解吧
class Solution {

    private int ans = 0;

    public int maximumRows(int[][] matrix, int numSelect) {
        dfs(0, matrix, numSelect);
        return ans;
    }

    // col 表示第几列 
    // numSelect 表示还有几个没选
    private void dfs(int col, int[][] matrix, int numSelect) {
        // if (col == matrix[0].length || numSelect == 0) {
        if (numSelect == 0) {
            int cnt = 0;
            for (int i = 0; i < matrix.length; i++) {
                // boolean isAdd = true;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 1) {
                        // 用来抵消下面的cnt++;
                        cnt--;
                        break;
                    }
                }
                cnt++;
                // if (isAdd) cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }
        if (col == matrix[0].length) return;

        // 不选第col列 进入第col + 1列
        dfs(col + 1, matrix, numSelect);

        
        // 备份原始列数据 并把 1 改成0 当作被列覆盖
        int row = matrix.length;
        int[] cols = new int[row];
        for(int i = 0; i < row; i++) {
            cols[i] = matrix[i][col];
            matrix[i][col] = 0;
        }

        // 选第col列 进入第col + 1列
        dfs(col + 1, matrix, numSelect - 1);

        // 复原原始数据
        for(int i = 0; i < row; i++) {
            matrix[i][col] = cols[i];
        }
    }
}