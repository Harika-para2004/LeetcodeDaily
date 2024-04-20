class Solution {
    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> res=new ArrayList<>();
        int n=land.length;
        int m=land[0].length;
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1){
                    dfs(i,j,l,land);
                }
                if(l.size()>0){
                    res.add(new ArrayList<>(l));
                    l.clear();
                }
            }
        }
        int r[][]=new int[res.size()][4];
        for(int i=0;i<r.length;i++){
            for(int j=0;j<4;j++){
                r[i][j]=res.get(i).get(j);
            }
        }
        return r;
    }
    void dfs(int i,int j,List<Integer> l,int ld[][]){
        if(i<0 || j<0 || i>=ld.length || j>=ld[0].length || ld[i][j]==0){
            return;
        }
        ld[i][j]=0;
        if(l.size()==4){
            if(l.get(2)<i){
                l.set(2,i);
                l.set(3,j);
            }
            else if(l.get(2)==i && l.get(3)<j){
                l.set(3,j);
            }
        }
        else if(l.size()==0){
            l.add(i);
            l.add(j);
            l.add(i);
            l.add(j);
        }
        dfs(i+1,j,l,ld);
        dfs(i-1,j,l,ld);
        dfs(i,j+1,l,ld);
        dfs(i,j-1,l,ld);
    }
}