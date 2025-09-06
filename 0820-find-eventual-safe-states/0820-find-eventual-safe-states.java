class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i=0;i<graph.length; i++) {
            revGraph.add(new ArrayList<>());
        }
        int[] indegree = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            for(int ele: graph[i]) {
                revGraph.get(ele).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();

        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            ls.add(node);

            for(int ele: revGraph.get(node)) {
                indegree[ele]--;
                if(indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        Collections.sort(ls);
        return ls;
    }
}