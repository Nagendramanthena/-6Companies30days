class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];int v = flights[i][1];int cost=flights[i][2];
            adj.get(u).add(new Pair(v,cost,0));
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0,k+1));
        int dis[] = new int[n];Arrays.fill(dis,(int) Math.pow(10,9));
        dis[src]=0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.first;
            int cost = p.second;
            int stops = p.stp;
            
            for(Pair pair:adj.get(node)){
                int de = pair.first;
                int c = pair.second;
                
                if(dis[de]>cost+c && stops>0){
                    dis[de] = cost+c;
                    q.add(new Pair(de,dis[de],stops-1));
                }
            }
        }
        if(dis[dst] == (int) Math.pow(10,9)) return -1;
        return dis[dst];
    }
}

class Pair{
    int first;
    int second;
    int stp;
    
    public Pair(int f,int s,int stp){
        this.first = f;
        this.second = s;
        this.stp = stp;
    }
}
