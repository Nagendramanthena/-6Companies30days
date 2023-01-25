class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ans = 0;
        while (!pq.isEmpty()) {
            int val = pq.peek()[0], i = pq.peek()[1], j = pq.peek()[2];
            pq.poll();
            ans = Math.max(ans, grid[i][j]);
            if (i == n - 1 && j == n - 1) break;
            for (int d = 0; d < dir.length; ++d) {
                int nr = i + dir[d][0];
                int nc = j + dir[d][1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        return ans;
    }
}
