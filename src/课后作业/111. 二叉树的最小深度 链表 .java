// https://leetcode.cn/problems/minimum-depth-of-binary-tree/
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        if (root.left != null) {
            return minDepth(root.left) + 1;
        } else {
            return minDepth(root.right) + 1;
        }
    }
}

// 题解 题解好多 
// ttps://leetcode.cn/problems/minimum-depth-of-binary-tree/solution/liang-chong-fang-fa-zi-ding-xiang-xia-zi-0sxz/
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) { // root 是叶子
            return 1;
        }
        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
        return Math.min(leftDepth, rightDepth) + 1;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree/solutions/2730984/liang-chong-fang-fa-zi-ding-xiang-xia-zi-0sxz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



class Solution {
    private int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return root != null ? ans : 0;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node == null) {
            return;
        }
        cnt++;
        if (node.left == null && node.right == null) { // node 是叶子
            ans = Math.min(ans, cnt);
            return;
        }
        dfs(node.left, cnt);
        dfs(node.right, cnt);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree/solutions/2730984/liang-chong-fang-fa-zi-ding-xiang-xia-zi-0sxz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    private int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return root != null ? ans : 0;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node == null || ++cnt >= ans) { // 最优性剪枝
            return;
        }
        if (node.left == null && node.right == null) { // node 是叶子
            ans = cnt;
            return;
        }
        dfs(node.left, cnt);
        dfs(node.right, cnt);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree/solutions/2730984/liang-chong-fang-fa-zi-ding-xiang-xia-zi-0sxz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。