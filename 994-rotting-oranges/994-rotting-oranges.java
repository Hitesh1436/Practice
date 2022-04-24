class Solution {
    public int orangesRotting(int[][] arr) {
        Queue<int[]> q = new LinkedList<int[]>();
        int m = arr.length;
        int n = arr[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 2){
                    visited[i][j] = true;
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int ans = 0;
        while(! q.isEmpty()){
            int[] curr = q.poll();
            int i=curr[0];
            int j = curr[1];
            int time = curr[2];
            arr[i][j] = 2;
            ans = time;
            
            for(int[] it : dir){
                int row = it[0]+i;
                int col = it[1]+j;
                
                if(row<0 || col<0 || row>=m || col>=n || visited[row][col]){
                    continue;
                }
                if(arr[row][col] == 0){
                    continue ;
                }
                q.add(new int[]{row, col, time+1});
                visited[row][col] = true;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}