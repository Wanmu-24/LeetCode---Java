class Solution{
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> hashtble = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashtble.containsKey(target - nums[i])) {
				return new int []{hashtble.get(target - nums[i]),i};				
			}
			hashtble.put(nums[i],i);			
		}
		return new int[0];
	}
}