class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
     int dp[][] = new int[5000][1001];
    for(int row[]:dp){
        Arrays.fill(row,-1);
    }
     return f(endPos,k,startPos,dp);   
    }
    public int f(int index,int k,int pos,int dp[][]){
        if(k<0){
            return 0;
        }
        if(k == 0 && index == pos){
            return 1;
        }
        if(dp[index+2001][k]!=-1){
            return dp[index+2001][k];
        }
        int lg = f(index-1,k-1,pos,dp);
        int rg = f(index+1,k-1,pos,dp);
        return dp[index+2001][k]=(lg+rg)%1000000007;
    }
}
