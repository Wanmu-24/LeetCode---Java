// 方法一：枚举当前位置填左括号还是右括号
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n * 2]; // 所有括号长度都是一样的 2n
        dfs(0, 0, n, path, ans); // 一开始没有填括号
        return ans;
    }

    // 目前填了 left 个左括号，right 个右括号
    private void dfs(int left, int right, int n, char[] path, List<String> ans) {
        if (right == n) { // 填完 2n 个括号
            ans.add(new String(path));
            return;
        }
        if (left < n) { // 可以填左括号
            path[left + right] = '('; // 直接覆盖
            dfs(left + 1, right, n, path, ans);
        }
        if (right < left) { // 可以填右括号
            path[left + right] = ')'; // 直接覆盖
            dfs(left, right + 1, n, path, ans);
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/generate-parentheses/solutions/2071015/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-wcdw/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。