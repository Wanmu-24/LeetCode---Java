class Solution {

    List<List<Integer>> ans;
    TreeSet<Integer> set = new TreeSet<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int n = queries.size();
        ans = new ArrayList<>(n);
        dfs(root);
        for (int i = 0 ;i < n; i++) {
            List<Integer> row = new ArrayList<>(Arrays.asList(-1, -1));
            Integer mn = set.floor(queries.get(i));
            Integer mx = set.ceiling(queries.get(i));
            if (mn != null) {
                row.set(0, mn);
            }
            if (mx != null) {
                row.set(1, mx);
            }
            ans.add(row);
        }
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        set.add(node.val);
        dfs(node.right);
    }
}


//  题解
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);

        int n = arr.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = arr.get(i); // 转成数组，效率更高
        }

        List<List<Integer>> ans = new ArrayList<>(queries.size()); // 预分配空间
        for (int q : queries) {
            int j = lowerBound(a, q);
            int mx = j == n ? -1 : a[j];
            if (j == n || a[j] != q) { // a[j]>q, a[j-1]<q
                j--;
            }
            int mn = j < 0 ? -1 : a[j];
            ans.add(List.of(mn, mx));
        }
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> a) {
        if (node == null) {
            return;
        }
        dfs(node.left, a);
        a.add(node.val);
        dfs(node.right, a);
    }

    // 见 https://www.bilibili.com/video/BV1AP41137w7/
    private int lowerBound(int[] a, int target) {
        int left = -1, right = a.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = (left + right) >>> 1; // 比 /2 快
            if (a[mid] >= target) {
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/solutions/2651916/zhong-xu-bian-li-er-fen-cha-zhao-pythonj-4ic0/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。