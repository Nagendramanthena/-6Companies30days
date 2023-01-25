class Solution {   
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        int dp[][] = new int[n][n];
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (text.charAt(i) ==  text.charAt(j)) {
                    if (i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                if (dp[i][j] >= j - i) {
					// take substring i- (j-i) +1 to j+1 
                    set.add(text.substring(2 * i - j+1, j+1));
                }
            }
        }
        return set.size();
    }
}
