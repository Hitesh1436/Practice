class Solution {
    // custom class for keeping the destination from a source 
    class pair{
        int v;
        boolean art;  // true if this edge was added artificially and was not in the original Tree
        pair(int v,boolean art){
            this.v = v;
            this.art = art;
        }
    }
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer,ArrayList<pair>> map = new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(i,new ArrayList<>());
            }
        for(int []e : connections){
            int from = e[0] , to = e[1];
            map.get(from).add(new pair(to,true));  // mtlb from se to jaskte hn vo dldia map mn
            map.get(to).add(new pair(from,false));
        }
        int ans = 0;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        boolean []vis = new boolean[n];
        vis[0] = true;
        while(qu.size()>0){
            int rem = qu.remove();
            for(pair p: map.get(rem)){
                if(vis[p.v] == true) continue;
                if(p.art == true) ans++;
                qu.add(p.v);
                vis[p.v] = true;
            }
        }
        return ans;
    }
}