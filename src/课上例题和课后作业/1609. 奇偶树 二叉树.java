class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            TreeNode pre = null;
            for (int i = 0; i < n ; i++) {
                TreeNode cur = q.poll();
                if (depth % 2 == cur.val % 2) return false;
                if (pre != null) {
                    if (depth % 2 == 0 && cur.val <= pre.val) {
                        return false;
                    }
                    if (depth % 2 == 1 && cur.val >= pre.val) {
                        return false;
                    }
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                pre = cur;
            }
            depth++;
        }
        return true;
    }
}
