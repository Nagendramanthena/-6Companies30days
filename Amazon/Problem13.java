class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int dp[][] = new int[n1+1][n2+1];
        
        int max = 0;
        
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(nums1[i] == nums2[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                    max =Math.max(dp[i+1][j+1],max);
                }
            }
        }
        return max;
    }
}
