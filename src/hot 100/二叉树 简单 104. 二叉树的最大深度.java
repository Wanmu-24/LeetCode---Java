// 课上例题
// 自己又写一遍
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}

class Solution {

    int ans = 0;

    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        ans = Math.max(ans, depth);
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}

// 题解
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth, rDepth) + 1;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/solutions/2010612/kan-wan-zhe-ge-shi-pin-rang-ni-dui-di-gu-44uz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    private int ans;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        depth++;
        ans = Math.max(ans, depth);
        dfs(node.left, depth);
        dfs(node.right, depth);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree/solutions/2010612/kan-wan-zhe-ge-shi-pin-rang-ni-dui-di-gu-44uz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。