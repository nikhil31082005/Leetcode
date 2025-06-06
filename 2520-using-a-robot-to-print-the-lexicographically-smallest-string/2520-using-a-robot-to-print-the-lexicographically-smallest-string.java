class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }

        char min = 'a';
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            st.push(c);
            freq[c - 'a']--;
            while(min != 'z' && freq[min - 'a'] == 0){
                min++;
            }
            while(!st.isEmpty() && st.peek() <= min){
                sb.append(st.pop());
            }
        }
        return sb.toString();
    }
}