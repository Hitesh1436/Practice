class Solution {
 public int removeStones(int[][] stones) {
    int n=stones.length;
    rank=new int[n];
    parent=new int[n];
    for(int i=0;i<n;i++){
        parent[i]=i;
        rank[i]=1;
    }
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                union(i,j);
            }
        }
    }
    int c=0;
    for(int i=0;i<n;i++){
        if(parent[i]==i)c++;
    }
    return n-c;
}
    int rank[];
    int []parent;
public void union(int u,int v){
    int ul=findPar(u);
    int vl=findPar(v);
    if(ul!=vl){
        if(rank[ul]<rank[vl]){
            parent[ul]=vl;
        }
        else if(rank[vl]<rank[ul]){
            parent[vl]=ul;
        }
        else{
            parent[ul]=vl;
            rank[ul]++;
        }
    }
}
public int findPar(int node){
    if(node==parent[node]){
        return node;
    }
    return parent[node]=findPar(parent[node]);
  }
}