// https://leetcode.cn/problems/sum-of-left-leaves/
// 第一次写 非常冗余的代码
class Solution {

    private int ans = 0;
    // 求根节点的所以左叶子和 不包括根节点
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root.left, true);
        dfs(root.right,false);
        return ans;
    }

    private void dfs(TreeNode root, Boolean flag) {
        if (root == null) {
            return;
        }
        if(flag && root.left == null && root.right == null) {
            ans += root.val;
            return;
        }
        dfs(root.left,true);
        dfs(root.right,false);
        return;
    }
}

// 题解
// https://leetcode.cn/problems/sum-of-left-leaves/solutions/3751068/jian-dan-ti-jian-dan-zuo-pythonjavaccgoj-w8st/
class Solution {
    private int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        // 递归，寻找左叶子
        dfs(node.left);
        dfs(node.right);

        TreeNode left = node.left; // 当前节点的左儿子
        if (left != null && left.left == null && left.right == null) { // 当前节点的左儿子是叶子
            ans += left.val; // 累加节点值
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/sum-of-left-leaves/submissions/757230129/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) { // 空节点
            return 0;
        }

        // 递归左右子树，收集左右子树中的「节点的左儿子是叶子」的叶子节点值之和
        int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

        TreeNode left = root.left; // 当前节点的左儿子
        if (left != null && left.left == null && left.right == null) { // 当前节点的左儿子是叶子
            sum += left.val; // 累加节点值
        }

        return sum;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/sum-of-left-leaves/submissions/757230129/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//第二种写法错误示范
class Solution {
    // 求根节点的所有左叶子和 不包括根节点
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null) { // 当前节点的左儿子是叶子
            return left.val; // 累加节点值
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
// 这样要是root的左节点一开始就是叶子会导致直接return
// 所以才要先递归 左右子树，收集左右子树中的「节点的左儿子是叶子」的叶子节点值之和 int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
// 最后再TreeNode left = root.left;……



// 但是再第一种写法中 可以这样
// 先判断自己的左节点是不是叶子 是就加入 我认为这样方便理解阅读一点
// 因为一开始是根节点 root root不会作为左叶子节点 所以可以保证不多不漏
class Solution {
    private int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }
    // 判断当前这个node节点的左节点是不是叶子 是就加入
    // 然后继续遍历左右节点
    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode left = node.left;
        if (left != null && left.left == null && left.right == null) { // 当前节点的左儿子是叶子
            ans += left.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
