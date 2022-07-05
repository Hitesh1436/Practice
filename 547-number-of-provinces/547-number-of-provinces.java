class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        parent = new int[n];
        rank = new int[n];
                         
        for(int i=0;i<parent.length;i++){
            parent[i] =i;
            rank[i] = 1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    union(i,j);
                }
            }
        }
            int count=0;
                for(int i=0;i<n;i++){
                    if(parent[i]==i){
                        count++;
                    }
                }
                         return count;
    }
    int []parent;
    int []rank;
    public int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    public void union(int x,int y){
        int xL = find(x);
        int yL = find(y);
        
        if(rank[xL]<rank[yL]){
            parent[xL] = yL;
        }else if(rank[yL]<rank[xL]){
            parent[yL] = xL;
        }else{
            parent[xL] = yL;
            rank[yL]++;
        }
    }
}