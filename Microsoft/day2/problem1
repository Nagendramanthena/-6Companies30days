///////////iink(rotate function) ///////
https://leetcode.com/problems/rotate-function/


code


class Solution {
    public int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE;
        int s = 0;
        int f = 0;
        for(int i=0;i<nums.length;i++){
            f += (nums[i])*i;
            s += nums[i];
        }
        max = Math.max(f,max);
        int l = nums.length;
        int n =0;
        for(int i=nums.length-1;i>=0;i--){
            n = f+s-(nums[i]*l);
            f = n;
            if(max<n){
                max=n;
            }
        }
        
        return max;
    }
}

