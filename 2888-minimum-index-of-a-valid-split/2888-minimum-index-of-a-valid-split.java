class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        int maxEle = 0;
        int maxFreq = 0;
        for(int key: map.keySet()){
            if(map.get(key) > maxFreq){
                maxFreq = map.get(key);
                maxEle = key;
            }
        }
        int freq = 0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i) == maxEle){
                freq++;
            }
            if(freq > (i + 1) / 2 && (maxFreq - freq) > (nums.size() - i - 1) / 2){
                return i;
            }
        }
        return -1;
    }
}