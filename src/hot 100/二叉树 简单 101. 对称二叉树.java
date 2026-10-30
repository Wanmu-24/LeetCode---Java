// https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode lNode, TreeNode rNode) {
        if (lNode == null || rNode == null) {
            return lNode == rNode;
        }
        return lNode.val == rNode.val && dfs(lNode.left,rNode.right) && dfs(lNode.right, rNode.left);
    }
    
}

// 题解
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    // 100. 相同的树（改成镜像判断）
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/symmetric-tree/solutions/2015063/ru-he-ling-huo-yun-yong-di-gui-lai-kan-s-6dq5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。