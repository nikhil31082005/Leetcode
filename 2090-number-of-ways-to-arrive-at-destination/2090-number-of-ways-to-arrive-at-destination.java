import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;

        // build graph
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] arr : roads) {
            map.get(arr[0]).put(arr[1], arr[2]);
            map.get(arr[1]).put(arr[0], arr[2]);
        }

        // use long instead of int
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0}); // {node, cost}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long cost = curr[1];

            if (cost > dist[node]) continue;

            for (int nbr : map.get(node).keySet()) {
                long travelCost = map.get(node).get(nbr);
                long newDist = cost + travelCost;

                if (newDist < dist[nbr]) {
                    dist[nbr] = newDist;
                    pq.add(new long[]{nbr, newDist});
                    ways[nbr] = ways[node];
                } else if (newDist == dist[nbr]) {
                    ways[nbr] = (ways[nbr] + ways[node]) % MOD;
                }
            }
        }
        return (int) (ways[n - 1] % MOD);
    }
}
