// https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/description/
// 自己写过了 可惜复杂度不是最优 是NlogN 没事 过了总比没过强
class Solution {

    private int ans = 0;
    TreeSet<Integer> set = new TreeSet<>();

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        boolean flag = !set.contains(node.val);
        set.add(node.val);
        int cnt = set.last() - set.first();
        ans = Math.max(cnt, ans);
        dfs(node.left);
        dfs(node.right);
        if (flag) {
            set.remove(node.val);
        }
    }
}

// 题解
class Solution {
    private int ans;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int mn, int mx) {
        if (node == null) return;
        // 虽然题目要求「不同节点」，但是相同节点的差值为 0，不会影响最大差值
        // 所以先更新 mn 和 mx，再计算差值也是可以的
        // 在这种情况下，一定满足 mn <= node.val <= mx
        mn = Math.min(mn, node.val);
        mx = Math.max(mx, node.val);
        ans = Math.max(ans, Math.max(node.val - mn, mx - node.val));
        dfs(node.left, mn, mx);
        dfs(node.right, mn, mx);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/solutions/2232367/liang-chong-fang-fa-zi-ding-xiang-xia-zi-wj9v/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 优化
class Solution {
    private int ans;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int mn, int mx) {
        if (node == null) {
            ans = Math.max(ans, mx - mn);
            return;
        }
        mn = Math.min(mn, node.val);
        mx = Math.max(mx, node.val);
        dfs(node.left, mn, mx);
        dfs(node.right, mn, mx);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/solutions/2232367/liang-chong-fang-fa-zi-ding-xiang-xia-zi-wj9v/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 其实我觉得这样可能对我好理解一点
class Solution {

    private int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode node, int mx, int mn) {
        if (node == null) {
            return;
        }
        mx = Math.max(node.val, mx);
        mn = Math.min(node.val, mn);
        if (node.left == null && node.right == null) {
            ans = Math.max(ans, mx - mn);
            return;
        }
        dfs(node.left, mx, mn);
        dfs(node.right, mx, mn);
    }
}

// 第二种题解方法
class Solution {
    private int ans;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) { // 需要保证空节点不影响 mn 和 mx
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] p = dfs(node.left);
        int[] q = dfs(node.right);
        int mn = Math.min(node.val, Math.min(p[0], q[0]));
        int mx = Math.max(node.val, Math.max(p[1], q[1]));
        ans = Math.max(ans, Math.max(node.val - mn, mx - node.val));
        return new int[]{mn, mx};
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/solutions/2232367/liang-chong-fang-fa-zi-ding-xiang-xia-zi-wj9v/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。