class Solution {
    public int orangesRotting(int[][] mat) {
        
		Queue<int[]> q = new LinkedList<>();  //queue of arr to store {i,q} position of roton orange
       
	   int freshCount = 0;     //to count all fresh oranges
        int m = mat.length;    //rows count to run loop 
        int n = mat[0].length; //cols count to run loop
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){    //iterate over matrix
               if(mat[i][j]==1){
                    freshCount++;   //count all fresh oranges present
                }
                else if(mat[i][j]==2){
                    q.add(new int[] {i,j});  //add {i,q} position of rooten oranges in queue
                }
            }
        }
        
        int minutes = 0;  //minutes which we have to return if all oranges rotten
        
        int[][] dirs = {     //Matrix of coordinate to which rotten orange can spread rotteness
            { 0, 1}, //right
            { 0,-1}, //left
            {-1, 0}, //up
            { 1, 0}  //down
        };
        
        while(!q.isEmpty()){  //if queue is not empty rotten oranges is present in queue
            int size = q.size();  //size count to runn a loop to chech adjecent of each rotten orange present in queue
            for(int i=0;i<size;i++){  //check for adjecent fresh oranges of rotten orange
                int[] curr = q.poll();  //remove rot orange from queue & consider as current orange
                for(int[] arr: dirs){  //for each arr in dirs mat
                    int x = curr[0]+arr[0];  //add possible rotten coordinate to curr cordinate
                    int y = curr[1]+arr[1];  //for checking all direction of rotten orange
                    
                    if(x<0 || y<0 || x>=m || y>=n || mat[x][y]==2 || mat[x][y]==0){  
                        continue;  //skip outOfBound & already rotten & empty cell
                    }
                    else{  //if fresh orange found in adjecent of rotten orange
                        mat[x][y] = 2; //make it rotten
                        freshCount--;  //reduce the no of fresh count
                        q.add(new int[] {x,y}); //add this rotten orange in queue
                    }
                }
            }
            
            if(!q.isEmpty()){  //if fresh oranges rot and added to queue means minutes++
                minutes++;
            }
        }
        
        if(freshCount==0){ //if no fresh orange remains return minutes
            return minutes;
        }
        return -1; // else return -1 if some fresh oranges remain
    }
}