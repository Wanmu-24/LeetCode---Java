// 第一次自己写 就和 灵茶的题解差不多 于是修改了一下 优化一下速度
class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int left = 0;
        int cnt = 0;
        int ans = 1;
        for (int right = 1; right < n; right++){
            if (s.charAt(right) == s.charAt(right - 1)){
                cnt++;
            }
            while (cnt > 1){
                if (s.charAt(left) == s.charAt(left + 1))cnt--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

// 灵茶题解
class Solution {
    public int longestSemiRepetitiveSubstring(String S) {
        char[] s = S.toCharArray();
        int ans = 1;
        int same = 0;
        int left = 0;
        for (int right = 1; right < s.length; right++) {
            if (s[right] == s[right - 1]) {
                same++;
            }
            if (same > 1) { // same == 2
                left++;
                while (s[left] != s[left - 1]) {
                    left++;
                }
                same = 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/solutions/2304713/shuang-zhi-zhen-hua-chuang-pythonjavacgo-nurf/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。