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
        int maxRow = 0, maxCol = 0;
        for(int[] s : stones) {
            maxRow = Math.max(maxRow, s[0]);
            maxCol = Math.max(maxCol, s[1]);
        }

        DSU dsu = new DSU(maxRow + maxCol + 2);

        HashSet<Integer> used = new HashSet<>();

        for(int[] s : stones) {
            int rowNode = s[0];
            int colNode = s[1] + maxRow + 1;
            dsu.union(rowNode, colNode);
            used.add(rowNode);
            used.add(colNode);
        }

        int components = 0;
        for(int node : used) {
            if(dsu.find(node) == node) components++;
        }

        return stones.length - components;
    }
}