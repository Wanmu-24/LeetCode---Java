// https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/
class Solution {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node == null) {
            return;
        }
        cnt += node.val; 
        if (node.left == null && node.right == null) {
            sum += cnt;
        }
        dfs(node.left, cnt * 10);
        dfs(node.right, cnt * 10);

    }
}

// 题解
// 写法一：没有返回值
class Solution {
    private int ans;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int x) {
        if (node == null) {
            return;
        }
        x = x * 10 + node.val;
        if (node.left == null && node.right == null) { // node 是叶子节点
            ans += x;
            return;
        }
        dfs(node.left, x);
        dfs(node.right, x);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/sum-root-to-leaf-numbers/solutions/2730644/jian-ji-xie-fa-pythonjavacgojsrust-by-en-gbu9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 写法二：有返回值
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        x = x * 10 + node.val;
        if (node.left == null && node.right == null) { // node 是叶子节点
            return x;
        }
        return dfs(node.left, x) + dfs(node.right, x);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/sum-root-to-leaf-numbers/solutions/2730644/jian-ji-xie-fa-pythonjavacgojsrust-by-en-gbu9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。