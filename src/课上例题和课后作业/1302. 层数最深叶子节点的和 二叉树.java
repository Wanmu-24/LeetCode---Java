class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int sum = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            sum = 0;
            while (n-- > 0) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    sum += node.val;
                    continue;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return sum;
    }
}

// 题解
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/deepest-leaves-sum/solutions/101761/ceng-shu-zui-shen-xie-zi-jie-dian-de-he-by-leetc-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。