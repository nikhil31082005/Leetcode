class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        int[][] efforts = new int[heights.length][heights[0].length];
        for(int[] arr: efforts) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        efforts[0][0] = 0;

        pq.add(new int[]{0, 0, 0});

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int currEffort = curr[2];

            if(row == heights.length - 1 && col == heights[0].length - 1) {
                return currEffort;
            }

            for(int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length) {
                    int newEffort = Math.max(currEffort, Math.abs(heights[row][col] - heights[nr][nc]));

                    if(newEffort < efforts[nr][nc]) {
                        efforts[nr][nc] = newEffort;
                        pq.add(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }
        return 0;
    }
}