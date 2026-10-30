// https://leetcode.cn/problems/count-good-nodes-in-binary-tree/description/

class Solution {
    private int ans = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }
    public void dfs(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            ans++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right,max);
    }
}

// https://leetcode.cn/problems/count-good-nodes-in-binary-tree/solutions/2403677/jian-ji-xie-fa-pythonjavacgojs-by-endles-gwxt/
// 题解
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE); // 也可以写 root.val
    }

    private int dfs(TreeNode root, int mx) {
        if (root == null)
            return 0;
        int left = dfs(root.left, Math.max(mx, root.val));
        int right = dfs(root.right, Math.max(mx, root.val));
        return left + right + (mx <= root.val ? 1 : 0);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/count-good-nodes-in-binary-tree/solutions/2403677/jian-ji-xie-fa-pythonjavacgojs-by-endles-gwxt/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。