class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        
        for(int i = 0 ; i < n ; i+=2){
            parent[row[i]] = row[i];
            parent[row[i + 1]] = row[i];
        }
        int count = 0;
        for(int i = 0 ; i < n ; i+=2){
            int p1 = find(i);
            int p2 = find(i + 1);
            if(p1 != p2){
                parent[p2] = p1;
                count++;
            }
        }
        return count;
    }
    int[] parent;
    public int find(int u){
        if(parent[u] ==u){
            return u;
        }else{
            parent[u] = find(parent[u]);
            return parent[u];
        }
    }
}