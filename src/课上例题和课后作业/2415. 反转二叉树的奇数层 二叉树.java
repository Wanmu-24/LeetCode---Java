// 李代桃僵 交换值 不用交换节点
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                TreeNode cur = q.poll();
                if (cnt % 2 == 1) {
                    cur.val = list.get(n);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                    q.offer(cur.right);
                    if (cnt % 2 == 0) {
                        list.add(cur.left.val);
                        list.add(cur.right.val);
                    }
                }
            }
            if (cnt % 2 == 1) {
                list.clear();
            }
            cnt++;
        }
        return root;
    }
}

// 题解 AI的
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            // 把当前层所有节点拿出来，方便双指针操作
            TreeNode[] nodes = new TreeNode[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = q.poll();
                if (nodes[i].left != null) {
                    q.offer(nodes[i].left);
                    q.offer(nodes[i].right);
                }
            }
            
            // 如果是奇数层，直接双指针反转值
            if (level % 2 == 1) {
                int left = 0, right = size - 1;
                while (left < right) {
                    int temp = nodes[left].val;
                    nodes[left].val = nodes[right].val;
                    nodes[right].val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}