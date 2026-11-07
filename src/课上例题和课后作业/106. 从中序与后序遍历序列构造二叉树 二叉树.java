// 照猫画虎 按上一题的题解思路写 倒是过了 就是没写 最优解的那种
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)return null;
        int n = postorder.length;
        int leftSize = indexOf(inorder, postorder[n - 1]);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        int[] post1 = Arrays.copyOfRange(postorder,0, 0 + leftSize);
        int[] post2 = Arrays.copyOfRange(postorder,leftSize, n - 1);
        TreeNode left = buildTree(in1, post1);
        TreeNode right = buildTree(in2, post2);
        return new TreeNode(postorder[n - 1], left, right);
    }

    
    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }
}

// 题解
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0) { // 空节点
            return null;
        }
        int leftSize = indexOf(inorder, postorder[n - 1]); // 左子树的大小
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, leftSize + 1, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        TreeNode left = buildTree(in1, post1);
        TreeNode right = buildTree(in2, post2);
        return new TreeNode(postorder[n - 1], left, right);
    }

    // 返回 x 在 a 中的下标，保证 x 一定在 a 中
    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/2647794/tu-jie-cong-on2-dao-onpythonjavacgojsrus-w8ny/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> index = HashMap.newHashMap(n); // 预分配空间
        for (int i = 0; i < n; i++) {
            index.put(inorder[i], i);
        }
        return dfs(0, 0, n, postorder, index); // 左闭右开区间
    }

    // 根据 inorder 的子数组 [inL,inR) 和 postorder 的子数组 [postL,postR) 生成二叉树，其中 inR 没用到，可以省略
    private TreeNode dfs(int inL, int postL, int postR, int[] postorder, Map<Integer, Integer> index) {
        if (postL == postR) { // 空节点
            return null;
        }
        int leftSize = index.get(postorder[postR - 1]) - inL; // 左子树的大小
        TreeNode left = dfs(inL, postL, postL + leftSize, postorder, index);
        TreeNode right = dfs(inL + leftSize + 1, postL + leftSize, postR - 1, postorder, index);
        return new TreeNode(postorder[postR - 1], left, right);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/2647794/tu-jie-cong-on2-dao-onpythonjavacgojsrus-w8ny/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。