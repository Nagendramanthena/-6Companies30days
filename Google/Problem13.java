class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] pre = new int[m][n];
        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += mat[i][j];
                pre[i][j] = sum;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(m - 1, i + k);
                int c1 = Math.max(0, j - k); 
                int c2 = Math.min(n - 1, j + k);
                for(int t = r1; t <= r2; t++) {
                    ans[i][j] += pre[t][c2];
                    if(c1 != 0) ans[i][j] -= pre[t][c1 - 1];
                }
            }
        }
        return ans;
    }
}
