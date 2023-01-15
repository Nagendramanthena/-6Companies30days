Number of People Aware of a Secret



class Solution {
    int fr;
    int mod =(int) Math.pow(10,9)+7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        fr = forget;
        int dp[][] = new int[n+1][forget+1];
        for(int r[]:dp)Arrays.fill(r,-1);
        return 1+f(n-delay,delay,forget-delay,dp);
    }
    public int f(int n,int d,int forget,int dp[][]){
        
        if(n<=0)return 0;
        if(forget==0)return -1;
        if(dp[n][forget]!=-1)return dp[n][forget];
        
        
        return dp[n][forget] = (1+f(n-1,d,forget-1,dp)%mod+f(n-d,d,fr-d,dp)%mod)%mod;
        
    }
}
