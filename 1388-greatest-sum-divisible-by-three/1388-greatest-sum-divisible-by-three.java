class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int n = nums.length;

        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();

        for(int ele: nums) {
            sum += ele;
            if(ele % 3 == 1) rem1.add(ele);
            if(ele % 3 == 2) rem2.add(ele); 
        }

        Collections.sort(rem1);
        Collections.sort(rem2);

        if(sum % 3 == 0) {
            return sum;
        }
        if(sum % 3 == 1) {
            int option1 = rem1.size() >= 1 ? sum - rem1.get(0) : 0;
            int option2 = rem2.size() >= 2 ? sum - rem2.get(0) - rem2.get(1) : 0;
            return Math.max(option1, option2);
        }
        if(sum % 3 == 2) {
            int option1 = rem2.size() >= 1 ? sum - rem2.get(0) : 0;
            int option2 = rem1.size() >= 2 ? sum - rem1.get(0) - rem1.get(1) : 0;
            return Math.max(option1, option2);
        }
        return 0;
    }
}