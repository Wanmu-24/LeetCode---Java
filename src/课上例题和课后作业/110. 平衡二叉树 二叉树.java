// https://leetcode.cn/problems/balanced-binary-tree/description/
// 自己过是过了 不过 时间复杂度是O(n²) 还是看题解吧


//题解
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftH = getHeight(node.left);
        if (leftH == -1) {
            return -1; // 提前退出，不再递归
        }
        int rightH = getHeight(node.right);
        if (rightH == -1 || Math.abs(leftH - rightH) > 1) {
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/balanced-binary-tree/solutions/2015068/ru-he-ling-huo-yun-yong-di-gui-lai-kan-s-c3wj/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。