class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }

        for(int[] arr: flights) {
            map.get(arr[0]).put(arr[1], arr[2]);
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});
        dis[src] = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stop = curr[2];


            if(stop > k) continue;

            for(int nbr: map.get(node).keySet()) {
                if(cost + map.get(node).get(nbr) < dis[nbr] && stop <= k) {
                    dis[nbr] = cost + map.get(node).get(nbr);
                    q.add(new int[]{nbr, cost + map.get(node).get(nbr), stop + 1});
                }
            }
        }
        return dis[dst] == Integer.MAX_VALUE ? -1: dis[dst];
    }
}