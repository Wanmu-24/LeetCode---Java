class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] cntS = new int[26];
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            cntS[c - 'a']++;
            while (cntS[c - 'a'] > 2){
                cntS[s.charAt(left) - 'a']--;
                left++;
            }
            ans = Math.max(ans,right - left + 1);
        }
        return ans; 
    }
}