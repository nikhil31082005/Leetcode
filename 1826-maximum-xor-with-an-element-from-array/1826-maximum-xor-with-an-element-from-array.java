class Solution {
    static class Trie {
        class Node {
            Node zero;
            Node one;
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        // Add value to the Trie
        public void Add(int val) {
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (bit == 0) {
                    if (curr.zero == null) {
                        curr.zero = new Node();
                    }
                    curr = curr.zero;
                } else {
                    if (curr.one == null) {
                        curr.one = new Node();
                    }
                    curr = curr.one;
                }
            }
        }

        // Get maximum XOR for a value
        public int GetMaxXOR(int val) {
            Node curr = root;
            int ans = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (val >> i) & 1;
                if (bit == 0) {
                    // Prefer to take 1 to maximize XOR
                    if (curr.one != null) {
                        ans += (1 << i);
                        curr = curr.one;
                    } else {
                        curr = curr.zero;
                    }
                } else {
                    // Prefer to take 0 to maximize XOR
                    if (curr.zero != null) {
                        ans += (1 << i);
                        curr = curr.zero;
                    } else {
                        curr = curr.one;
                    }
                }
            }
            return ans;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Pair[] p = new Pair[queries.length];
        for(int i=0;i<p.length;i++){
            p[i] = new Pair(queries[i][0], queries[i][1], i);
        }
        Arrays.sort(p, new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.mi - o2.mi;
            }
        });
        Arrays.sort(nums);
        int j = 0;
        Trie t = new Trie();

        int[] ans = new int[queries.length];

        for(Pair q: p){
            while(j < nums.length && q.mi >= nums[j]){
                t.Add(nums[j]);
                j++;
            }
            if(j == 0){
                ans[q.i] = -1;
            }
            else{
                ans[q.i] = t.GetMaxXOR(q.xi);
            }
        }
        return ans;
    }
    class Pair {
        int xi, mi, i;
        public Pair(int xi, int mi, int i){
            this.xi = xi;
            this.mi = mi;
            this.i = i;
        }
    }
}