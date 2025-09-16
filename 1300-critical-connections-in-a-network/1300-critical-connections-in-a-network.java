class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> ls: connections){
            graph.get(ls.get(0)).add(ls.get(1));
            graph.get(ls.get(1)).add(ls.get(0));
        }

        List<List<Integer>> bridges = new ArrayList<>();

        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        dfs(0, -1, visited, tin, low, graph, bridges);
        return bridges;
    }
    public void dfs(int node, int parent, boolean[] visited, int[] tin, int[] low, List<List<Integer>> graph, List<List<Integer>> bridges) {
        visited[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;
        for(int nbr: graph.get(node)){
            if(nbr == parent) continue;

            if(!visited[nbr]) {
                dfs(nbr, node, visited, tin, low, graph, bridges);

                low[node] = Math.min(low[nbr], low[node]);

                if(tin[node] < low[nbr]){
                    bridges.add(Arrays.asList(node, nbr));
                }
            }
            else {
                low[node] = Math.min(low[node], tin[nbr]);
            }
        }
    }
}