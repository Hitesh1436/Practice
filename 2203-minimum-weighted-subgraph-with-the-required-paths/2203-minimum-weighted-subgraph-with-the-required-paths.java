class Solution {
    class Pair{
        int v;
        long weight;
        Pair(int v, long weight){
            this.v = v;
            this.weight = weight;
        }
    }
    long MAX = (long)1e15;
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest){ 
        ArrayList<ArrayList<Pair>> adj, revAdj;
        adj = new ArrayList<>();
        revAdj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            revAdj.get(e[1]).add(new Pair(e[0], e[2]));
        }
        long[] d1 = bfs(adj, n, src1);//src1 to all nodes
        long[] d2 = bfs(adj, n, src2);//src2 to all nodes
        long[] d3 = bfs(revAdj, n, dest);//dest to all nodes
        
        //Find 1 common point
        long res = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res, d1[i] + d2[i] + d3[i]);
        }
        return res >= MAX ? -1 : res;
    }
    public long[] bfs(ArrayList<ArrayList<Pair>> adj, int n, int s){
        long[] dist = new long[n];
        Arrays.fill(dist, MAX);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x1, x2) -> (int)(x1.weight-x2.weight));
        pq.add(new Pair(s, 0));
        dist[s] = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.v;
            long w = p.weight;
            if(w > dist[u]){
                 continue;
            }
            for(Pair p1: adj.get(u)){
                int v = p1.v;
                long weight = p1.weight;
                if(dist[v] > dist[u] + weight)
                {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }   
            }
        }
        return dist;
    }
}