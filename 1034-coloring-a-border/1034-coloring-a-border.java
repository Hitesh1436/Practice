class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<Pair> q=new LinkedList<>();
        
        q.add(new Pair(row,col));
        
        int originalColor=grid[row][col];

        boolean [][]border=new boolean[grid.length][grid[0].length];
        while(!q.isEmpty()){
            Pair curr=q.remove();
            
            if(grid[curr.row][curr.col]>0){
                grid[curr.row][curr.col]=-grid[curr.row][curr.col];
                
                int [][]dir={{0,1},{1,0},{0,-1},{-1,0}};
                int count=0;
                for(int i=0;i<4;i++){
                    int r=curr.row+dir[i][0];
                    int c=curr.col+dir[i][1];
                   
                    if(isValid(r,c,grid)){
                        
                        if(originalColor==Math.abs(grid[r][c])){
                            
                            count++;
                        }
                        
                        if(originalColor==grid[r][c]){
                            q.add(new Pair(r,c));
                        }
                    }
                }
                
                if(count<4){
                    border[curr.row][curr.col]=true;
                }
            }   
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0){
                    grid[i][j]=Math.abs(grid[i][j]);
                }
                
                if(border[i][j]){
                    grid[i][j]=color;
                }
            }
        }
        
        return grid;
    }
    
    public boolean isValid(int row, int col, int [][]grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length){
            return false;
        }
        
        return true;
    }
}

class Pair{
    int row;
    int col;
    
    public Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    public String toString(){
        return row+" "+col;
    }
}