class Solution {
    public int maxUniqueSplit(String s) {
        return f(s,0,0,new HashSet<String>());
    }
    
    public int f(String s,int i,int prev,HashSet<String> hs){
        if(i == s.length())return 0;
        
        int part = 0;
        String sub  = s.substring(prev,i+1);
        if(hs.add(sub)){
            part = 1+f(s,i+1,i+1,hs);
            hs.remove(sub);
        }
        
        //
        int no = f(s,i+1,prev,hs);
        
        return Math.max(part,no);
    }
}
