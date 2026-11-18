// 题解没有java 我叫AI帮我改了一下
class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length; // 区域数量，固定为 12
        int maxScore = -1;
        int[] ans = new int[n];

        // 枚举 Bob 所有可能的“获胜区域集合”
        for (int mask = 0; mask < (1 << n); mask++) {
            int score = 0;
            int arrow = 0;
            int[] bobArrows = new int[n];

            for (int j = 0; j < n; j++) {
                // 如果 mask 的第 j 位是 1，表示 Bob 决定赢下区域 j
                if (((mask >> j) & 1) == 1) {
                    score += j;                    // 赢下区域 j，获得 j 分
                    arrow += aliceArrows[j] + 1;   // 需要比 Alice 多射一支箭
                    bobArrows[j] = aliceArrows[j] + 1;
                }
            }

            // 这个方案消耗的箭数不能超过 Bob 的总箭数
            if (arrow > numArrows) {
                continue;
            }

            // 如果当前方案得分更高，则更新答案
            if (score > maxScore) {
                maxScore = score;
                // 剩下的箭全部补到 0 分区域（不影响得分）
                bobArrows[0] += numArrows - arrow;
                ans = bobArrows.clone();
            }
        }
        return ans;
    }
}
// 原版是GO语言
作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-points-in-an-archery-competition/solutions/1352593/er-jin-zhi-mei-ju-by-endlesscheng-rjul/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// 自己写的纯回溯 选不选思路 没有二进制位运算
class Solution {

    private int[] ans = new int[12];
    private int mx = 0;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bobArrows = new int[12];
        backtrack(11, numArrows, aliceArrows, bobArrows);
        return ans;
    }

    // i是遍历到数组的第几位
    // numArrows是还剩多少个箭没放置位置
    // 只要两个都满足才行
    private void backtrack(int i, int numArrows, int[] a, int[] b) {
        if (i == -1 && numArrows == 0) {
            int cnt = 0;
            for (int j = 0; j < 12; j++) {
                if (b[j] > a[j]) {
                    cnt += j;
                }
            }
            if (cnt > mx) {
                mx = cnt;
                ans = b.clone();
            }
            return;
        }

        // i = 0 就必须把箭全部射在0位置上 不管a有多少 单纯满足 总箭数的要求 而且0位置也不算分
        if (i == 0) {
            b[i] = numArrows;
            backtrack(i - 1, 0, a, b);
            b[i] = 0;
        } else {
            // 不在第i位置射箭
            backtrack(i - 1, numArrows, a, b);

            //看看能不能射箭 还有没有箭 要射箭就比a多1 这样有分还能省箭 
            if (numArrows > a[i]) {
                b[i] = a[i] + 1;
                backtrack(i - 1, numArrows - a[i] - 1, a, b);
                // 复原现场
                b[i] = 0;
            }
        }

    }
}