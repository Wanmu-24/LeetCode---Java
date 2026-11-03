// https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/description/
// 想复杂了 没写出来
// 应该考虑没有交错的条件怎么先，再考虑有了交错有什么限制 该怎么改 这样好想还简单一点

// 题解 DeepSeek 写的
class Solution {
    private int ans = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        // 从根节点出发。根节点没有父节点，所以传 false / true 都行，长度初始为 0
        dfs(root, false, 0); 
        dfs(root, true, 0);
        return ans;
    }

    // isLeft 表示：当前节点是不是它父节点的左孩子（即上一步是不是往左走的）
    // len 表示：到达当前节点时，已经连续交错的步数（边数）
    private void dfs(TreeNode node, boolean isLeft, int len) {
        // 更新全局最大值
        ans = Math.max(ans, len);

        // 尝试往左走，到达 node.left 时，它就是父节点的左孩子，所以 isLeft 传 true
        // 如果上一步也是往左走 (isLeft == true)，那就断开了，长度重置为 1
        // 如果上一步是往右走 (isLeft == false)，那就连上了，长度 + 1
        if (node.left != null) {
            dfs(node.left, true, isLeft ? 1 : len + 1);
        }

        // 尝试往右走，到达 node.right 时，它就是父节点的右孩子，所以 isLeft 传 false
        // 如果上一步是往右走 (isLeft == false)，那就断开了，长度重置为 1
        // 如果上一步是往左走 (isLeft == true)，那就连上了，长度 + 1
        if (node.right != null) {
            dfs(node.right, false, isLeft ? len + 1 : 1);
        }
    }
}

// 第二种题解
class Solution {
    private int ans = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 返回数组 res，res[0] 表示以当前节点为起点向左走的最长交错路径，res[1] 表示向右走
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{-1, -1}; // 空节点返回 -1，这样父节点加 1 后刚好是 0
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        // 往左走：当前节点(1步) + 左孩子的向右走(left[1])
        int goLeft = left[1] + 1;
        // 往右走：当前节点(1步) + 右孩子的向左走(right[0])
        int goRight = right[0] + 1;
        
        ans = Math.max(ans, Math.max(goLeft, goRight));
        
        return new int[]{goLeft, goRight};
    }
}
// 其实我一开始的思路是第二种。可是确实不好想、不好写。对我来说