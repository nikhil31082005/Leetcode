class Solution {
    public long putMarbles(int[] weights, int k) {
        List<Integer> pairSum = new ArrayList<>();

        for(int i=0;i<weights.length -1;i++){
            pairSum.add(weights[i] + weights[i+1]);
        }

        Collections.sort(pairSum);
        long res = 0;
        for(int i=0;i<k-1;i++){
            int min = pairSum.get(i); 
            int max = pairSum.get(pairSum.size() - 1 - i); 
            res += max - min;
        }
        return res;
    }
}