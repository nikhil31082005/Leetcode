class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: tops){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for(int ele: bottoms){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        int ans = -1;

        for(int key: map.keySet()){
            if(map.get(key) >= tops.length){
                int count = 0, count1 = 0;
                boolean f = false;
                for(int i=0;i<tops.length;i++){
                    if(tops[i] != key){
                        if(bottoms[i] == key){
                            count++;
                        }
                        else{
                            f = true;
                            break;
                        }
                    }
                }
                for(int i=0;i<bottoms.length;i++){
                    if(bottoms[i] != key){
                        if(tops[i] == key){
                            count1++;
                        }
                        else{
                            f = true;
                            break;
                        }
                    }
                }
                
                if(!f){
                    ans = Math.min(count, count1);
                }
            }
        }
        return ans;
    }
}