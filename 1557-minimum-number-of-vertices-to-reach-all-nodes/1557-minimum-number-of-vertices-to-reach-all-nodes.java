// jiski indegree 0 h usse ans mn add krdo bcz vo bas khudtk jaskta h koi ustk ni askta
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int []indegree = new int[n];
        
        for(List<Integer> e : edges){
            int from = e.get(0);
            int to = e.get(1);
                 indegree[to]++;  //bcz iski trf jarhe hn to 1 increment hogya
        }
        for(int i=0 ;i<n;i++){
            if(indegree[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}