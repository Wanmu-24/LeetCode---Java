// 题解
// 方法一：枚举选哪个
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(k);
        dfs(9, n, k, ans, path); // 从 i=9 开始倒着枚举
        return ans;
    }

    private void dfs(int i, int leftSum, int k, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size(); // 还要选 d 个数
        if (leftSum < 0 || leftSum > (i * 2 - d + 1) * d / 2) { // 剪枝
            return;
        }
        if (d == 0) { // 找到一个合法组合
            ans.add(new ArrayList<>(path));
            return;
        }
        // 枚举的数不能太小，否则后面没有数可以选
        for (int j = i; j >= d; j--) {
            path.add(j);
            dfs(j - 1, leftSum - j, k, ans, path);
            path.removeLast(); // path.remove(path.size() - 1);
        }
    }
}
作者：灵茶山艾府
链接：https://leetcode.cn/problems/combination-sum-iii/solutions/2071013/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-feme/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 方法二：选或不选
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(k);
        dfs(9, n, k, ans, path);
        return ans;
    }

    private void dfs(int i, int leftSum, int k, List<List<Integer>> ans, List<Integer> path) {
        int d = k - path.size(); // 还要选 d 个数
        if (leftSum < 0 || leftSum > (i * 2 - d + 1) * d / 2) { // 剪枝
            return;
        }
        if (d == 0) { // 找到一个合法组合
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不选 i
        if (i > d) {
            dfs(i - 1, leftSum, k, ans, path);
        }

        // 选 i
        path.add(i);
        dfs(i - 1, leftSum - i, k, ans, path);
        path.removeLast(); // path.remove(path.size() - 1);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/combination-sum-iii/solutions/2071013/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-feme/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(9, 0, n, k, path, ans);
        return ans;
    }

    // 选或不选
    private void dfs(int num, int total, int n, int k, List<Integer> path, List<List<Integer>> ans) {
        if (k == 0) {
            if (total == n) ans.add(new ArrayList<>(path));
            return;
        }
        if (k > num) return;

        // 不选
        dfs(num - 1, total, n, k, path, ans);

        // 选
        path.add(num);
        dfs(num - 1, total + num, n, k - 1, path, ans);
        path.removeLast();
    }
}
