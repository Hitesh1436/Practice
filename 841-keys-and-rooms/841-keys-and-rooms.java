class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean []vis = new boolean[rooms.size()];
        dfs(rooms.get(0),0,rooms,vis);
        for(int i=0;i<vis.length;i++){
            if(vis[i] == false){
                return false;
            }
        }
        return true;
    }
    private void dfs(List<Integer>keysInRoom,int r,List<List<Integer>> rooms,boolean []vis){
        vis[r] = true;  // mark krdia
        
        for(int i : keysInRoom){
            if(vis[i]== false){
                dfs(rooms.get(i),i,rooms,vis);
            }
        }
    }
}