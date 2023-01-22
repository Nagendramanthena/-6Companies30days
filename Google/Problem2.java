class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        f(s,ans,"",0,0);
        return ans;
    }
    
    public void f(String s,List<String> ans,String sb,int index,int dots){
        if(index >= s.length()){
           return;
        }
        
        if(dots == 3){
            if(s.length()-index>3)return;
            else{
                if(s.charAt(index)=='0' && index == s.length()-1){
                    String mys = sb+"0";
                    ans.add(mys);return;
                }
                else if(s.charAt(index)=='0' && index != s.length()-1) return;
                int val = Integer.parseInt(s.substring(index,s.length()));
                if(val<=255){
                    String mys= sb+s.substring(index,s.length());
                    ans.add(mys);
                }
                                           
            }
        }
        
        if(s.charAt(index) == '0'){
            String n = sb+"0.";
            f(s,ans,n,index+1,dots+1);
            
        }
        else {
            //append length 1 from index
            for(int i=index+1;i<Math.min(s.length(),index+4);i++){
                int val = Integer.parseInt(s.substring(index,i));
                if(val<=255){
                    String ns  = sb+s.substring(index,i)+".";
                    System.out.println(ns);
                    f(s,ans,ns,i,dots+1);
                }
            }
        }
    }
}
