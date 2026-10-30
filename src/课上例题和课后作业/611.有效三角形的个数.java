class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int a = n-1; a > 1; a--){
            int x = nums[a];
            int l = 0;
            int r = a - 1;
            while(l < r){

                int sum = nums[l] + nums[r];
                if(nums[r] + nums[r-1] <= x)break;
                if(nums[l] + nums[l+1] > x){
                    for(int j = r ; j > l; j--){
                        ans += j - l;
                    }
                    break;
                }
                if(sum <= x){
                    l++;
                }else{
                    ans += r - l;
                    r--;
                }
            }
        }
        return ans;
    }
}


// 灵茶 题解
// 作者：灵茶山艾府
// 链接：https://leetcode.cn/problems/valid-triangle-number/solutions/2432875/zhuan-huan-cheng-abcyong-xiang-xiang-shu-1ex3/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int k = nums.length - 1; k > 1; k--) {
            int c = nums[k];
            if (nums[0] + nums[1] > c) { // 优化一
                ans += (k + 1) * k * (k - 1) / 6;
                break;
            }
            if (nums[k - 2] + nums[k - 1] <= c) { // 优化二
                continue;
            }
            int i = 0; // a=nums[i]
            int j = k - 1; // b=nums[j]
            while (i < j) {
                if (nums[i] + nums[j] > c) {
                    ans += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}




//
class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int a = n-1; a > 1; a--){
            int x = nums[a];
            int l = 0;
            int r = a - 1;
            if (nums[0] + nums[1] > x) { // 优化一
                ans += (a + 1) * a * (a - 1) / 6;
                break;
            }
            // 优化二
            if(nums[r] + nums[r-1] <= x)continue;
            // 优化三：内部优化
            if(nums[l] + nums[l+1] > x){
                ans += (r - l + 1) * (r - l) / 2;  // C(r-l+1, 2)
                continue;  // 跳过 while
            }
            while(l < r){
                int sum = nums[l] + nums[r];
                if(sum <= x){
                    l++;
                }else{
                    ans += r - l;
                    r--;
                }
            }
        }
        return ans;
    }
}


/*
为什么性能不如灵茶山艾府？
性能权衡分析：
表格
因素  您的代码    灵茶山艾府的代码
判断次数/迭代 3次  1次
可能提前退出  是   否
判断开销    高   低
代码复杂度   高   低
代码可读性   可读性低   可读性高
*/


/*
为什么判断多会导致性能下降？
实际测试数据（假设）：

数组长度: 1000
双指针迭代次数: ~500次

您的代码: 500 × 3 = 1500 次判断
灵茶山艾府: 500 × 1 = 500 次判断

即使您的代码有 10% 的情况提前退出，
节省的 50 次迭代 × 3 判断 = 150 次判断，
但额外多执行的 1000 次判断仍然导致净损失。
*/


/*
逻辑是对的 这种情况确实存在
但因为判断太多，综合性能不如灵茶山艾府的简洁代码
性能优化的本质：在"可能的优化收益"和"判断开销"之间找到平衡点。
灵茶山艾府的代码选择了更少的判断 + 更简单的逻辑，在大多数情况下表现更好。
*/



/*
简单方案的优势：
代码可读性高
维护成本低
编译器优化更容易
边界情况少，bug概率低

复杂优化的陷阱：
过早优化（Premature Optimization）
代码复杂度增加
可能引入新的bug
实际收益可能很小

*/