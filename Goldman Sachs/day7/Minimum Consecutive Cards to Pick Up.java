link:
https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/


intution:just strore the last occurence of a number 




code:

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = cards.length;
        
        int min = n+1;
        for(int i=0;i<n;i++){
            if(hm.containsKey(cards[i])){
                min = Math.min(i-hm.get(cards[i])+1,min);
                hm.replace(cards[i],i);
            }
            else{
                hm.put(cards[i],i);
            }
        }
        
        return min==n+1?-1:min;
    }
}
