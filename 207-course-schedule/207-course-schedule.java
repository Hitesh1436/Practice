class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] req: prerequisites){
            graph[req[0]].add(req[1]);
        }
        // inD -> inDegree array hi hai
        int[] inD = new int[numCourses];
        for(int v = 0; v < graph.length; v++){
            for(int n: graph[v]){
                inD[n]++;
            }
        } 
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int v = 0; v < graph.length; v++){
            if(inD[v] == 0){
                queue.add(v);
            }
        }
        // int[] ans = new int[graph.length];
        int count = 0;
        // int idx = ans.length - 1;
        while(queue.size() > 0){
            int rem = queue.remove();
            count++;
            // ans[idx] = rem;
            // idx--;
            
            for(int n: graph[rem]){
                inD[n]--;
                if(inD[n] == 0){
                    queue.add(n);
                }
            }
        }
        if(count == numCourses){
            return true;
        } else {
            return false;
        }
    }
}