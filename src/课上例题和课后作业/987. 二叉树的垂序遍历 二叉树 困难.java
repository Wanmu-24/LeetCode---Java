// https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/description/

// 题解https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/solutions/2638913/si-chong-xie-fa-dfsha-xi-biao-shuang-shu-tg6q/
// 题解 有四种 
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<int[]>> left = new ArrayList<>();
        List<List<int[]>> right = new ArrayList<>();
        dfs(root, 0, 0, left, right);

        List<List<Integer>> ans = new ArrayList<>(left.size() + right.size());
        Collections.reverse(left);
        add(ans, left);
        add(ans, right);
        return ans;
    }

    private void dfs(TreeNode node, int row, int col, List<List<int[]>> left, List<List<int[]>> right) {
        if (node == null) {
            return;
        }
        if (col < -left.size()) {
            left.add(new ArrayList<>());
        } else if (col == right.size()) {
            right.add(new ArrayList<>());
        }
        (col < 0 ? left.get(-col - 1) : right.get(col)).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1, left, right);
        dfs(node.right, row + 1, col + 1, left, right);
    }

    private void add(List<List<Integer>> ans, List<List<int[]>> a) {
        for (List<int[]> g : a) {
            Collections.sort(g, (p, q) -> p[0] != q[0] ? p[0] - q[0] : p[1] - q[1]);
            List<Integer> vals = new ArrayList<>(g.size());
            for (int[] p : g) {
                vals.add(p[1]);
            }
            ans.add(vals);
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/solutions/2638913/si-chong-xie-fa-dfsha-xi-biao-shuang-shu-tg6q/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    private int minCol;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> groups = new HashMap<>();
        dfs(root, 0, 0, groups);

        List<List<Integer>> ans = new ArrayList<>(groups.size());
        for (int col = minCol; col < minCol + groups.size(); col++) {
            List<int[]> g = groups.get(col);
            g.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> vals = new ArrayList<>(g.size());
            for (int[] p : g) {
                vals.add(p[1]);
            }
            ans.add(vals);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, List<int[]>> groups) {
        if (node == null) {
            return;
        }
        minCol = Math.min(minCol, col);
        groups.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1, groups);
        dfs(node.right, row + 1, col + 1, groups);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/solutions/2638913/si-chong-xie-fa-dfsha-xi-biao-shuang-shu-tg6q/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> data = new ArrayList<>();
        dfs(root, 0, 0, data);

        List<List<Integer>> ans = new ArrayList<>();
        data.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        int lastCol = Integer.MIN_VALUE;
        for (int[] d : data) {
            if (d[0] != lastCol) {
                lastCol = d[0];
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(d[2]);
        }
        return ans;
    }

    private void dfs(TreeNode node, int row, int col, List<int[]> data) {
        if (node == null) {
            return;
        }
        data.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, data);
        dfs(node.right, row + 1, col + 1, data);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/solutions/2638913/si-chong-xie-fa-dfsha-xi-biao-shuang-shu-tg6q/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<int[]>> left = new ArrayList<>();
        List<List<int[]>> right = new ArrayList<>();
        dfs(root, 0, 0, left, right);

        List<List<Integer>> ans = new ArrayList<>(left.size() + right.size());
        Collections.reverse(left);
        add(ans, left);
        add(ans, right);
        return ans;
    }

    private void dfs(TreeNode node, int row, int col, List<List<int[]>> left, List<List<int[]>> right) {
        if (node == null) {
            return;
        }
        if (col < -left.size()) {
            left.add(new ArrayList<>());
        } else if (col == right.size()) {
            right.add(new ArrayList<>());
        }
        (col < 0 ? left.get(-col - 1) : right.get(col)).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1, left, right);
        dfs(node.right, row + 1, col + 1, left, right);
    }

    private void add(List<List<Integer>> ans, List<List<int[]>> a) {
        for (List<int[]> g : a) {
            Collections.sort(g, (p, q) -> p[0] != q[0] ? p[0] - q[0] : p[1] - q[1]);
            List<Integer> vals = new ArrayList<>(g.size());
            for (int[] p : g) {
                vals.add(p[1]);
            }
            ans.add(vals);
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/solutions/2638913/si-chong-xie-fa-dfsha-xi-biao-shuang-shu-tg6q/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。