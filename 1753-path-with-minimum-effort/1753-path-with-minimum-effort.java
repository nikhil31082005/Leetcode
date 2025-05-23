class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        int rows = heights.length;
        int cols = heights[0].length;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        boolean[][] visited = new boolean[rows][cols];
        // visited[0][0] = true;

        int[][] effort = new int[rows][cols];
        for(int[] arr: effort){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int currEffort = curr[2];

            if(r == rows-1 && c == cols-1){
                return currEffort;
            }

            if(visited[r][c]){
                continue;
            }

            visited[r][c] = true;

            for(int i=0;i<4;i++){
                int nx = dx[i] + r;
                int ny = dy[i] + c;
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]){
                    int newEffort = Math.max(currEffort, Math.abs(heights[nx][ny] - heights[r][c]));

                    if (newEffort < effort[nx][ny]) {
                        effort[nx][ny] = newEffort;
                        pq.add(new int[]{nx, ny, newEffort});
                    }
                }
            }
        }
        return 0;
    }
}