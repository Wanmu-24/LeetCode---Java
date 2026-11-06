class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>();

    private int mx = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        dfs(root);
        ArrayList<Integer>  list=  new ArrayList<>();
        for(var e : map.entrySet()) {
            if (e.getValue() == mx) {
                list.add(e.getKey());
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i); // 自动拆箱
        }
        return arr;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        mx = Math.max(map.merge(node.val, 1, Integer::sum), mx);
        dfs(node.right);
    }
}

// 题解
class Solution {
    List<Integer> answer = new ArrayList<Integer>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode o) {
        if (o == null) {
            return;
        }
        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree/solutions/425430/er-cha-sou-suo-shu-zhong-de-zhong-shu-by-leetcode-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。