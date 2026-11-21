// 自己写的 时间慢 思路不是最优 还是看题解吧


// 写法一：选或不选（是否分割）
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        // path[i] 表示第 i 段（i 从 0 开始）的结束位置 + 1（右开区间，方便求 substring）
        int[] path = new int[4];
        dfs(0, 0, 0, s, s.length(), path, ans);
        return ans;
    }

    // 分割 s[i] 到 s[n-1]，现在在第 j 段（j 从 0 开始），数值为 ipVal
    private void dfs(int i, int j, int ipVal, String s, int n, int[] path, List<String> ans) {
        if (i == n) { // s 分割完毕
            if (j == 4) { // 必须有 4 段
                int a = path[0], b = path[1], c = path[2];
                ans.add(s.substring(0, a) + "." + s.substring(a, b) + "." + s.substring(b, c) + "." + s.substring(c));
            }
            return;
        }

        if (j == 4) { // j=4 的时候必须分割完毕，不能有剩余字符
            return;
        }

        // 手动把字符串转成整数，这样字符串转整数是严格 O(1) 的
        ipVal = ipVal * 10 + (s.charAt(i) - '0');
        if (ipVal > 255) { // 不合法
            return;
        }

        // 不分割，不以 s[i] 为这一段的结尾
        if (ipVal > 0) { // 无前导零
            dfs(i + 1, j, ipVal, s, n, path, ans);
        }

        // 分割，以 s[i] 为这一段的结尾
        path[j] = i + 1; // 记录这一段的结束位置 + 1
        dfs(i + 1, j + 1, 0, s, n, path, ans);
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/restore-ip-addresses/solutions/3727037/liang-chong-fang-fa-san-zhong-xun-huan-h-hxak/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



// 写法二：枚举选哪个（枚举子串右端点）
class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        String[] path = new String[4];
        dfs(0, 0, s, s.length(), path, ans);
        return ans;
    }

    // 分割 s[i] 到 s[n-1]，现在在第 j 段（j 从 0 开始）
    private void dfs(int i, int j, String s, int n, String[] path, List<String> ans) {
        // 剪枝：还剩下 n-i 个字符，需要分成 4-j 段，每段至少 1 个字符，至多 3 个字符，所以 4-j <= n-i <= (4-j)*3
        if (n - i < 4 - j || n - i > (4 - j) * 3) {
            return;
        }

        if (i == n) { // s 分割完毕
            ans.add(String.join(".", path));
            return;
        }

        // 子串左端点为 i
        // 枚举子串右端点 right
        int ipVal = 0;
        for (int right = i; right < n; right++) {
            ipVal = ipVal * 10 + (s.charAt(right) - '0');
            if (ipVal > 255) { // 不合法
                break;
            }
            path[j] = s.substring(i, right + 1); // 直接覆盖 path[j]，无需恢复现场
            dfs(right + 1, j + 1, s, n, path, ans);
            if (ipVal == 0) { // 前导零，对于后续循环不合法
                break;
            }
        }
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/restore-ip-addresses/solutions/3727037/liang-chong-fang-fa-san-zhong-xun-huan-h-hxak/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<String> list = new ArrayList<>();
        if (s.length() <= 3) return list;
        dfs(0, 0, sb, list);
        return list;
    }

    private void dfs(int pos, int i, StringBuilder sb, List<String> list) {
        if (pos == sb.length()) {
            if (i != 3) return;
            int index = sb.lastIndexOf(".");
            String sub = sb.substring(index + 1, sb.length());
            if (sub.length() > 1 && sub.charAt(0) == '0') return;

            if (sub.length() > 3) return;

            // 范围不对
            if (Integer.parseInt(sub) > 255) return;
            
            list.add(new String(sb));
            return;
        }

        // 不插入.
        dfs(pos + 1, i, sb, list);

        // 插入.
        // 先判断 能不能插入

        // 从当前开始往前找找上一个. 没有就返回-1
        if (sb.charAt(pos) != '.' && pos < sb.length() - 1) {
            int index = sb.lastIndexOf(".", pos);
        
            // 好像都一样 直接一行 
            // if (index == -1) {
            //     sub = sb.substring(0, pos + 1);
            // } else {
            //     sub = sb.substring(index + 1, pos + 1);
            // 
            String sub = sb.substring(index + 1, pos + 1);

            // 前导0
            if (sub.length() > 1 && sub.charAt(0) == '0') return;

            if (sub.length() > 3) return;

            // 范围不对
            if (Integer.parseInt(sub) > 255) return;

            // 在第pos位置后插入.
            i++;
            sb.insert(pos + 1, '.');
            dfs(pos + 1, i, sb, list);
            sb.deleteCharAt(pos + 1);

        }
        

    }
}