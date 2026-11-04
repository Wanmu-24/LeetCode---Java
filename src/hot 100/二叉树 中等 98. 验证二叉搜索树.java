// 写了个最不好理解的后序遍历 虽然时间复杂度应该是一样的 但是可能不熟悉 导致用了1毫秒
class Solution {

    private boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // 返回值为 从node往下的 最大值和最小值
    private long[] dfs(TreeNode node) {
        if (node == null) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        // node.left 开始 的最大值和最小值 
        // 数组0是最大值 1是最小值
        long[] l = dfs(node.left);
        if (ans == false) {
            // 提前结束
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        long[] r = dfs(node.right);
        if (ans == false) {
            // 提前结束
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        if (node.val <= l[0] || node.val >= r[1]) {
            ans = false;
        }
        return new long[] {Math.max(Math.max(l[0],r[0]),node.val),Math.min(Math.min(l[1],r[1]),node.val)};
    }
}

// 题解
// 方法一：前序遍历
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        long x = node.val;
        return left < x && x < right &&
               isValidBST(node.left, left, x) &&
               isValidBST(node.right, x, right);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/validate-binary-search-tree/solutions/2020306/qian-xu-zhong-xu-hou-xu-san-chong-fang-f-yxvh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 方法二：中序遍历
class Solution {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) { // 左
            return false;
        }
        if (root.val <= pre) { // 中
            return false;
        }
        pre = root.val;
        return isValidBST(root.right); // 右
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/validate-binary-search-tree/solutions/2020306/qian-xu-zhong-xu-hou-xu-san-chong-fang-f-yxvh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 方法三：后序遍历
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root)[1] != Long.MAX_VALUE;
    }

    private long[] dfs(TreeNode node) {
        if (node == null) {
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = dfs(node.left);
        long[] right = dfs(node.right);
        long x = node.val;
        // 也可以在递归完左子树之后立刻判断，如果发现不是二叉搜索树，就不用递归右子树了
        if (x <= left[1] || x >= right[0]) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[]{Math.min(left[0], x), Math.max(right[1], x)};
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/validate-binary-search-tree/solutions/2020306/qian-xu-zhong-xu-hou-xu-san-chong-fang-f-yxvh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。