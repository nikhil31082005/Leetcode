class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int clr = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        boolean[][] visited = new boolean[image.length][image[0].length];

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if(visited[r][c]) {
                continue;
            }

            visited[r][c] = true;

            for(int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == clr) {
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }

        }
        return image;
    }
}