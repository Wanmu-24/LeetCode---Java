// 自己写过了 但是和题解标注思路不一样 想了想 题解的更清晰易读 以题解为准
// 题解
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> ans) {
        if (node == null) {
            return;
        }
        int len = path.length(); // 记录当前长度，用于回溯
        path.append(node.val);
        if (node.left == null && node.right == null) { // 叶子节点
            ans.add(path.toString());
        } else {
            path.append("->");
            dfs(node.left, path, ans);
            dfs(node.right, path, ans);
        }
        path.setLength(len); // 回溯，恢复现场
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/binary-tree-paths/solutions/3038189/liang-chong-xie-fa-lu-jing-wei-can-shu-h-q2wz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 自己根据题解思路又写一遍
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(root, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> ans) {
        if (node == null) return;
        int len = path.length();
        path.append(node.val);
        if (node.left == null && node.right == null) {
            ans.add(new String(path));
        } else {
            path.append("->");
            dfs(node.left, path, ans);
            dfs(node.right, path, ans);
        }
        path.setLength(len);
        return;
    }
}