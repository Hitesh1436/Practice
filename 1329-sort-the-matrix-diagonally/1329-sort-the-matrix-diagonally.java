class Solution {
  public int[][] diagonalSort(int[][] mat) {
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();      //initialize the hashMap
    
    for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[i].length;j++){
            int k = i-j;                                       //get the index of the hashmap where to store this index value
            /*
			every diagonal will have the unique value when doing (row-col)
			this will help to uniquically indentify the diagonal
			*/
            if(map.get(k)!=null){
                map.get(k).add(mat[i][j]);                        //if index K is present then insert the value and
                Collections.sort(map.get(k));                     //then sort the list
            }else{
                List<Integer> list = new ArrayList<Integer>();   //if index k is not present then 
                list.add(mat[i][j]);                             //add element in the list and
                map.put(k,list);                                 //then create the new value in the map
            }
        }
    }
    for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[i].length;j++){
             mat[i][j] = (map.get(i-j)).remove(0);      //now retireve the value last value by removing the 0th index everytime
        }
    }
    return mat;  
  }
}