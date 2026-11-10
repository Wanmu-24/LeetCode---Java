// 题解

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> a = new ArrayList<>();
        List<TreeNode> q = List.of(root);
        while (!q.isEmpty()) {
            long sum = 0;
            List<TreeNode> tmp = q;
            q = new ArrayList<>();
            for (TreeNode node : tmp) {
                sum += node.val;
                if (node.left != null)  q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            a.add(sum);
        }
        int n = a.size();
        if (k > n) {
            return -1;
        }
        Collections.sort(a);
        return a.get(n - k);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/kth-largest-sum-in-a-binary-tree/solutions/2650642/bfspai-xu-kuai-su-xuan-ze-pythonjavacgoj-kl5c/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。