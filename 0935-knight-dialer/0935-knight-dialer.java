import java.util.*;

class Solution {
    int MOD = 1000000007;

    int[][] jumps = {
        {4,6},    // 0
        {6,8},    // 1
        {7,9},    // 2
        {4,8},    // 3
        {0,3,9},  // 4
        {},       // 5
        {0,1,7},  // 6
        {2,6},    // 7
        {1,3},    // 8
        {2,4}     // 9
    };

    static class Node {
        int digit;
        long ways;
        Node(int d, long w){
            digit = d;
            ways = w;
        }
    }

    public int knightDialer(int n) {
        Queue<Node> q = new LinkedList<>();

        // Level 0 initialization (all digits start with 1 way)
        for(int i = 0; i <= 9; i++){
            q.offer(new Node(i, 1));
        }

        int level = 0;

        // BFS levels
        while(level < n - 1){
            int size = q.size();
            Map<Integer, Long> nextLevel = new HashMap<>();

            for(int i = 0; i < size; i++){
                Node cur = q.poll();

                for(int nei : jumps[cur.digit]){
                    nextLevel.put(
                        nei,
                        (nextLevel.getOrDefault(nei, 0L) + cur.ways) % MOD
                    );
                }
            }

            // push next level
            for(Map.Entry<Integer, Long> e : nextLevel.entrySet()){
                q.offer(new Node(e.getKey(), e.getValue()));
            }

            level++;
        }

        long ans = 0;
        while(!q.isEmpty()){
            ans = (ans + q.poll().ways) % MOD;
        }

        return (int) ans;
    }
}
