link:
https://leetcode.com/problems/count-nice-pairs-in-an-array/



code:
class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Long> hm = new HashMap<>();
        int mod = (int) Math.pow(10,9)+7;
        for(int i:nums){
            int y = i-reverse(i);
            hm.put(y,(long)(hm.getOrDefault(y,0l)+1)%mod);
        }
        long ans = 0;
        int o = (nums.length)*(nums.length-1);
        for(Map.Entry<Integer,Long> me:hm.entrySet()){
            long t = me.getValue();
    
            ans =ans +(t*(t-1)/2)%mod;
        }
        return  (int) ans%mod;
    }
    public int reverse(int x){
        int rev = 0;
        while(x>0){
            int rem = x%10;
            rev = rev*10+rem;
            x /= 10;
        }
        
        return rev;
    }
}
