// 题解
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}

// 自己写的
class Solution {
    int[] ans = {1, 10};
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else {
            return perm(9, n) + perm(9, n - 1) * (n - 1) + countNumbersWithUniqueDigits(n - 1);
        }
    }

    public int perm(int n, int k) {
        if (k < 0 || k > n)
            return 0;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= (n - i);
        }
        return res;
    }
}