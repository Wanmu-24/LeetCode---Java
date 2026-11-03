// https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/description/
class Solution {

    private int lmt;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        lmt = limit;
        if (dfs(root,0)) {
            return root;
        } else {
            return null;
        }
    }

    // dfs 表示 判断node当前节点要不要保留（即不是不足节点） 
    private boolean dfs(TreeNode node, int num) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return num + node.val >= lmt;
        }
        boolean left = dfs(node.left, num + node.val);
        boolean right = dfs(node.right, num + node.val);
        if (left == false) {
            node.left = null;
        }
        if (right == false) {
            node.right = null;
        }
        return left || right;
    }
}

// 题解
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        if (root.left == null && root.right == null) { // root 是叶子
            // 如果 limit > 0 说明从根到叶子的路径和小于 limit，删除叶子，否则不删除
            return limit > 0 ? null : root;
        }
        if (root.left != null) root.left = sufficientSubset(root.left, limit);
        if (root.right != null) root.right = sufficientSubset(root.right, limit);
        // 如果儿子都被删除，就删 root，否则不删 root
        return root.left == null && root.right == null ? null : root;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/solutions/2278769/jian-ji-xie-fa-diao-yong-zi-shen-pythonj-64lf/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。