class Solution {
    public String pushDominoes(String s) {
        int n = s.length();
        char[] result = s.toCharArray();
        int[] forces = new int[n];

        int force = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                force = n;
            } else if (s.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'L') {
                force = n;
            } else if (s.charAt(i) == 'R') {
                force = 0; 
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (forces[i] > 0) {
                sb.append('R');
            } else if (forces[i] < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }
}