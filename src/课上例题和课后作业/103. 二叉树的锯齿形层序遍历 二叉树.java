class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> vals = new ArrayList<>(n); // 容量已知
            while (n-- > 0) {
                TreeNode node;
                if (ans.size() % 2 == 0) {
                    node = q.pollFirst();
                    if (node.left != null)  q.addLast(node.left);
                    if (node.right != null) q.addLast(node.right);
                } else {
                    node = q.pollLast();
                    if (node.right != null) q.addFirst(node.right);
                    if (node.left != null)  q.addFirst(node.left);
                }
                vals.add(node.val);
            }
            ans.add(vals);
        }
        return ans;
    }
}

// 题解
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> vals = new ArrayList<>(n); // 容量已知
            while (n-- > 0) {
                TreeNode node = q.poll();
                vals.add(node.val);
                if (node.left != null)  q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (ans.size() % 2 > 0) {
                Collections.reverse(vals);
            }
            ans.add(vals);
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/solutions/2049827/bfs-wei-shi-yao-yao-yong-dui-lie-yi-ge-s-xlv3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。