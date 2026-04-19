class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];

        Arrays.sort(sources, (a, b) -> b[2] - a[2]);
        Queue<int[]> q = new LinkedList<>();

        for(int[] arr: sources) {
            int a = arr[0], b = arr[1], c = arr[2];
            grid[a][b] = c;
            q.add(arr);
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int color = curr[2];
            
            for(int i = 0; i < 4; i++) {
                int nr = dx[i] + row;
                int nc = dy[i] + col;

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0) {
                    grid[nr][nc] = color;
                    q.add(new int[]{nr, nc, color});
                }
            }
        }
        return grid;
    }
}