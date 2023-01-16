class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return f(price,special,needs,0);
    }
    
    public int f(List<Integer> price,List<List<Integer>> special,List<Integer> needs,int index){
        if(index== special.size()){
            int cost = 0;
            for(int i=0;i<needs.size();i++){
                if(needs.get(i)>0)cost+=needs.get(i)*price.get(i);
            }
            return cost;
        }
        
        //pick this offer
        List<Integer> tempneeds = new ArrayList<>(needs);
        int pick = Integer.MAX_VALUE;
        if(valid(tempneeds,special,index)){
            pick = ret(tempneeds,special,index)+f(price,special,tempneeds,index);
        }
        
        int notpick = f(price,special,needs,index+1);
        
        return Math.min(pick,notpick);
    }
    
    public boolean valid(List<Integer> needs,List<List<Integer>> special,int index){
        List<Integer> offer = special.get(index);
        for(int i=0;i<needs.size();i++){
            if(needs.get(i)<offer.get(i))return false;
        }
        return true;
    }
    public int ret(List<Integer> needs,List<List<Integer>> special,int index){
       List<Integer> offer = special.get(index);
        
        for(int i=0;i<needs.size();i++){
            int x = needs.get(i);
            int y = x-offer.get(i);
            needs.set(i,y);
        }
        
        return offer.get(needs.size());
    }
}
