class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int x[] = Arrays.copyOf(nums,n);
        Arrays.sort(nums);
        int end = -1;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i]!=x[i]){
                if(end!=-1){
                    ans += (i-end-1)+1;
                    end = i;
                }
                else{
                    ans++;
                    end = i;
                }
            }
        }
        return ans;
    }
}
