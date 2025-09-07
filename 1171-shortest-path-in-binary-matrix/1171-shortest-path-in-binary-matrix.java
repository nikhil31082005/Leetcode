class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        int[] dx = {-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2];

            if(row == grid.length - 1 && col == grid[0].length - 1) {
                return cost;
            }

            for(int i=0;i<8;i++){
                int nr = row + dx[i];
                int nc = col + dy[i];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, cost + 1});
                }
            }
        }
        return -1;
    }
}