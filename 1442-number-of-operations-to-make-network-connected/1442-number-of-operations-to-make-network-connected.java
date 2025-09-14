class Solution {
    class DSU {
        int[] rank;
        int[] parent;
        int count = 0;

        public DSU(int n) {
            rank = new int[n];
            parent = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int node) {
            if(node == parent[node]) {
                return node;
            }

            int ultimateParent = find(parent[node]);
            parent[node] = ultimateParent;
            return parent[node];
        }
        public void union(int u, int v) {
            int ult_U = find(u);
            int ult_V = find(v);

            if(ult_U == ult_V) {
                count++;
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
    public int makeConnected(int n, int[][] connections) {
        DSU d = new DSU(n);

        for(int[] arr: connections) {
            d.union(arr[0], arr[1]);
        }

        int connectedComponent = 0;
        for(int i=0;i<d.parent.length;i++){
            if(i == d.parent[i]) {
                connectedComponent++;
            }
        }
        int needed = connectedComponent - 1;
        return (d.count >= needed) ? needed : -1;
    }
}