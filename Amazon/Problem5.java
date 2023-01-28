class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:words){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        List<String> sorted = new ArrayList<>(hm.keySet());
        Collections.sort(sorted,(a,b)->hm.get(a)!=hm.get(b)?hm.get(b)-hm.get(a):a.compareTo(b));
        
        return sorted.subList(0,k);
    }
}
