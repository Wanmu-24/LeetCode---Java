// https://leetcode.cn/problems/path-sum/description/
class Solution {

    private boolean ans = false;

    private int sum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        sum = targetSum;
        dfs(root,0);
        return ans;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node == null || ans == true) return;
        cnt += node.val;
        if (node.left == null && node.right == null && cnt == sum ) {
            ans = true;
            return;
        }
        dfs(node.left, cnt);
        dfs(node.right, cnt);
    }
}

// 题解
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) { // root 是叶子
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/path-sum/solutions/2731531/jian-ji-xie-fa-pythonjavacgojsrust-by-en-icwe/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。