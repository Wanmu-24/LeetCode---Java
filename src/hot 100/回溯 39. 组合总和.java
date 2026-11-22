// 自己写的
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, target, candidates, path, ans);
        return ans;
    }

    private void dfs(int i, int target, int[] candidates, List<Integer> path, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (i >= candidates.length || candidates[i] > target) {
            return;
        }
        
        // 上面判断了 candidates 一定小于等于 target 这里好像不用判断了
        // 选第i个
        path.add(candidates[i]);
        dfs(i, target - candidates[i], candidates, path, ans);
        path.removeLast();

        // 不选第i个 选下一个
        dfs(i + 1, target, candidates, path, ans);
    }
}

// 题解
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, target, candidates, ans, path);
        return ans;
    }

    private void dfs(int i, int left, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
        if (left == 0) {
            // 找到一个合法组合
            ans.add(new ArrayList<>(path));
            return;
        }

        if (i == candidates.length || left < 0) {
            return;
        }

        // 不选
        dfs(i + 1, left, candidates, ans, path);

        // 选
        path.add(candidates[i]);
        dfs(i, left - candidates[i], candidates, ans, path);
        path.remove(path.size() - 1); // 恢复现场
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/combination-sum/solutions/2747858/liang-chong-fang-fa-xuan-huo-bu-xuan-mei-mhf9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。