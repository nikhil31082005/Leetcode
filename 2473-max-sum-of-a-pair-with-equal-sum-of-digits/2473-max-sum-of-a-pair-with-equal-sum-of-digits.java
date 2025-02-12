class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int ele: nums){
            int sum = digitSum(ele);
            if(map.containsKey(sum)){
                map.get(sum).add(ele);
            }
            else{
                map.put(sum, new PriorityQueue<>(Collections.reverseOrder()));
                map.get(sum).add(ele);
            }
        }
        int maxSum = -1;
        for(int key: map.keySet()){
            if(map.get(key).size() >= 2){
                int a = map.get(key).poll();
                int b = map.get(key).poll();
                maxSum = Math.max(maxSum, a + b);
            }
        }
        return maxSum;
    }
    public int digitSum(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}