//used a simple bfs traversal

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair> q = new PriorityQueue<>((a,b)->a.mut-b.mut);
        q.add(new Pair(startGene,0));
        HashMap<String,Integer> hm = new HashMap<>();
        for(String s:bank){
            hm.put(s,1);
        }

        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.s;
            int m = p.mut;
            if(s.equals(endGene))return m;
            for(int i=0;i<8;i++){
                    String ss[] = {"A","C","G","T"};
                    for(int j=0;j<4;j++){
                        String ns = s.substring(0,i)+ss[j]+s.substring(i+1,8);
                        if(hm.containsKey(ns) && hm.get(ns)>0){
                        hm.replace(ns,hm.get(ns)-1);
                        q.add(new Pair(ns,m+1));
                    }
                    
                    //System.out.println(ns)
                }
            }
        }
        return -1;
    }
}

class Pair{
    String s;
    int mut;
    
    public Pair(String s,int mut){
        this.s= s;
        this.mut = mut;
    }
}
