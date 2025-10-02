class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) -> {
            // return (a[1]-a[0]) - (b[1]-b[0]);
            return a[1] - b[1];
        });

        for(int[] arr : courses){
            System.out.println(arr[0] +" "+arr[1]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = 0;
        long sum = 0;
        for(int[] arr : courses) {
            int duration = arr[0];
            int lastDay = arr[1];
            if(sum + duration <= lastDay){
                sum += duration;
                pq.add(duration);
            }
            else if(!pq.isEmpty() && pq.peek() > duration){
                sum += duration - pq.poll();
                pq.add(duration);
            }
        }
        return pq.size();
    }
}