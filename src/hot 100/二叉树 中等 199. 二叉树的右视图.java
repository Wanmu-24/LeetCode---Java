// https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked
class Solution {

    private List<Integer> ans = new ArrayList<>();

    private int depth = -1;

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode node, int curDepth) {
        if (node == null) {
            return;
        }
        if (curDepth > depth) {
            ans.add(node.val);
            depth = curDepth;
        }
        dfs(node.right, curDepth + 1);
        dfs(node.left, curDepth + 1);
    }

}

// 题解
// BFS 层序遍历
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<Integer> ans = new ArrayList<>();
        List<TreeNode> cur = List.of(root);
        while (!cur.isEmpty()) {
            ans.add(cur.getLast().val);
            List<TreeNode> nxt = new ArrayList<>();
            for (TreeNode node : cur) {
                if (node.left != null)  nxt.add(node.left);
                if (node.right != null) nxt.add(node.right);
            }
            cur = nxt;
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/binary-tree-right-side-view/solutions/2015061/ru-he-ling-huo-yun-yong-di-gui-lai-kan-s-r1nc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// DFS递归
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (depth == ans.size()) { // 这个深度首次遇到
            ans.add(root.val);
        }
        dfs(root.right, depth + 1, ans); // 先递归右子树，保证首次遇到的一定是最右边的节点
        dfs(root.left, depth + 1, ans);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/binary-tree-right-side-view/solutions/2015061/ru-he-ling-huo-yun-yong-di-gui-lai-kan-s-r1nc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。