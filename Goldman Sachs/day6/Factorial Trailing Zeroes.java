link:https://leetcode.com/problems/factorial-trailing-zeroes/


code:
class Solution {
    public int trailingZeroes(int n) {
        int pow = 5;
        int ans = 0;
        
        while(pow<=n){
            ans += n/pow;
            pow *=5;
        }
        return ans;
    }
}
