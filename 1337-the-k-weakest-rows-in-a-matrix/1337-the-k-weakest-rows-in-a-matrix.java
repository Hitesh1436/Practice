// count krlo harr row mn kisme kitne 1 hain and unhe ek array mn store krdo 
//hume milega kuch esa for example 1 -> [2,4,1,2,5]and k=3 hai toh hume
// iss arra ko increasing mn sort krna hoga toh milega -> [1,2,2,4,5]

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        //Create an array of size no. of rows present in mat
        int arr[] = new int[rows];
        for(int i = 0; i < rows; i++){
            int count = 0;
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            arr[i] = count;
        }   
        
        int ans[] = new int[k];//Create ans array of size k
        for(int i = 0; i < k; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            ans[i] = minIndex;
            arr[minIndex] = Integer.MAX_VALUE;
        }
        
        return ans;
        
    }
}