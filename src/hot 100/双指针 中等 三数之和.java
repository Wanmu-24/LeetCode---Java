class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> ans = new List<>();
        nums.sort();
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] + nums[i+1] + nums[i+2] > 0) break;
            if(nums[i] + nums[-1] + nums[-2] < 0) continue;
            if(i!=0 && nums[i] == nums[i-1])continue;
            while(true){
                left = i + 1;
                right = nums.length - 1;
                int target = 0 - nums[i];
                int sum = target[left] + target[right];
                if(sum==target){
                    ans
                    left++;
                    right--;
                }
                if(sum < target){
                    left++;
                }else{
                    right++;
                }
            }
        }
        return ans
    }
}