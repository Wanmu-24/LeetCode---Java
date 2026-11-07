// 写出来了 但是比较杂乱 都是if else 还是看题解吧

// 题解
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        Set<Integer> s = new HashSet<Integer>();
        for (int x : toDelete) s.add(x);
        if (dfs(ans, s, root) != null) ans.add(root);
        return ans;
    }

    private TreeNode dfs(List<TreeNode> ans, Set<Integer> s, TreeNode node) {
        if (node == null) return null;
        node.left = dfs(ans, s, node.left);
        node.right = dfs(ans, s, node.right);
        if (!s.contains(node.val)) return node;
        if (node.left != null) ans.add(node.left);
        if (node.right != null) ans.add(node.right);
        return null;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/delete-nodes-and-return-forest/solutions/2289131/he-shi-ji-lu-da-an-pythonjavacgo-by-endl-lpcd/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。