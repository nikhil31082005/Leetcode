class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int ele: basket1){
            min = Math.min(min, ele);
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for(int ele: basket2){
            min = Math.min(min, ele);
            map.put(ele, map.getOrDefault(ele, 0) - 1);
        }

        List<Integer> ls = new ArrayList<>();

        for(int key: map.keySet()){
            if(map.get(key) % 2 != 0){
                return -1;
            }
            
            for(int i=0;i<Math.abs(map.get(key) / 2); i++){
                ls.add(key);
            }
        }

        Collections.sort(ls);

        long ans = 0;

        for(int i=0;i<ls.size()/2;i++){
            ans += Math.min(ls.get(i), 2 * min);
        }

        return ans;
    }
}