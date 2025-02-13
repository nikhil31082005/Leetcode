class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int ele: nums){
            pq.add((long)ele);
        }
        int count = 0;
        while(pq.size() >= 2){
            long a = pq.poll();
            if(a >= k){
                return count;
            }
            long b = pq.poll();
            pq.add(Math.min(a,b) * 2 + Math.max(a,b));
            count++;
        }
        return count;
    }
}