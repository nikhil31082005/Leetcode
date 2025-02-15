class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            HashMap<String, Boolean> map = new HashMap<>();
            boolean ans = canBePartition(i, String.valueOf(i * i), 0, 0, map);
            if(ans){
                sum += i * i;
            }
        }
        return sum;
    }
    public boolean canBePartition(int n, String sq, int idx, int sum, HashMap<String, Boolean> map){
        if(idx == sq.length()){
            return n == sum;
        }
        String key = idx + " " + sum;
        if(map.containsKey(key)){
            return map.get(key);
        }
        for(int i = idx + 1; i <= sq.length(); i++){
            int a = Integer.parseInt(sq.substring(idx, i));
            if(canBePartition(n, sq, i, sum + a, map)){
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }
}