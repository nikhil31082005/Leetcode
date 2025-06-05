class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        
        // Initialize each character to be its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union by lexicographical order
        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            union(parent, a, b);
        }

        // Build result string using smallest equivalent characters
        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int rep = find(parent, ch - 'a');
            sb.append((char) (rep + 'a'));
        }

        return sb.toString();
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            if (px < py) parent[py] = px;
            else parent[px] = py;
        }
    }
}
