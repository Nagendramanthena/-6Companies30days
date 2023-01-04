link:https://leetcode.com/problems/longest-happy-prefix/


code:
//construct kmp table and return the longest
class Solution {
    public String longestPrefix(String str) {
        int len = 0;
        int i=1;
        int m = str.length();
        int lps[] = new int[m];
        int max = 0;
        
        while(i<m){
            if(str.charAt(i) == str.charAt(len)){
                lps[i] = len+1;
                max = Math.max(lps[i],max);
                len++;
                i++;
            }
            else{
                if(len!=0)
                {len = lps[len-1];
                 max = Math.max(lps[i],max);
                }
                else{
                    lps[i]=0;i++;
                }
            }
        }
        return str.substring(0,len);
    }
}
