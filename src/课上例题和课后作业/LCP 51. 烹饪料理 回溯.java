class Solution {

    private int ans = -1;

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        perfectMenu(0, 0, materials, cookbooks, attribute, limit);
        return ans;
    }

    // 前 i - 1 个 已经做好了决策 在他们的条件下 做 i 的决策 做不做这第i道菜
    public void perfectMenu(int i, int tasty, int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        if (i == cookbooks.length) {
            // ans = limit <= 0 ? Math.max(ans, tasty) : ans;
            if (limit <= 0) {
                ans = Math.max(ans, tasty);
            }
            return;
        }
        // 第i道菜不做
        perfectMenu(i + 1, tasty, materials, cookbooks, attribute, limit);

        // 第i道菜能做吗？
        boolean isCook = true;
        // int[] oldMaterials = materials.clone();
        for (int j = 0; j < cookbooks[i].length; j++) {
            if (materials[j] < cookbooks[i][j]) {
                isCook = false;
                break;
            }
        }
        // 能做 做第i道菜
        // // 2. 确认能做，才动手扣食材，然后递归
        if (isCook) {
            for (int j = 0; j < cookbooks[i].length; j++) {
                materials[j] -= cookbooks[i][j];
            }
            perfectMenu(i + 1, tasty + attribute[i][0], materials, cookbooks, attribute, limit - attribute[i][1]);
            // 3. 精准回溯：刚才扣了多少，现在就加回多少
            for (int j = 0; j < cookbooks[i].length; j++) {
                materials[j] += cookbooks[i][j];
            }
        }

        // 回溯原materials数组
        // System.arraycopy(oldMaterials, 0, materials, 0, materials.length);
    }
}