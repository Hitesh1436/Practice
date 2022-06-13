class Solution {
    public int numEnclaves(int[][] arr) {
// first of all we will remove zeros from the corners of the matrix
        for(int i=0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                if(i==0 ||j==0 ||i==arr.length-1 || j==arr[0].length-1){
                    dfsTraversal(arr,i,j);
                }
            }
        }
        
        int count=0;
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[i].length;j++){
            if(arr[i][j]==1){
                count++;
            }
        }
    }
    return count;
}
    public void dfsTraversal(int [][] arr,int i ,int j ){
        if(i<0 || j<0 ||i>=arr.length || j>=arr[0].length || arr[i][j]==0){
            return ;
        }
        
        arr[i][j]=0;
      dfsTraversal(arr,i-1,j);//up
      dfsTraversal(arr,i,j+1);//right
      dfsTraversal(arr,i+1,j);//down
      dfsTraversal(arr,i,j-1);//left
    }
}