class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> R) {
        boolean []vis = new boolean[R.size()];
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        qu.add(0);
        
        while(qu.size()>0){
            int rem = qu.remove();
            if(vis[rem]){
                continue;
            }
            vis[rem] = true;
            for(int nbr : R.get(rem)){
                if(!vis[nbr]){
                    qu.add(nbr);
                }
            }
        }
        for(boolean room : vis){
            if(!room){
                return false;
            }
        }
        return true;
    }
}