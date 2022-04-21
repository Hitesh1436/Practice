class Solution {
    public boolean isBipartite(int[][] graph) {
        int arr[]=new int[graph.length];
        for(int i=0;i<arr.length;i++)
        {arr[i]=-1;}
        for(int i=0;i<graph.length;i++)
        {
            if(arr[i]==-1)
            {
                if(!helper(graph,i,arr))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(int [][]graph,int k,int []arr)
    {
        Queue<Integer>q=new ArrayDeque<>();
        q.add(k);
        arr[k]=1;
        while(!q.isEmpty())
        {
           int c=q.poll();
            for(int i=0;i<graph[c].length;i++)
            {
                if(arr[graph[c][i]]==-1)
                {
                    arr[graph[c][i]]=1-arr[c];
                    q.add(graph[c][i]);
                }
               if(arr[c]==arr[graph[c][i]])
                    {
                        return false;
                    }
            }
        }
        return true;
    }
}