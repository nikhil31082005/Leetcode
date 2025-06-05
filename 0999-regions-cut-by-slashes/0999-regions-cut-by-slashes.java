class Solution {
    public int regionsBySlashes(String[] grid) {
        int[][] expand = new int[3*grid.length][3*grid.length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                int row = 3 * i;
                int col = 3 * j;

                if(grid[i].charAt(j) == '\\'){
                    expand[row][col] = 1;
                    expand[row + 1][col + 1] = 1;
                    expand[row + 2][col + 2] = 1; 
                }
                else if(grid[i].charAt(j) == '/'){
                    expand[row + 2][col] = 1;
                    expand[row + 1][col + 1] = 1;
                    expand[row][col + 2] = 1;
                }  
            }
        }
        

        int count = 0;
        boolean[][] visited = new boolean[expand.length][expand[0].length];
        for(int i=0;i<expand.length;i++){
            for(int j=0;j<expand[i].length;j++){
                if(!visited[i][j]){
                    if(expand[i][j] == 0){
                        bfs(expand, i, j, visited);
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public void bfs(int[][] expand, int i, int j, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for(int k=0;k<4;k++){
                int nx = row + dx[k];
                int ny = col + dy[k];

                if(nx >= 0 && nx < expand.length && ny >= 0 && ny < expand[0].length && expand[nx][ny] == 0 && !visited[nx][ny]){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

            }
        }

    }
}