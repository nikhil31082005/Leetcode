class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total = 0;
        for(int ele: distance){
            total += ele;
        }
        int sum = 0;
        for(int i = Math.min(start, destination); i < Math.max(start, destination); i++){
            sum += distance[i];
        }
        return Math.min(sum, total - sum);
    }
}