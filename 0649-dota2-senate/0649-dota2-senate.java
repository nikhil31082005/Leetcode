class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();

        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i) == 'R') {
                rq.add(i);
            }
            else {
                dq.add(i);
            }
        }
        int n = senate.length();

        while(!rq.isEmpty() && !dq.isEmpty()) {
            int ri = rq.poll();
            int di = dq.poll();

            if(ri < di) {
                rq.add(n++);
            }
            else {
                dq.add(n++);
            }
        }

        return rq.isEmpty() ? "Dire" : "Radiant";
    }
}