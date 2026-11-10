class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int ans = root.val;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            ans = q.peek().val;
            while (n-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null)  q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return ans;
    }
}

// 题解
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.right != null) q.add(node.right);
            if (node.left != null)  q.add(node.left);
        }
        return node.val;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/find-bottom-left-tree-value/solutions/2049776/bfs-wei-shi-yao-yao-yong-dui-lie-yi-ge-s-f34y/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。