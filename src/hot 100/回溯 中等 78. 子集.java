// 第一次写没写出来

// 题解 

// 方法一：选或不选（输入的视角）
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, path, ans);
        return ans;
    }

    // 选或不选：讨论 nums[i] 是否加入 path
    private void dfs(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        if (i == nums.length) { // 子集构造完毕
            ans.add(new ArrayList<>(path)); // 复制 path
            return;
        }

        // 不选 nums[i]
        dfs(i + 1, nums, path, ans); // 考虑下一个数 nums[i+1] 选或不选

        // 选 nums[i]
        path.add(nums[i]);
        dfs(i + 1, nums, path, ans); // 考虑下一个数 nums[i+1] 选或不选
        path.removeLast(); // path.remove(path.size() - 1);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/subsets/description/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 方法二：枚举选哪个（答案的视角）
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, path, ans);
        return ans;
    }

    // 枚举选哪个：在下标 i 到 n-1 中选一个数，加到 path 末尾
    private void dfs(int i, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path)); // 不选，把当前子集加入答案
        for (int j = i; j < nums.length; j++) { // 选，枚举选择的数字
            path.add(nums[j]);
            dfs(j + 1, nums, path, ans); // 选 nums[j] 意味着 i 到 j-1 都跳过不选，下一个数从 j+1 开始选
            path.removeLast(); // path.remove(path.size() - 1);
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/subsets/description/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。