class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] result = new int[queries.length];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i<queries.length;i++){
            int ele = queries[i];
            if(map.containsKey(ele)){
                map.get(ele).add(i);
            }
            else{
                map.put(ele, new ArrayList<>());
                map.get(ele).add(i);
            }
        }

        Arrays.sort(queries);

        // Step 3: Initialize priority queue and visited array
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        pq.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        // Step 4: BFS Traversal
        int count = 0, i = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (i < queries.length) {
            int query = queries[i];

            // Expand BFS for elements smaller than the current query
            while (!pq.isEmpty() && pq.peek()[0] < query) {
                int[] curr = pq.poll();
                int val = curr[0], row = curr[1], col = curr[2];
                count++;

                // Visit neighbors
                for (int j = 0; j < 4; j++) {
                    int nx = row + dx[j], ny = col + dy[j];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        pq.offer(new int[]{grid[nx][ny], nx, ny});
                    }
                }
            }

            // Assign count to all queries of this value
            for (int index : map.get(query)) {
                result[index] = count;
            }

            i++;
        }
        return result;
    }
}