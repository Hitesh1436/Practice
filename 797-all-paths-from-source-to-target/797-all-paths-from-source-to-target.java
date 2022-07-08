class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        int n=graph.length;
        boolean [] visited=new boolean[n];
        ArrayList<Integer> path=new ArrayList<Integer>();
        path.add(0); //adding src in path
        dfs(graph,0,n-1,visited,result,path);//dfs traversal for src 0 to n-1
        return result;
    }
    
    public static void dfs(int[][] graph,int src,int dest,boolean visited[],List<List<Integer>> result,List<Integer> path){
        if(src==dest){
            List<Integer> list=new ArrayList<>(path);
            result.add(list);
            return;
        }
        visited[src]=true;
        for(int e :graph[src]){
            if(!visited[e]){
                path.add(e);
                dfs(graph,e,dest,visited,result,path);
                path.remove(path.size()-1);
            }
        }
        visited[src]=false;
    }
}