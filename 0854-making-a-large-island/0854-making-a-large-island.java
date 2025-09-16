class Solution {
    class DSU{
        int[] size;
        int[] parent;
        public DSU(int n) {
            size = new int[n];
            parent = new int[n];
            for(int i=0;i<n;i++){
                size[i] = 1;
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
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) {
                return;
            }
            if(size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }

        }
    }
    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        DSU d = new DSU(row * col);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dx[k];
                        int nc = j + dy[k];
                        if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                        if (grid[nr][nc] == 1) {
                            int currNode = i * col + j;
                            int nbrNode = nr * col + nc;
                            d.union(currNode, nbrNode);
                        }
                    }
                }
            }
        }
        int maxArea = 0;
        for(int i = 0; i < row * col; i++) {
            if(d.find(i) == i) {
                maxArea = Math.max(maxArea, d.size[i]);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 0){
                    int count = 1;
                    HashSet<Integer> set = new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nr = i + dx[k];
                        int nc = j + dy[k];

                        if(nr < 0 || nr >= row || nc < 0 || nc >= col){
                            continue;
                        }
                        if(grid[nr][nc] == 0) {
                            continue;
                        }
                        set.add(d.find(nr * col + nc));
                    }

                    for(int key: set) {
                        count += d.size[key];
                    }

                    maxArea = Math.max(maxArea, count);
                }
            }
        }
        return maxArea;
    }
}