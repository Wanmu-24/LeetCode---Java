// https://leetcode.cn/problems/invert-binary-tree/solutions/2713610/shi-pin-shen-ru-li-jie-di-gui-pythonjava-zhqh/

// 题解
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left); // 翻转左子树
        TreeNode right = invertTree(root.right); // 翻转右子树
        root.left = right; // 交换左右儿子
        root.right = left;
        return root;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/invert-binary-tree/solutions/2713610/shi-pin-shen-ru-li-jie-di-gui-pythonjava-zhqh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left; // 交换左右儿子
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left); // 翻转左子树
        invertTree(root.right); // 翻转右子树
        return root;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/invert-binary-tree/solutions/2713610/shi-pin-shen-ru-li-jie-di-gui-pythonjava-zhqh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 自己第一次提交
class Solution {

    private TreeNode ans = null;

    public TreeNode invertTree(TreeNode root) {
        ans = root;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode leftNode = node.left;
        node.left = node.right;
        node.right = leftNode;
        dfs(node.left);
        dfs(node.right);
    }
}