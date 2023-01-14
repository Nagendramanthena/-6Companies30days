class StockPrice {
    
    TreeMap<Integer,Integer> r = new TreeMap<>();
    TreeMap<Integer,HashSet<Integer>> vals = new TreeMap<>();

    public StockPrice() {
        
    }
    
    public void update(int timeStamp, int price) {
        if(r.containsKey(timeStamp)){
            int prev = r.get(timeStamp);
            
            Set<Integer> hs = vals.get(prev);
            hs.remove(timeStamp);
            if(hs.isEmpty()){
                vals.remove(prev);
            }
          
          //remove that lastTimestamp
         // if that price has only one timstamp remove that price form vals;
            
        }
        vals.putIfAbsent(price,new HashSet<>());
        vals.get(price).add(timeStamp);
        r.put(timeStamp,price);
    }
    
    public int current() {
        return r.lastEntry().getValue();
    }
    
    public int maximum() {
        return vals.lastKey();
    }
    
    public int minimum() {
        return vals.firstKey();
    }
}
