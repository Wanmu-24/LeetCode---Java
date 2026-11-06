class Solution {

    private int ans;
    private int cnt;

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode node) {
        if (node == null || cnt <= 0) return;
        dfs(node.left);
        if (cnt == 1) {
            ans = node.val;
        }
        cnt--;
        dfs(node.right);
    }
}

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/2952810/zhong-xu-bian-li-pythonjavaccgojsrust-by-wc02/?envType=study-plan-v2&envId=top-100-liked
// 题解
class Solution {
    private int ans;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null || k <= 0) {
            return;
        }
        dfs(node.left); // 左
        if (--k == 0) {
            ans = node.val; // 根
        }
        dfs(node.right); // 右
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/2952810/zhong-xu-bian-li-pythonjavaccgojsrust-by-wc02/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1; // 题目保证节点值非负，用 -1 表示没有找到
        }
        int leftRes = dfs(node.left);
        if (leftRes != -1) { // 答案在左子树中
            return leftRes;
        }
        if (--k == 0) { // 答案就是当前节点
            return node.val;
        }
        return dfs(node.right); // 右子树会返回答案或者 -1
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/2952810/zhong-xu-bian-li-pythonjavaccgojsrust-by-wc02/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。