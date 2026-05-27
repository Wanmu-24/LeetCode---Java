class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            int x = nums[i];
            if(x + nums[i + 1] + nums[i + 2] > 0) break;
            if(x + nums[n - 1] + nums[n -2] < 0) continue;
            if(i > 0 && x == nums[i - 1])continue;
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int target = 0 - x;
                int sum = nums[left] + nums[right];
                if(sum==target){
                    ans.add(List.of(x, nums[left], nums[right]));
                    for (left++; left < right && nums[left] == nums[left-1];left++);
                    for (right--; right > left && nums[right] == nums[right+1];right--);
                } else if (sum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}