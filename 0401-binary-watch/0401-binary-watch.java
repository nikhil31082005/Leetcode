class Solution {
    HashSet<String> set = new HashSet<>();
    public List<String> readBinaryWatch(int turnedOn) {
        int[] bits = new int[11];
        generate(turnedOn, bits, 1);
        List<String> ls = new ArrayList<>();
        for(String s: set){
            ls.add(s);
        }
        return ls;
    }
    public void generate(int turnedOn, int[] bits, int idx){
        if (idx >= 11) {
            if (turnedOn == 0) {
                String time = calculate(bits);
                if (time != null) {
                    set.add(time);
                }
            }
            return;
        }

        if(turnedOn == 0){
            String time = calculate(bits);
            if(time != null){
                set.add(time);
            }
            return;
        }

        generate(turnedOn, bits, idx + 1);
        bits[idx] = 1;
        generate(turnedOn - 1, bits, idx + 1);
        bits[idx] = 0;

    }
    public String calculate(int[] bits){
        int h = 0;
        int m = 0;

        for(int i=1;i<=4;i++){
            h += (int)(Math.pow(2, 4-i)) * bits[i];
        }

        for(int i=5;i<=10;i++){
            m += (int)(Math.pow(2, 10 - i)) * bits[i];
        }

        if (h > 11 || m > 59) {
            return null;
        }

        String min = String.valueOf(m);
        if(min.length() < 2){
            min = "0" + min;
        }
        return h + ":" + min;
    }
}