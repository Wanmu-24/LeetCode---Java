// 自己写过了 但是和题解标注思路不一样 想了想 题解的更清晰易读 以题解为准
// 题解
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, int left, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        left -= node.val;
        if (node.left == null && node.right == null && left == 0) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(node.left, left, path, ans);
            dfs(node.right, left, path, ans);
        }
        path.remove(path.size() - 1);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/path-sum-ii/solutions/3061294/hui-su-fu-chang-jian-wen-ti-ji-qi-jie-da-g8im/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 自己根据题解思路又写一遍
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) {
        	return;
        }
        path.add(node.val);
        targetSum -= node.val;
        if (node.left == null && node.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(node.left, targetSum, path, ans);
            dfs(node.right, targetSum, path, ans);
        }
        path.removeLast();
    }
}