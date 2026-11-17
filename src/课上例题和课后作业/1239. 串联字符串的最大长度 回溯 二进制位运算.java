// 题解
class Solution {
    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return ans;
    }

    public void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) { // mask 和 masks[pos] 无公共元素
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters/solutions/834267/chuan-lian-zi-fu-chuan-de-zui-da-chang-d-g6gk/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


// 自己写的回溯 选不选 还是看题解吧
class Solution {

    boolean[] seen = new boolean[26];
    int ans = 0;

    public int maxLength(List<String> arr) {
        StringBuilder sb = new StringBuilder();
        dfs(0, sb, arr);
        return ans;
    }

    private void dfs(int i, StringBuilder sb, List<String> arr) {
        if (i == arr.size()) {
            System.out.println(sb.length());
            ans = Math.max(ans, sb.length());
            return;
        }

        dfs(i + 1, sb, arr);

        boolean isAdd = true;

        String s = arr.get(i);
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) { // add失败说明已经存在
                isAdd = false;
                break;
            }
        }

        if (isAdd) {
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (seen[idx]) {
                    isAdd = false;
                    break;
                }   
            }
        }
        

        if (isAdd) {
            for (char c : s.toCharArray()) {
                seen[c - 'a'] = true;
            }
            int len = sb.length();
            dfs(i + 1, sb.append(arr.get(i)), arr);
            sb.setLength(len);
            for (char c : s.toCharArray()) {
                seen[c - 'a'] = false;
            }
        }
    }
}