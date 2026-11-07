// 依旧照猫画虎
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) return null;
        if (n == 1) return new TreeNode(preorder[0]);
        int leftSize = indexOf(postorder, preorder[1]);
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize + 1);
        int[] pre2 = Arrays.copyOfRange(preorder, leftSize + 2, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize + 1);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize + 1, n);
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        return new TreeNode(preorder[0], left, right);
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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) { // 空节点
            return null;
        }
        if (n == 1) { // 叶子节点
            return new TreeNode(preorder[0]);
        }
        int leftSize = indexOf(postorder, preorder[1]) + 1; // 左子树的大小
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        return new TreeNode(preorder[0], left, right);
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
链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solutions/2649218/tu-jie-cong-on2-dao-onpythonjavacgojsrus-h0o5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        int[] index = new int[n + 1];
        for (int i = 0; i < n; i++) {
            index[postorder[i]] = i;
        }
        return dfs(0, n, 0, preorder, index); // 左闭右开区间
    }

    // 注意 postR 可以省略
    private TreeNode dfs(int preL, int preR, int postL, int[] preorder, int[] index) {
        if (preL == preR) { // 空节点
            return null;
        }
        if (preL + 1 == preR) { // 叶子节点
            return new TreeNode(preorder[preL]);
        }
        int leftSize = index[preorder[preL + 1]] - postL + 1; // 左子树的大小
        TreeNode left = dfs(preL + 1, preL + 1 + leftSize, postL, preorder, index);
        TreeNode right = dfs(preL + 1 + leftSize, preR, postL + leftSize, preorder, index);
        return new TreeNode(preorder[preL], left, right);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solutions/2649218/tu-jie-cong-on2-dao-onpythonjavacgojsrus-h0o5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 