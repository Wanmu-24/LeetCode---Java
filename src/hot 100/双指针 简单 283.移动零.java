// 灵茶题解的把 nums 当作栈 思路
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int stacknums = 0;
        for(int i = 0; i < n; i++){
            if(nums[i]!=0){
                nums[stacknums] = nums[i];
                stacknums++;
            }
        }
        Arrays.fill(nums,stacknums,n,0);
    }
}



//双指针
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i0 = 0;
        while(i0 < n && nums[i0] != 0){
            i0++;
        }
        for(int i = i0 + 1; i < n; i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[i0];
                nums[i0] = temp;
                i0++;
            }
        }
    }
}


// 双向指针 灵茶题解
class Solution {
    public void moveZeroes(int[] nums) {
        int i0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交换 nums[i] 和 nums[i0]
                int tmp = nums[i];
                nums[i] = nums[i0];
                nums[i0] = tmp;
                i0++;
            }
        }
    }
}

// 作者：灵茶山艾府
// 链接：https://leetcode.cn/problems/move-zeroes/solutions/2969353/kuai-man-zhi-zhen-wei-shi-yao-ke-yi-ba-s-1h8x/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
