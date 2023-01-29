class Solution {
    public int maxSum(int[][] a) {
        int n = a.length, m = a[0].length;
        int ans = 0;
        for(int i = 0;i < n-2;i++){
            for(int j = 0;j < m-2;j++){
                int s = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] + a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}
