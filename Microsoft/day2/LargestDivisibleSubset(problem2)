//problem link:

https://leetcode.com/problems/largest-divisible-subset/


code:


class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;int max=0;int lastIndex = 0;
        int dp[] = new int[n];int backtrack[] =new int[n];
        for(int i=0;i<n;i++){
            backtrack[i] = i;
        }
        Arrays.fill(dp,1);
        for(int index=0;index<n;index++){
            for(int previndex = 0;previndex<index;previndex++){
                if(dp[index]<(1+dp[previndex]) && nums[index]%nums[previndex] == 0){
                    dp[index] = dp[previndex]+1;
                    backtrack[index]=previndex;
                }
            }
            if(max<dp[index]){
                lastIndex = index;
                max = dp[index];
            }
        }
        List<Integer> ans = new ArrayList<>();int index=0;
        while(lastIndex!=backtrack[lastIndex]){
            ans.add(index,nums[lastIndex]);index++;
            lastIndex = backtrack[lastIndex];
        }
        ans.add(nums[lastIndex]);
        return ans;
    }
}
