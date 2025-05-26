class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<colors.length();i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[colors.length()];
        for(int[] arr: edges){
            graph.get(arr[0]).add(arr[1]);
            indegree[arr[1]]++;
        }

        int visited = 0;
        int maxColorValue = 0;

        int[][] dp = new int[n][26];

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<colors.length();i++){
            if(indegree[i] == 0){
                q.add(i);
            }
            dp[i][colors.charAt(i) - 'a']++;
        }

        while(!q.isEmpty()){
            int node = q.poll();
            visited++;

            for(int nbr: graph.get(node)){
                for(int c = 0; c < 26; c++){
                    int inc =( colors.charAt(nbr) - 'a' == c) ? 1 : 0;
                    dp[nbr][c] = Math.max(dp[nbr][c], dp[node][c] + inc);
                }

                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }

            for(int ele: dp[node]){
                maxColorValue = Math.max(maxColorValue, ele);
            }
        }
        return visited == n ? maxColorValue: -1;
    }
}