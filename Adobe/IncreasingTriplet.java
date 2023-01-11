link:https://leetcode.com/problems/increasing-triplet-subsequence/




code:
class Solution {
    public boolean increasingTriplet(int[] A) {
        
        int n  = A.length;
        int[] min = new int[n];
        int[] max = new int[n];
        
        min[0] = A[0];
        max[n-1] = A[n-1];
        for(int i=1;i<n;i++){
            min[i]  = Math.min(min[i-1],A[i]);
        }
        for(int i=n-2;i>=0;i--){
            max[i] = Math.max(max[i+1],A[i]);
        }
        for(int i=1;i<n-1;i++){
            int l = min[i-1];
            int r = max[i+1];
            if(l< A[i] && A[i]<r) return true;
        }
        return false;
    }
}
