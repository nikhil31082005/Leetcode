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

    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();

        // Add all elements to the Trie
        for (int val : nums) {
            t.Add(val);
        }

        int ans = 0;
        // Find the maximum XOR
        for (int val : nums) {
            ans = Math.max(ans, t.GetMaxXOR(val));
        }
        return ans;
    }
}
