class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int adj[][] = new int[n][n];
        for(int row[]:adj) Arrays.fill(row,(int) Math.pow(10,9));
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];int v = edges[i][1];int w = edges[i][2];
            adj[u][v]=w;
            adj[v][u]=w;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) adj[i][j]=0;
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adj[i][j] = Math.min(adj[i][j],adj[i][k]+adj[k][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;int r=0;int ans =Integer.MIN_VALUE;
        for(int row[]:adj){
            int cities = 0;
            for(int e:row){
                if(e<=distanceThreshold) cities++;
            }
            if(cities<=min){
                min=cities;
                ans =r; 
            }
             r++;
        }
        return ans;
    }
}
