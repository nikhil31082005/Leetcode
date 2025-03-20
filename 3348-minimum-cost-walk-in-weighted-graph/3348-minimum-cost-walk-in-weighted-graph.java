class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int walk[]=new int[n];
        Arrays.fill(walk,Integer.MAX_VALUE);
        int parent[]=new int[n];
        int ans[]=new int[query.length];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int i[]:edges)dsu(i,walk,parent);
        // System.out.println(Arrays.toString(walk)+""+Arrays.toString(parent));
        for(int i=0;i<query.length;i++){
            if(parent(query[i][0],parent)!=parent(query[i][1],parent)){
                ans[i]=-1;
            }
            else ans[i]=walk[parent(query[i][0],parent)];
            // System.out.println(ans[i]);
        }
        return ans;
    }
    public void dsu(int []edg,int []walk,int[] prnt){
        int n1=edg[0],n2=edg[1],val=edg[2];
        int prnt1=parent(n1,prnt),prnt2=parent(n2,prnt);
        if(prnt1<prnt2){
            prnt[prnt2]=prnt1;
            walk[prnt1]&=(val&walk[prnt2]);
        }
        else{
            prnt[prnt1]=prnt2;
            walk[prnt2]&=(val&walk[prnt1]);
        }
    }
    public int parent(int i,int[]prnt){
        if(prnt[i]==i)return i;
        return parent(prnt[i],prnt);
    }
}