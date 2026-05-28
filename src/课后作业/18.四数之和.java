// 自己第一次写
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        //四数之和
        for(int l = 0;l < n - 3;l++){
            // 三数之和
            int y = nums[l];
            if(l > 0  && y == nums[l - 1])continue;
            for(int i = l + 1; i < n - 2; i++){
                int x = nums[i];
                long minSum = (long)y + x + nums[i + 1] + nums[i + 2];
                long maxSum = (long)y + x + nums[n - 1] + nums[n - 2];
                if(minSum > target) break;
                if(maxSum < target) continue;
                if(i > 0 && i - l !=1 && x == nums[i - 1])continue;
                int left = i + 1;
                int right = n - 1;
                while(left < right){
                    int sum = nums[left] + nums[right] + x + y;
                    if(sum==target){
                        ans.add(List.of(y,x, nums[left], nums[right]));
                        for (left++; left < right && nums[left] == nums[left-1];left++);
                        for (right--; right > left && nums[right] == nums[right+1];right--);
                    } else if (sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}

// 灵茶的题解代码
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        //四数之和
        for(int a = 0; a < n - 3; a++){
            // 三数之和
            long x = nums[a];
            if (a > 0 && x == nums[a - 1]) continue; // 跳过重复数字
            if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break; // 优化一
            if (x + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue; // 优化二
            for(int b = a + 1; b < n - 2; b++){
                long y = nums[b];
                if(b > a + 1 && y == nums[b - 1]) continue;
                if (x + y + nums[b + 1] + nums[b + 2] > target) break; // 优化一
                if (x + y + nums[n - 2] + nums[n - 1] < target) continue; // 优化二
                int c = b + 1;
                int d = n - 1;
                while(c < d){
                    long sum = x + y + nums[c] + nums[d];
                    if(sum==target){
                        // ans 需要存储的是 List<Integer>
                        ans.add(List.of((int)x, (int)y, nums[c], nums[d]));
                        for (c++; c < d && nums[c] == nums[c-1];c++);
                        for (d--; d > c && nums[d] == nums[d+1];d--);
                    } else if (sum < target){
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return ans;
    }
}
// 在Java中，加法运算如果有一个操作数是long类型，整个表达式的结果就是long类型。
// 类型提升规则
// Java遵循"二元数值提升"（Binary Numeric Promotion）规则：
// 如果有long参与：所有其他整数类型（byte、short、int）都会被提升为long
// 运算结果：long类型