class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                hm.get(s.charAt(i)).add(i);
            }
            else{
                List<Integer> t = new ArrayList<>();
                t.add(i);
                hm.put(s.charAt(i),t);
            }
        }
        int ans= 0;
        for(String word:words){
            if(isTrue(hm,word))ans++;
        }
        
        return ans;
    }
    
    public boolean isTrue(HashMap<Character,List<Integer>> hm,String word){
        int last = -1;
        
        for(int i=0;i<word.length();i++){
           char c = word.charAt(i);
            if(hm.containsKey(c)){
                if(last == -1){
                    last = hm.get(c).get(0);
                }
                else{
                    last = bs(hm.get(c),last);
                }
                
                if(last == -1)return false;
            }
            else return false;
        }
        return true;
    }
    
    public int bs(List<Integer> arr,int last){
        int low  = 0;
        int high = arr.size()-1;
        
        int ans = -1;
        
        while(low<=high){
            int mid = (high-low)/2 +low;
            
            if(arr.get(mid)>last){
                ans = arr.get(mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
