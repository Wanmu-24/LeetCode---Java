// 例题
// 题解
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> path = Arrays.asList(new Integer[n]); // 所有排列的长度都是一样的 n
        boolean[] onPath = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, nums, ans, path, onPath);
        return ans;
    }

    // 枚举 path[i] 填 nums 的哪个数
    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!onPath[j]) {
                path.set(i, nums[j]); // 从没有选的数字中选一个
                onPath[j] = true; // 已选上
                dfs(i + 1, nums, ans, path, onPath);
                onPath[j] = false; // 恢复现场
                // 注意 path 无需恢复现场，因为排列长度固定，直接覆盖就行
            }
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/permutations/solutions/2079585/hui-su-bu-hui-xie-tao-lu-zai-ci-jing-que-6hrh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。