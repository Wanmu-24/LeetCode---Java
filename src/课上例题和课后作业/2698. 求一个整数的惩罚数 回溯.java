// 自己写的执行太慢了 还是看题解吧
class Solution {
    private static final int[] PRE_SUM = new int[1001];

    static {
        for (int i = 1; i <= 1000; i++) {
            char[] s = Integer.toString(i * i).toCharArray();
            PRE_SUM[i] = PRE_SUM[i - 1] + (dfs(s, i, 0, 0) ? i * i : 0);
        }
    }

    private static boolean dfs(char[] s, int i, int p, int sum) {
        if (p == s.length) { // 递归终点
            return sum == i; // i 符合要求
        }
        int x = 0;
        for (int j = p; j < s.length; j++) { // 枚举分割出从 s[p] 到 s[j] 的子串
            x = x * 10 + s[j] - '0'; // 子串对应的整数值
            if (dfs(s, i, j + 1, sum + x)) {
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        return PRE_SUM[n];
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/solutions/2277792/yu-chu-li-hui-su-by-endlesscheng-ro3s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 自己写的
class Solution {

    private int ans = 0;

    private boolean[] b = new boolean[1005];

    public int punishmentNumber(int n) {
        for(int j = 1; j <= n; j++) {
            String s = String.valueOf(j * j);
            isPunishment(0, 0, j, s, new int[s.length()]);
        }
        return ans;
    }

    // n 是数字
    // start字符串第一个没被分割的下标
    // i 当前下标
    private void isPunishment(int start, int i, int n, String s, int[] arr) {
        if (i == s.length()) {
            int cnt = 0;
            for(int num : arr) {
                cnt += num;
            }
            if (cnt == n && b[n] == false) {
                ans += n * n;
                b[n] = true;
            }
            return;
        }

        // 最后一个必须截取
        if(i == s.length() - 1) {
            arr[i] = Integer.parseInt(s.substring(start, i + 1));
            isPunishment(i + 1, i + 1, n, s, arr);
            //恢复
            arr[i] = 0;
        } else {
            // 不截取
            isPunishment(start, i + 1, n, s, arr);

            // 截取
            arr[i] = Integer.parseInt(s.substring(start, i + 1));
            isPunishment(i + 1, i + 1, n, s, arr);
            arr[i] = 0;
        }

        
    }
}