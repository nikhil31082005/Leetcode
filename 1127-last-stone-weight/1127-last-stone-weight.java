class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: stones){
            pq.add(ele);
        }
        while(pq.size() >= 2){
            int a = pq.poll();
            int b = pq.poll();
            if(a == b){
                continue;
            }
            else{
                pq.add(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}