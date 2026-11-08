// 没写出来

// 题解
class Solution {
    private TreeNode ans;
    private int maxDepth = -1; // 全局最大深度

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth); // 维护全局最大深度
            return depth;
        }
        int leftMaxDepth = dfs(node.left, depth + 1); // 左子树最深空节点的深度
        int rightMaxDepth = dfs(node.right, depth + 1); // 右子树最深空节点的深度
        if (leftMaxDepth == rightMaxDepth && leftMaxDepth == maxDepth) { // 最深的空节点左右子树都有
            ans = node; // 如果后面发现了更大的 maxDepth，答案还会更新
        }
        return Math.max(leftMaxDepth, rightMaxDepth); // 当前子树最深空节点的深度
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/solutions/2428724/liang-chong-di-gui-si-lu-pythonjavacgojs-xxnk/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getValue();
    }

    private Pair<Integer, TreeNode> dfs(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, null);
        }
        Pair<Integer, TreeNode> left = dfs(node.left);
        Pair<Integer, TreeNode> right = dfs(node.right);
        if (left.getKey() > right.getKey()) { // 左子树更高
            return new Pair<>(left.getKey() + 1, left.getValue());
        }
        if (left.getKey() < right.getKey()) { // 右子树更高
            return new Pair<>(right.getKey() + 1, right.getValue());
        }
        return new Pair<>(left.getKey() + 1, node); // 一样高
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/solutions/2428724/liang-chong-di-gui-si-lu-pythonjavacgojs-xxnk/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。