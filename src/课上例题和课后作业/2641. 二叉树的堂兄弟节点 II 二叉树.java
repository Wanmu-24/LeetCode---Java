class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        root.val = 0;
        q.add(root);

        int currentLevelSum = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                node.val = node.val + currentLevelSum;
                int childrenSum = 0;
                if (node.left != null) {
                    q.offer(node.left);
                    childrenSum += node.left.val;
                    sum += node.left.val;
                }
                if (node.right != null) {
                    q.offer(node.right);
                    childrenSum += node.right.val;
                    sum += node.right.val;
                }
                if (node.left != null) node.left.val = -childrenSum;
                if (node.right != null) node.right.val = -childrenSum;
            }
            currentLevelSum = sum;
        }
        return root;
    }
}

// 题解
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        List<TreeNode> q = List.of(root);
        while (!q.isEmpty()) {
            List<TreeNode> tmp = q;
            q = new ArrayList<>();

            // 计算下一层的节点值之和
            int nextLevelSum = 0;
            for (TreeNode node : tmp) {
                if (node.left != null) {
                    q.add(node.left);
                    nextLevelSum += node.left.val;
                }
                if (node.right != null) {
                    q.add(node.right);
                    nextLevelSum += node.right.val;
                }
            }

            // 再次遍历，更新下一层的节点值
            for (TreeNode node : tmp) {
                int childrenSum = (node.left != null ? node.left.val : 0) +
                                  (node.right != null ? node.right.val : 0);
                if (node.left != null) node.left.val = nextLevelSum - childrenSum;
                if (node.right != null) node.right.val = nextLevelSum - childrenSum;
            }
        }
        return root;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/cousins-in-binary-tree-ii/solutions/2229010/bfssuan-liang-ci-pythonjavacgo-by-endles-b72a/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。