class Solution {
    class DSU {
        int[] rank;
        int[] parent;

        public DSU(int n) {
            rank = new int[n];
            parent = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int node) {
            if(node == parent[node]) {
                return node;
            }

            return parent[node] = find(parent[node]);
        }
        public void union(int u, int v) {
            int ult_U = find(u);
            int ult_V = find(v);

            if(ult_U == ult_V) {
                return;
            }
            if(rank[ult_U] < rank[ult_V]) {
                parent[ult_U] = ult_V;
            }
            else if(rank[ult_U] > rank[ult_V]) {
                parent[ult_V] = ult_U;
            }
            else {
                parent[ult_V] = ult_U;
                rank[ult_U]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
        DSU d = new DSU(stones.length);
        for(int i=0;i<stones.length;i++){
            for(int j=i+1;j<stones.length;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    d.union(i, j);
                }
            }
        }

        int count = 0;
        for(int i=0;i<d.parent.length;i++) {
            if(i == d.parent[i]) {
                count++;
            }
        }

        return stones.length - count;
    }
}