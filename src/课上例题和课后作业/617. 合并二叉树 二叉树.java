// https://leetcode.cn/problems/merge-two-binary-trees/description/
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 != null && root2 != null) {
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        return root1 != null ? root1 : root2;
    }
}

class Solution {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 != null && root2 != null) {
            TreeNode cur = new TreeNode(root1.val + root2.val);
            cur.left = mergeTrees(root1.left, root2.left);
            cur.right = mergeTrees(root1.right, root2.right);
            return cur;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        return root1 != null ? root1 : root2;
    }
}

// 题解
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        return new TreeNode(root1.val + root2.val,
            mergeTrees(root1.left, root2.left),    // 合并左子树
            mergeTrees(root1.right, root2.right)); // 合并右子树
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/merge-two-binary-trees/solutions/2387255/kan-dao-di-gui-jiu-yun-dai-ni-li-jie-di-leixm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);    // 合并左子树
        root1.right = mergeTrees(root1.right, root2.right); // 合并右子树
        return root1;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/merge-two-binary-trees/solutions/2387255/kan-dao-di-gui-jiu-yun-dai-ni-li-jie-di-leixm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。