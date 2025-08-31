class Solution {
    private int[] best;
    private int bestDiff;

    public int[] minDifference(int n, int k) {
        best = null;
        bestDiff = Integer.MAX_VALUE;

        // Fast path for k == 2: pick the divisor closest to sqrt(n).
        if (k == 2) {
            int a = bestPair(n);
            return new int[]{a, n / a};
        }

        dfs(n, k, 1, new ArrayList<>());  // build nondecreasing factors
        return best;
    }

    // Find divisor a <= sqrt(n) maximizing a
    private int bestPair(int n) {
        int r = (int)Math.sqrt(n);
        for (int d = r; d >= 1; d--) {
            if (n % d == 0) return d;
        }
        return 1; // fallback (theoretically unreachable)
    }

    // m: remaining product, partsLeft: how many numbers to choose
    // prev: enforce nondecreasing sequence (next d >= prev)
    private void dfs(int m, int partsLeft, int prev, List<Integer> curr) {
        if (partsLeft == 1) {
            if (m < prev) return;   // must keep nondecreasing
            // Candidate = curr + m
            int minVal = curr.isEmpty() ? m : curr.get(0);
            int last = curr.isEmpty() ? 0 : curr.get(curr.size() - 1);
            int maxVal = Math.max(m, last); // m is the final (largest) element
            int diff = maxVal - minVal;

            if (diff < bestDiff) {
                bestDiff = diff;
                int[] res = new int[curr.size() + 1];
                for (int i = 0; i < curr.size(); i++) res[i] = curr.get(i);
                res[res.length - 1] = m;
                best = res;
            }
            return;
        }

        int ub = kthRootFloor(m, partsLeft);
        if (prev > ub) return; // infeasible: even the smallest allowed d is too big

        // Try divisors d of m with prev <= d <= ub
        for (int d = prev; d <= ub; d++) {
            if (m % d != 0) continue;
            curr.add(d);
            dfs(m / d, partsLeft - 1, d, curr);
            curr.remove(curr.size() - 1);
        }
    }

    // floor(m^(1/k)) without overflow
    private int kthRootFloor(int m, int k) {
        int lo = 1, hi = (k == 1 ? m : Math.min(m, (int)Math.pow(m, 1.0 / k) + 2));
        int ans = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (powLE(mid, k, m)) { ans = mid; lo = mid + 1; }
            else { hi = mid - 1; }
        }
        return ans;
    }

    // Check mid^k <= limit using safe multiplication
    private boolean powLE(int base, int exp, int limit) {
        long val = 1;
        for (int i = 0; i < exp; i++) {
            val *= base;
            if (val > limit) return false;
        }
        return true;
    }
}