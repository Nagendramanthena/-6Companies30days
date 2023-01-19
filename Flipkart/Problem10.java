class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> strings = new HashSet<>();
        int l = 0;int r = 0;int len = s.length();
        
        while(r<len){
            if(r-l == k-1){
                strings.add(s.substring(l,r+1));
                l++;
            }
            r++;
        }
        
        int total = (int) Math.pow(2,k);
        
        return (strings.size() == total);
    }
}
