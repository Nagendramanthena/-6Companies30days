link:
https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/


code:
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pq.add(grid[i][j]);
                
                for(int k=1;k<=Math.min(m/2,n/2);k++){
                    if(i-k>=0 && i+k<m &&j-k>=0 && j+k<n){
                        int s = grid[i-k][j]+grid[i+k][j]+grid[i][j-k]+grid[i][j+k];
                        
                        for(int l=1;l<k;l++){
                            s += grid[i+l][j-k+l]+grid[i-k+l][j+l];
                            s += grid[i-l][j-k+l]+grid[i+k-l][j+l];
                        }
                    pq.add(s);
                    }
                }
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        while(!pq.isEmpty() && hs.size()<3){
            hs.add(pq.poll());
        }
        int ans[] = new int[hs.size()];
        int i=0;
        for(int a:hs){
            ans[i++]=a;
        }
        Arrays.sort(ans);
        int ns[] = new int[ans.length];
        for(i=0;i<ans.length;i++){
            ns[i]=ans[ans.length-i-1];
        }
        return ns;
    }
}
