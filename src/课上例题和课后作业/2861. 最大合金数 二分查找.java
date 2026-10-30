// https://leetcode.cn/problems/maximum-number-of-alloys/description/
// 灵茶题解 自己第一次没想出来
class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> Stock, List<Integer> Cost) {
        int mx = budget + Collections.min(Stock);
        Integer[] stock = Stock.toArray(Integer[]::new);
        Integer[] cost = Cost.toArray(Integer[]::new);

        int ans = 0;
        for (List<Integer> Comp : composition) {
            Integer[] comp = Comp.toArray(Integer[]::new);
            int left = ans;
            int right = mx + 1;
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                long money = 0;
                for (int i = 0; i < n && money <= budget; i++) {
                    if (stock[i] < (long) comp[i] * mid) {
                        money += ((long) comp[i] * mid - stock[i]) * cost[i];
                    }
                }
                if (money <= budget) {
                    left = mid;
                } else {
                    right = mid;
                }
                ans = left;
            }
        }
        return ans;
    }
}