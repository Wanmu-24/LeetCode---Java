/* 自己第一次写
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        Collections.sort(nums);
        int n = nums.size();
        for(int i = 0; i < n-1 ; i++){
            int l = i;
            int r = i + 1;
            while(r < n){
                int sum = nums.get(l) + nums.get(r);
                if(sum >= target){
                    break;
                }else{
                    ans++;
                    r++;
                }
            }
        }
        return ans;
    }
}
*/

// 灵茶题解写法
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        while(left < right){
            int sum = nums.get(left) + nums.get(right);
            if(sum >= target){
                right--;
            }else{
                ans += right - left;
                left++;
            }
        }
        return ans;
    }        
}
