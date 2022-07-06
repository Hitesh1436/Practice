class Solution {
    public  String swapChar(String st,int i,int j){
        StringBuilder sb = new StringBuilder(st);
        sb.setCharAt(i,st.charAt(j));
        sb.setCharAt(j,st.charAt(i));
        
        return sb.toString();
    }
    
     public  int slidingPuzzle(int[][] board) {
    LinkedList<String> qu = new LinkedList<>();
    String target = "123450";
    
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            sb.append(board[i][j]);     // 2D matrix ko string mn convert krdiaa
        }
    }
    
    String initial = sb.toString();
    
    // isse pta chlega ki 0 jis bhi index pr h vo kiske sth swap hoskta h
        // index->    //    0      1       2      3      4      5   
    int [][]swapIdx = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{4,2}};
    
    qu.addLast(initial);
    int level = 0;
    HashSet<String>  vis = new HashSet<>();      // for visited mark krne ke liye
    while(qu.size()>0){
        int size = qu.size();
        while(size-->0){
            String rem = qu.removeFirst();
            if(rem.equals(target)){
                return level;
            }
// agr rem vala equal ni h toh ab pta krenge ki 0 konse index pr h 
            int idx = -1;
            for(int i=0;i<rem.length();i++){
                if(rem.charAt(i)=='0'){
                    idx = i;   // yhn se hume 0 ka index milgya hoga
                    break;
                }
            }
            int [] swap = swapIdx[idx];
            for(int i=0;i<swap.length;i++){
                String toBeAdded = swapChar(rem,idx,swap[i]);
                if(vis.contains(toBeAdded)){
                    continue;
                }
                qu.addLast(toBeAdded);
                vis.add(toBeAdded);
            }
        }
        level++;
    }
    return -1;
  }
}