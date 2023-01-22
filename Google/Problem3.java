class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;int n = grid[0].length;
        int vis[][] = new int[m][n];
        int cnt = 0;
        
        for(int i=0;i<m;i++){
            if(grid[i][0] == 0) dfs(grid,i,0,vis);
            if(grid[i][n-1] == 0)dfs(grid,i,n-1,vis);
        }
        
        for(int i=0;i<n;i++){
            if(grid[0][i]==0)dfs(grid,0,i,vis);
            if(grid[m-1][i]==0)dfs(grid,m-1,i,vis);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]==0){
                    dfs(grid,i,j,vis);cnt++;
                    }
            }
        }
        return cnt;
        
    }
    public void dfs(int grid[][],int i,int j,int vis[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==1 || grid[i][j]==1){
            return;
        }
        
        vis[i][j]=1;
        
        dfs(grid,i,j+1,vis);
        dfs(grid,i,j-1,vis);
        dfs(grid,i+1,j,vis);
        dfs(grid,i-1,j,vis);
    }
}
