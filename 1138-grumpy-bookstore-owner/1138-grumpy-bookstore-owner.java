class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int sum = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }

        int sum2 = 0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }
        }
        int max = sum2;

        for(int i=minutes;i<customers.length;i++){
            if(grumpy[i-minutes] == 1){
                sum2 -= customers[i-minutes];
            }
            if(grumpy[i] == 1){
                sum2 += customers[i];
            }
            max = Math.max(max, sum2);
        }
        return max + sum;
    }
}