Link:
https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/


Slight modification to djsktras

if we have already reached with the same dist update ways[dest]+=ways[sourcecity];
else ways[dest] = ways[sc];



Code:

class Solution {
    int mod = (int)(Math.pow(10, 9)+7);
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];int v = roads[i][1];int time  =roads[i][2];
            adj.get(u).add(new Pair(v,time));
            adj.get(v).add(new Pair(u,time));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.time-y.time);
        pq.add(new Pair(0,0));
        long dis[] = new long[n];
        int ways[] = new int[n];
        ways[0]=1;
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int city = p.first;
            int t  = p.time;
            
            for(Pair p1:adj.get(city)){
                int dest = p1.first;
                int t1 = p1.time;
                
                if(dis[dest]>t+t1){
                    dis[dest] = t+t1;
                    ways[dest]=ways[city]%mod;
                    pq.add(new Pair(dest,t+t1));
                }
                else if(dis[dest] == t+t1){
                    ways[dest]= (ways[dest]%mod+ways[city]%mod)%mod;
                }
                
            }
        }
        
        return ways[n-1];
    }
}
class Pair{
    int first;
    int time;
    
    public Pair(int f,int t){
        this.first = f;
        this.time=t;
    }
}




//Tc - O(V2)
