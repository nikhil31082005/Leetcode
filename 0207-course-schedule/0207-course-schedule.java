class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] arr: prerequisites) {
            graph.get(arr[0]).add(arr[1]);
        }

        int[] indegree = new int[numCourses];

        for(int[] arr: prerequisites) {
            indegree[arr[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for(int ele: graph.get(curr)) {
                indegree[ele]--;
                if(indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }

        if(count == numCourses) {
            return true;
        }
        return false;
    }
}