class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0;i<n;i++) {
            dfs(i, 0, heights, pacific);
            dfs(i, m - 1, heights, atlantic);
        }

        for(int j=0;j<m;j++){
            dfs(0, j, heights, pacific);
            dfs(n - 1, j, heights, atlantic);
        }

        List<List<Integer>> ls = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]) {
                    ls.add(Arrays.asList(i, j));
                }
            }
        }
        return ls;
    }
    public void dfs(int row, int col, int[][] heights, boolean[][] visited) {
        visited[row][col] = true;

        for(int i=0;i<4;i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >= 0 && newCol >= 0 && newRow < heights.length && newCol < heights[0].length && !visited[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, heights, visited);
            }
        }
        
    }
}