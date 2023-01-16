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







//with memoization

public class Solution {
    public int shoppingOffers(List < Integer > price, List < List < Integer >> special, List < Integer > needs) {
        Map < List < Integer > , Integer > map = new HashMap();
        return shopping(price, special, needs, map);
    }
    public int shopping(List < Integer > price, List < List < Integer >> special, List < Integer > needs, Map < List < Integer > , Integer > map) {
        if (map.containsKey(needs))
            return map.get(needs);
        int j = 0, res = dot(needs, price);
        for (List < Integer > s: special) {
            ArrayList < Integer > clone = new ArrayList < > (needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                res = Math.min(res, s.get(j) + shopping(price, special, clone, map));
        }
        map.put(needs, res);
        return res;
    }
    public int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

}
