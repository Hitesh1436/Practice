class Solution {
    public int[] processQueries(int[] queries, int m) {
      List<Integer> al = new ArrayList<>();
    int final_arr[] = new int[queries.length];
    for(int i=1;i<=m;i++) 
        al.add(i);
    
    for(int i=0;i<queries.length;i++){
        int temp = queries[i];
            if(al.contains(temp)){
                final_arr[i] = al.indexOf(temp);
                al.remove(al.indexOf(temp));
                al.add(0,temp);
        }
    }
    
     return final_arr;
   }
}