class Solution {
    public String reverseByType(String s) {
        
        ArrayList<Character>letter=new ArrayList<>();
        ArrayList<Character>sp=new ArrayList<>();
        
        int n=s.length();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);

            if(Character.isLetter(c)){
                letter.add(c);
            }
            else{
                sp.add(c);
            }
        }
        Collections.reverse(letter);
        Collections.reverse(sp);

        int a=0;
        int b=0;
        
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isLetter(c)){
                sb.append(letter.get(a++));
            }
            else{
                sb.append(sp.get(b++));
            }
        }
        return sb.toString();
    }
}