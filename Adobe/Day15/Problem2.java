class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int dp[][] = new int[dungeon.length][dungeon[0].length];
        for(int r[]:dp)Arrays.fill(r,-1);
        return f(dungeon,0,0,dp);
    }
    public int f(int d[][],int i,int j,int dp[][]){
        
        if(i>=d.length || j>=d[0].length)return (int) Math.pow(10,9);
        
        if(i == d.length-1 && j == d[0].length-1)return d[i][j]<=0?1+-d[i][j]:1;
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        int right = f(d,i,j+1,dp);
        int down = f(d,i+1,j,dp);
        
        int minh  = Math.min(right,down)-d[i][j];
        
        return dp[i][j] = minh<=0?1:minh;
    }
}
