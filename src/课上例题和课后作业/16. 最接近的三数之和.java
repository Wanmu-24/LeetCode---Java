class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int ans = 100000;
        for(int i = 0; i < n - 2; i++){
            int x = nums[i];
            int sum = x + nums[i + 1] + nums[i + 2];
            if(sum > target) {
                if(sum - target < Math.abs(ans - target)){
                    ans = sum;
                }
                break;
            }
            sum = x + nums[n - 2] + nums[n - 1];
            if(sum < target) {
                if(sum - target <  Math.abs(ans - target)){
                    ans = sum;
                }
                continue;
            }

            if(i!=0 && nums[i] == nums[i-1])continue;
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                sum = nums[left] + nums[right] + x;
                if(sum == target){
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target)) { 
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else { // s < target
                    left++;
                }
            }
        }
        return ans;
    }
}