class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      ArrayList<ArrayList<Integer>>graph=new ArrayList<>(numCourses);
      for(int i=0;i<numCourses;i++){
          graph.add(new ArrayList<Integer>());
      }
      int len=prerequisites.length;
      int inDegree[]=new int[numCourses];
      for(int i=0;i<len;i++){
          graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
          inDegree[prerequisites[i][0]]++;
      }
      Queue<Integer>q=new LinkedList<Integer>();
      int count=0;   
      for(int i=0;i<inDegree.length;i++){
          if(inDegree[i]==0){
             q.add(i);     
          }
      }
      while(!q.isEmpty()){
        int rem=q.remove();
        count++; 
        for(int i : graph.get(rem)){
            inDegree[i]--;
            if(inDegree[i]==0){
                q.add(i);
            }
        }
      }
      if(numCourses == count){
          return true;
      }
        return false;
    }
}