class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        // StringBuilder path = new StringBuilder();
        // path.append(s);
        char[] chars = s.toCharArray();
        dfs(0, chars, ans);
        return ans;
    }

    private void dfs(int i, char[] chars, List<String> ans) {
        if (i == chars.length) {
            // ans.add(new String(StringBuilder));
            ans.add(new String(chars));
            return;
        }
        char c = chars[i];
        dfs(i + 1, chars, ans);
        if (c >= 'A' && c <= 'Z') {
            chars[i] = Character.toLowerCase(c);
            dfs(i + 1, chars, ans);
            chars[i] = c;
        } else if (c >= 'a' && c <= 'z') {
            chars[i] = Character.toUpperCase(c);
            dfs(i + 1, chars, ans);
            chars[i] = c;
        }
        
    }
}

// AI优化
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(0, chars, ans);
        return ans;
    }

    private void dfs(int i, char[] chars, List<String> ans) {
        if (i == chars.length) {
            ans.add(new String(chars));
            return;
        }
        char c = chars[i];
        dfs(i + 1, chars, ans);
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            chars[i] = (char) (c ^ 32);
            dfs(i + 1, chars, ans);
            chars[i] = c; // 回溯恢复
        }

    }
}