class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int idx = 0;
        int rem = grid[0][0] % x;
        for(int[] ele: grid){
            for(int n: ele){
                arr[idx++] = n;
                if(n % x != rem){
                    return -1;
                }
            }
        }
        Arrays.sort(arr);
        int mid = arr.length / 2;
        int ele = arr[mid];
        int op = 0;
        for(int num: arr){
            op += Math.abs(num - ele) / x;
        }
        return op;
    }
}