// 方法一：枚举下一个数选哪个 题解
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, path, ans); // 从 n 开始倒着枚举，这样 dfs 中就不需要 n 了，少传一个参数
        return ans;
    }

    // 枚举选哪个：在 1 到 i 中选一个数，加到 path 末尾
    private void dfs(int i, int k, List<Integer> path, List<List<Integer>> ans) {
        int d = k - path.size(); // 还要选 d 个数
        if (d == 0) { // 选好了
            ans.add(new ArrayList<>(path));
            return;
        }

        // 枚举的数不能太小，否则后面没有数可以选
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, k, path, ans);
            path.removeLast(); // path.remove(path.size() - 1);
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/combinations/solutions/2071017/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-65lh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 方法二：选或不选
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, path, ans); // 从 n 开始倒着枚举，这样 dfs 中就不需要 n 了，少传一个参数
        return ans;
    }

    // 选或不选：讨论 i 是否加入 path
    private void dfs(int i, int k, List<Integer> path, List<List<Integer>> ans) {
        int d = k - path.size(); // 还要选 d 个数
        if (d == 0) { // 选好了
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不选 i
        if (i > d) {
            dfs(i - 1, k, path, ans);
        }

        // 选 i
        path.add(i);
        dfs(i - 1, k, path, ans);
        path.removeLast(); // path.remove(path.size() - 1);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/combinations/solutions/2071017/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-65lh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。