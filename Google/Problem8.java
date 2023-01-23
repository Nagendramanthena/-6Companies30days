class Solution {
    public int totalFruit(int[] fruits) {
        int r = 0;
        int l = 0;
        int len = fruits.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashMap<Integer,Integer> lo = new HashMap<>();
        
        int maxans = 0;
        int currf = 0;
        
        while(r<len){
            int f = fruits[r];
            
            if(hm.size()==2 && !hm.containsKey(f)){
                while(l<r){
                    currf -= 1;
                    if(hm.get(fruits[l])!=1){
                        hm.replace(fruits[l],hm.get(fruits[l])-1);
                    }
                    else{
                        hm.remove(fruits[l]);
                        l++;
                        break;
                    }
                    l++;
                }
            }
            hm.put(f,hm.getOrDefault(f,0)+1);
            currf+=1;
            maxans = Math.max(currf,maxans);
            
            r++;
        }
        return maxans;
    }
}
