class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count += BFS(graph, i, visited);
            }
        }
        return count;
    }
    public int BFS(List<List<Integer>> graph, int src, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true; 

        int node = 0;
        int edge = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            node++;

            for (int neighbor : graph.get(curr)) {
                edge++;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        edge /= 2;
        boolean ans = (edge == (node * (node - 1) / 2));

        return ans ? 1 : 0;
    }
}