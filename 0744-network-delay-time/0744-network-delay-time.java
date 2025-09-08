class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for(int i=0;i<=n;i++){
            map.put(i, new HashMap<>());
        }

        for(int[] arr: times) {
            map.get(arr[0]).put(arr[1], arr[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int[] dist =  new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            // if(time > dist[node]) continue;

            for(int nbr: map.get(node).keySet()) {
                int taketime = map.get(node).get(nbr);

                if(taketime + time < dist[nbr]) {
                    dist[nbr] = taketime + time;
                    pq.add(new int[]{nbr, dist[nbr]});
                }
            }
        }

        int ans = 0;
        for(int i=1 ; i <= n;i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans ;
    }
}