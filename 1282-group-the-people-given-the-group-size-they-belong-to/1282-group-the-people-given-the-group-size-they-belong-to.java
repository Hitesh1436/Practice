class Solution {
    public List<List<Integer>> groupThePeople(int[] gs) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<gs.length;i++){
            if(gs[i] !=0){
            List<Integer> sub = new ArrayList<>();
            int size = gs[i];
            int num = size;
            for(int j = i;j<gs.length;j++){
                if(size == 0){
                    break;
                }
                if(gs[j] == num){
                    size--;
                    sub.add(j);
                    gs[j] = 0;
                }
            }
            ans.add(sub);
        }
      }
        return ans;
    }
}