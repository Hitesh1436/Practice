class Solution {
    public int[][] diagonalSort(int[][] mat) {	
    int m = mat.length;		
    int n = mat[0].length;		
	//start from top right to top left and sort each diagonal
    for(int i = n-1;i>=0;i--){
        sort(0,i,m,n,mat);
    }
	//then start from top left to bottom left and sort each diagonal
    for(int i = 1;i<m;i++){
        sort(i,0,m,n,mat);
    }
    return mat;
}
void sort(int x, int y, int rows, int cols, int[][] mat){
	//count sort implementation
    int[] arr = new int[101];
    int s= x,e= y;
	//store the value of each diagonal element in arr
    while(x < rows && y < cols){
        arr[mat[x][y]]++;
        x++;
        y++;
    }
    //write sorted value to each diagonal element
    for(int i = 0;i<arr.length;){
        if(arr[i] <= 0){
            i++;
            continue;
        }
        if(arr[i] > 1){
            mat[s++][e++] = i;      
            arr[i]--;
        }
        else{
            mat[s++][e++] = i++;
        }  
    } 
  }
}