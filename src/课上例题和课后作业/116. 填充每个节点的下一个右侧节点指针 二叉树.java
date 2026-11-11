class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            Node pre = q.poll();
            if (pre.left != null) q.add(pre.left);
            if (pre.right != null) q.add(pre.right);
            n--;
            while (n-- > 0) {
                Node cur = q.poll();
                pre.next = cur;
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
                pre = cur;
            }
        }
        return root;
    }
}

// 题解
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> q = List.of(root);
        while (!q.isEmpty()) {
            List<Node> tmp = q;
            q = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                Node node = tmp.get(i);
                if (i > 0) { // 连接同一层的两个相邻节点
                    tmp.get(i - 1).next = node;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return root;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solutions/2510369/san-chong-fang-fa-dfsbfsbfslian-biao-fu-5alnq/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。