class Solution {
    int mod = ((int) Math.pow(10,9))+7;
    public double knightProbability(int n, int k, int row, int column) {
        double dp[][][] = new  double[n][n][k+1];
        for(double ro[][]:dp){
            for(double r[]:ro)Arrays.fill(r,-1);
        }
        
        double p = f(row,column,k,n,dp)/Math.pow(8,k);
        return p;
    }
    public double f(int i,int j,int n,int m,double dp[][][]){
        
        if(i<0 || j<0 || i>=m || j>=m) return 0;
        if(n == 0) return 1;
        if(dp[i][j][n]!=-1) return dp[i][j][n];
        double x =   f(i-2,j-1,n-1,m,dp);
            double x2 = f(i-2,j+1,n-1,m,dp);
           double y =  f(i+2,j+1,n-1,m,dp);
            double y2 =  f(i+2,j-1,n-1,m,dp);
           double z =  f(i-1,j-2,n-1,m,dp);
            double z2 =  f(i-1,j+2,n-1,m,dp);
           double o =  f(i+1,j+2,n-1,m,dp);
            double o2 =  f(i+1,j-2,n-1,m,dp);
            return dp[i][j][n] = (x+x2+y+y2+z+z2+o+o2);
        
    }
}
