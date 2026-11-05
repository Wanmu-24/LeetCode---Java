// https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/

// 题解
class Solution {
    private int ans = Integer.MAX_VALUE;
    private int pre = Integer.MIN_VALUE / 2; // 防止减法溢出

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        ans = Math.min(ans, node.val - pre);
        pre = node.val;
        dfs(node.right);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimum-absolute-difference-in-bst/solutions/3038197/zhong-xu-bian-li-jian-ji-xie-fa-pythonja-3pwf/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 虽然因为题目的数据范围原因，过了。 但是pre 应该初始化为 Integer.MIN_VALUE / 2 才对 能应付更多情况
class Solution {

    int pre = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        int cnt = Math.abs(node.val - pre);
        ans = Math.min(cnt, ans);
        pre = node.val;
        dfs(node.right);
    }
}