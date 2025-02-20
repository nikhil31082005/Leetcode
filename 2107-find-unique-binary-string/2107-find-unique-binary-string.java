class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String ans = "";
        for(int i=0;i<nums.length;i++){
            ans = ans + (nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return ans;
    }
}