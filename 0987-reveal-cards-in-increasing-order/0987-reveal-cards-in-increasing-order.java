class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<deck.length;i++){
            q.add(i);
        }

        int[] ans = new int[deck.length];
        int i = 0;
        while(!q.isEmpty()) {
            int idx = q.poll();
            ans[idx] = deck[i++];
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        return ans;
    }
}