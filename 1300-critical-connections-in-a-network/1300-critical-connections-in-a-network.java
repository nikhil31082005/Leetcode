class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(List<Integer> ls: connections) {
            graph.get(ls.get(0)).add(ls.get(1));
            graph.get(ls.get(1)).add(ls.get(0));
        }

        int[] time = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];

        dfs(graph, 0, 1, time, low, visited, -1);
        return ans;
    }
    public void dfs(List<List<Integer>> graph, int src, int t, int[] time, int[] low, boolean[] visited, int parent) {
        time[src] = t;
        low[src] = t;
        visited[src] = true;
        
        for(int nbr: graph.get(src)) {
            if(nbr == parent) continue;
            if(!visited[nbr]) {
                dfs(graph, nbr, t + 1, time, low, visited, src);

                low[src] = Math.min(low[src], low[nbr]);

                if(time[src] < low[nbr]) {
                    ans.add(Arrays.asList(src, nbr));
                }
            }
            else {
                low[src] = Math.min(low[src], low[nbr]);
            }


        }
    }
}