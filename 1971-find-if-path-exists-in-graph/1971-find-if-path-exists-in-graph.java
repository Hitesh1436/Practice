class Solution {
    static public class Edge{
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Edge>();
        }
        
        for(int j=0;j<edges.length;j++){
            int v1=edges[j][0];
            int v2=edges[j][1];
            
            Edge e1=new Edge(v1,v2);
            Edge e2=new Edge(v2,v1);
            
            graph[v1].add(e1);
            graph[v2].add(e2);
        }
        
        boolean visited[]=new boolean[n];
        boolean hasp=HasPath(graph,visited,source,destination);
        return hasp;
    }
    
    
       public static boolean HasPath(ArrayList<Edge>[] graph,boolean v[],int src,int dest){
       if(src==dest){
          return true;
       }

       v[src]=true;

       for(Edge e:graph[src]){
          if(v[e.nbr]==false){
             boolean hp=HasPath(graph,v,e.nbr,dest);
             if(hp==true){
                return true;
             }
          }
       }
       return false;
    }
}