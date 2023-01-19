class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Queue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:barcodes){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> me:hm.entrySet()){
            int key = me.getKey();
            int val = me.getValue();
            pq.add(new Pair(key,val));
        }
        int i=0;
        int ans[] = new int[barcodes.length];
        Queue<Pair> q2 = new LinkedList<>();
        while(!pq.isEmpty()){
            Pair t = pq.poll();
            
            ans[i++] = t.val;
            
            if(!q2.isEmpty())pq.add(q2.poll());
            if(t.freq-1>0)q2.add(new Pair(t.val,t.freq-1));
        }
        
        return ans;
    }
}

class Pair{
    int val;
    int freq;
    
    public Pair(int v,int f){
        this.val = v;
        this.freq = f;
    }
}
