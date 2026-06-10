// 自己写
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        for (int t : time) {
            right = Math.min(right, t);
        }
        right = totalTrips * right;

        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (check(mid, time, totalTrips)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public boolean check (long mid, int[] time, int totalTrips) {
        long sum = 0;
        for (int t : time) {
            sum += mid / t;
        }
        if (sum >= totalTrips) {
            return true;
        } else {
            return false;
        }
    }
}


// 灵茶题解

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int minT = Integer.MAX_VALUE;
        for (int t : time) {
            minT = Math.min(minT, t);
        }
        long left = minT - 1; // 循环不变量：check(left) 恒为 false
        long right = (long) minT * totalTrips; // 循环不变量：check(right) 恒为 true
        while (left + 1 < right) { // 开区间 (left, right) 不为空
            long mid = (left + right) >>> 1;
            if (check(mid, time, totalTrips)) {
                right = mid; // 缩小二分区间为 (left, mid)
            } else {
                left = mid; // 缩小二分区间为 (mid, right)
            }
        }
        // 此时 left 等于 right-1
        // check(left) = false 且 check(right) = true，所以答案是 right
        return right; // 最小的 true
    }

    private boolean check(long x, int[] time, int totalTrips) {
        long sum = 0;
        for (int t : time) {
            sum += x / t;
            if (sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/minimum-time-to-complete-trips/solutions/1295955/er-fen-da-an-python-yi-xing-gao-ding-by-xwvs8/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。