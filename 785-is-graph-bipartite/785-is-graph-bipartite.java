class Solution {
    public boolean checkBFS(int node, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int i: graph[n]){
                if(color[i]==-1){
                    color[i]=1-color[n];
                    q.add(i);
                }
                if(color[i]==color[n])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color,-1);
        for(int i = 0;i<v;i++){
            if(color[i]==-1&&!checkBFS(i, graph, color)){
                    return false;
            }
        }
        return true;
    }
}