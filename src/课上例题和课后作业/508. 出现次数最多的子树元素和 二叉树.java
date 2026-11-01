// https://leetcode.cn/problems/most-frequent-subtree-sum/description/

class Solution {

    // key是子树元素和 value是出现次数
    private Map<Integer, Integer> ans = new HashMap<>();
    // 写0也行 因为是次数,最少为1 也比0大
    private int mx = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> keys = new ArrayList<>();
        // 这个类型其实是Map.Entry<Integer, Integer> entry
        // var e 是语法糖 自动推断类型
        for (var e : ans.entrySet()) {
            if (e.getValue() == mx) { // 自动拆箱成 int 比较,安全
                keys.add(e.getKey());
            }
        }
        int[] res = new int[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            res[i] = keys.get(i); // 自动拆箱
        }
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int num = dfs(node.left) + dfs(node.right) + node.val;
        // 出现的次数 对应map的value;
        // merge函数 key不存在 放第二个参数的值，
        // key存在 把旧值和第二个参数进行第三个参数函数运算（sum） 若返回值为null 则删除key 不然就存进去
        // merge函数 返回新值
        int cnt = ans.merge(num, 1, Integer::sum);
        if (cnt > mx) {
            mx = cnt;
        }
        return num;
    }
}

// 题解
class Solution {
    Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
    int maxCnt = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int s = entry.getKey(), c = entry.getValue();
            if (c == maxCnt) {
                list.add(s);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + dfs(node.left) + dfs(node.right);
        cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        maxCnt = Math.max(maxCnt, cnt.get(sum));
        return sum;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/most-frequent-subtree-sum/solutions/1608986/chu-xian-ci-shu-zui-duo-de-zi-shu-yuan-s-kdjc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。