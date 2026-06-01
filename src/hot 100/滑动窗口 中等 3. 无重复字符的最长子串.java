// https://www.bilibili.com/video/BV1hd4y1r7Gq
// 滑动窗口【基础算法精讲 03】 课上例题

//灵茶题解
// 主要困在 怎么能不用遍历的情况下 快速处理重复字符 
// 解法: 引入空间复杂度 int数组 或者布尔数组 大小为 128 因为标准 ASCII 共 128 个字符，范围：0 ~ 127
class Solution {
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128];
        for(int right = 0; right < n; right++){
            char c = s[right];
            cnt[c]++;
            while (cnt[c] > 1){
                cnt[s[left]]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        int left = 0;
        boolean[] has = new boolean[128];
        for(int right = 0; right < n; right++){
            int c = s[right];
            while(has[c]){
                has[s[left]] = false;
                left++;
            }
            has[c] = true;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}