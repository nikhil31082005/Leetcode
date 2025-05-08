class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            return a[2] - b[2];
        });
        q.add(new int[]{0, 0, 0, 1});

        int[][] time = new int[n][m];
        for(int[] arr: time){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        time[0][0] = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int t = curr[2];
            int mt = curr[3];  // mt == move time from one room to another

            if(x == n - 1 && y == m - 1){
                return t;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    int waitTime = Math.max(moveTime[nx][ny] - t, 0);
                    int newTime = waitTime + t + mt;

                    if(newTime < time[nx][ny]){
                        time[nx][ny] = newTime;
                        if(mt == 1){
                            q.add(new int[]{nx, ny, newTime, 2});
                        }
                        else{
                            q.add(new int[]{nx, ny, newTime, 1});
                        }
                    }
                }
            }
        }

        return -1;
    }
}