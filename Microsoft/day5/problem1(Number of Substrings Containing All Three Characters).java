//link:https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/


//code

//sliding window

simple logic-->(len-r)when all arr[i]>0;

class Solution {
    public int numberOfSubstrings(String s) {
        int arr[] = new int[3];
        int len =s.length();
        int l=0;
        int r = 0;
        int ans = 0;
        
        while(r<len){
            arr[s.charAt(r)-'a']++;
            
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                ans += len-r;
                arr[s.charAt(l++)-'a']--;
                
            }
            r++;
            
        }
        return ans;
    }
}
