class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int vis[][] = new int[m][n];
        
        int maxArea = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    maxArea = Math.max(maxArea,dfs(grid,vis,i,j));
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int grid[][],int vis[][],int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==1 || grid[i][j]==0)return 0;
        
        vis[i][j]=1;
        
        return (1+dfs(grid,vis,i+1,j)+dfs(grid,vis,i,j-1)+dfs(grid,vis,i-1,j)+dfs(grid,vis,i,j+1));
    }
}
