// 灵茶题解

// 定长滑窗
/*
用滑动窗口枚举 s 的所有长为 n 的子串 t。在滑的同时，维护 t 的每种字母的出现次数。
如果 t 的每种字母的出现次数，和 p 的每种字母的出现次数都相同，那么 t 是 p 的异位词，把 t 左端点下标加入答案。
*/
// 思路也一样 可是没有想到怎么用代码实现 还是想得太简单 太模糊了
// 而且我还没想到 是用 右边进来 左边出去的想法来控制窗口


//Arrays.equals()
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       // 统计 p 的每种字母的出现次数
        int[] cntP = new int [26];
        for(char c : p.toCharArray()){
            cntP[c - 'a']++; // 统计 p 的字母
        }

        List<Integer> ans = new ArrayList<>();
        int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 t 的每种字母的出现次数
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++; // 右端点字母进入窗口
            int left = right - p.length() + 1;
            if (left < 0) { // 窗口长度不足 p.length()
                continue;
            }
            if (Arrays.equals(cntS,cntP)) { // t 和 p 的每种字母的出现次数都相同
                ans.add(left); // t 左端点下标加入答案
            } 
            cntS[s.charAt(left) - 'a']--; // 左端点字母离开窗口
        }
        return ans;
    }
}

//不定长滑窗 滑动窗口
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[26];
        for (char c : p.toCharArray()){
            cnt[c - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            cnt[c]--;
            while (cnt[c] < 0) {
                cnt[s.charAt(left) - 'a']++;
                left++;
            }
            if(right - left + 1 == p.length()) {
                ans.add(left);
            }
        }
        return ans;
    }
}

// 题解
// 作者：灵茶山艾府
// 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/2969498/liang-chong-fang-fa-ding-chang-hua-chuan-14pd/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
