class Solution {

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);
    }

}

// 题解
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(ans, node.left);  // 左
        ans.add(node.val);    // 根（这行代码移到前面就是前序，移到后面就是后序）
        dfs(ans, node.right); // 右
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/solutions/3844031/tu-jie-morris-bian-li-xian-suo-er-cha-sh-cm2s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。