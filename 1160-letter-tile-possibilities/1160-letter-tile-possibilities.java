class Solution {
    public int numTilePossibilities(String tiles) {
        List<String> ls = new ArrayList<>();
        allPossiblities(ls,tiles,"");
        return ls.size()-1;
    }

    private static void allPossiblities(List<String> ls,String tiles, String ans) {
        ls.add(ans);
        for(int i=0;i<tiles.length();i++){
            boolean val = true;
            for(int j=i+1;j<tiles.length();j++){
                if(tiles.charAt(j)==tiles.charAt(i)){
                    val = false;
                    break;
                }
            }
            if(val){
                allPossiblities(ls,tiles.substring(0,i)+tiles.substring(i+1),ans+ tiles.charAt(i));
            }
        }
    }
}