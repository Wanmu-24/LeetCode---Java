// 自己第一次写 没写出来 卡在 怎么解决多于的目标字符
// 也想过用 "涵盖" 遍历的数组 的 值 大于 目标数组 的值就行 
// 但是Java好像没有内置的函数 又因为前面做题自己想太多 反而陷入错误思路 导致不敢下笔了
// 最后就直接看题解了 发现其实就差这一步 

// 灵茶题解
class Solution {
    public String minWindow(String S, String t) {
        int[] cntS = new int[128]; // s 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int left = 0;

        for (int right = 0; right < m; right++) { // 移动子串右端点
            cntS[s[right]]++; // 右端点字母移入子串
            while (isCovered(cntS, cntT)) { // 涵盖
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }
                cntS[s[left]]--; // 左端点字母移出子串
                left++;
            }
        }

        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimum-window-substring/solutions/2713911/liang-chong-fang-fa-cong-o52mn-dao-omnfu-3ezz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
