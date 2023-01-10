link:
https://leetcode.com/problems/maximum-good-people-based-on-statements/


code:

class Solution {
    static int BAD= 0,  GOOD= 1, UNKNOWN= 2;

    public int maximumGood(int[][] statements) {
        int n= statements.length;
        int max= 0, combos= 1<<n;
        int[] roles= new int[n];
        for(int mask=1; mask<combos; mask++){
            int count= apply(roles, mask);
            if(possible(statements, roles))
                max= Math.max(max, count);
        }
        return max;
    }
    int apply(int[] roles, int mask){
        int count= 0, n= roles.length;
        for(int i=0; i<n; i++){
            count+= roles[i]= mask & GOOD;
            mask >>= 1;
        }
        return count;
    }

    boolean possible(int[][] statements, int[] roles){
        int n= statements.length;
        for(int i=0; i<n; i++){
            if(roles[i]==BAD) continue;
            // only check statements of good people
            for(int j=0; j<n; j++){
                if(statements[i][j]==UNKNOWN) continue;
				// statement of a good person contradicts the assigned role in this combination
                if(statements[i][j]!=roles[j]) return false; 
            }
        }
        return true;
    }    
}
