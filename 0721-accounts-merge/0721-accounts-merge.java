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
        public void union(int u, int v){
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return;

            if(rank[pu] < rank[pv]) {
                parent[pu] = pv;
            }
            else if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            }
            else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String, Integer> map =  new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                if(!map.containsKey(accounts.get(i).get(j))) {
                    map.put(accounts.get(i).get(j), i);
                }
                else {
                    dsu.union(i, map.get(accounts.get(i).get(j)));
                }
            }
        }

        List<String>[] mergeMail = new ArrayList[n];

        for(int i=0;i<n;i++){
            mergeMail[i] = new ArrayList<>();
        }

        for(String mail: map.keySet()) {
            int node = dsu.find(map.get(mail));
            mergeMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergeMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}