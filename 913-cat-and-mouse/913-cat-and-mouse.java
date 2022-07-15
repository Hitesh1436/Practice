class Solution {
    int maxTime = 200;
    int draw = 0;
    int mw = 1;  // mw -> mouse win
    int cw = 2;  // cw -> cat win
    public int catMouseGame(int[][] graph) {
        return dfs(0, new int[]{1, 2}, graph, new Integer[maxTime+1][graph.length][graph.length]);
    }

    private int dfs(int time, int[] p, int[][] graph, Integer[][][] memo){ // p[0] -> mouse position, p[1] -> cat position
        Integer old = memo[time][p[0]][p[1]];
        if (old != null)      return old;       // all the base cases here
        if (time >= maxTime) return draw;
        if (p[0]==0)          return mw;
        if (p[0]==p[1])       return cw;
        int state = 0;
        int where = p[time&1];
        int res = draw;
        for (int i = 0; i < graph[where].length; i++){
            if ((time&1)==0||graph[where][i]>0){ // if mouse turn or cat turn and the dest is not 0, do ...
                p[time&1]=graph[where][i];
                state |= 1 << dfs(time+1, p, graph, memo);
                if ((time&1)>0&&(state&4)>0 || (time&1)==0&&(state&2)>0) // if mouse's turn & mouse win
                    break;                                               // or cat's turn & cat win, then we stop.
            }
        }
        p[time&1]=where; // restore p
        if (((time&1)>0 && (state & 4)>0)||((time&1)==0) && state==4){ 
            res = cw; // cat win when (cat's turn & cat win) or (mouse's turn and state = cat)
        }else if (((time&1)==0 && (state & 2)>0)||(time&1)==1 && state==2){
            res = mw; // mouse win when (mouse's turn and mouse win) or (cat's turn and state = mouse)
        }
        return memo[time][p[0]][p[1]]=res;
    }
}