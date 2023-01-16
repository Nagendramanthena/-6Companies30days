class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k>nums.length)return false;
        int n = nums.length;
        int vis[] = new int[n];
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        Arrays.sort(nums);
        if(sum%k == 0)return helper(nums,0,0,1,vis,sum/k,k);
        return false;
    }
    
    public boolean helper(int nums[],int i,int bucketSum,int bucketNum,int vis[],int sum,int k){
        if(bucketNum == k+1)return true;
        
        if(bucketSum == sum)return helper(nums,0,0,bucketNum+1,vis,sum,k);

        
        for(int j=i;j<nums.length;j++){
            if(vis[j] == 0 && bucketSum+nums[j]<=sum){
                vis[j]=1;
                if(helper(nums,j+1,bucketSum+nums[j],bucketNum,vis,sum,k))return true;
                
                vis[j]=0;
            }
        }
        return false;
    }
}
