class Solution {
    public int[] processQueries(int[] queries, int m) {
         int n = queries.length;
         int[] p = new int[m];
         int[] res = new int[n];

        for(int i=0; i<m; i++){
            p[i]=i+1;
        }
        for(int i=0; i<n; i++){
            int pos = findPos(p, queries[i]); // find the position
            res[i]=pos;
            moveToFirst(p, queries[i], pos); // move the number to first position
        }
        return res;
    }
    private void moveToFirst(int[] p, int num, int pos){
        int temp = p[pos];
        while(pos>0){
            p[pos]=p[pos-1];
            pos--;
        }
        p[0]=temp;
  }
    private int findPos(int[] p, int num){
        for(int i=0; i<p.length; i++){
            if(p[i]==num)
                return i;
        }
        return 0;
    }
}