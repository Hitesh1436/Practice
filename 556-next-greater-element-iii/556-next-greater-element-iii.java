class Solution {
    public int nextGreaterElement(int n) {
      String str = Integer.toString(n);
    char [] arr = str.toCharArray();
    // To find the dip             //45132 - At pos: of 1 dip occurs
    int i = arr.length - 2;
    while(i >= 0 && arr[i] >= arr[i + 1]){
        i--;
    }
    if(i == -1)
        return -1;  
    //To Find the index of greater element than at idx i
    int j = arr.length - 1;
    while(arr[i] >= arr[j]){
        j--;
    }
    //Swaping
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;          //45231
        
    Arrays.sort(arr, i+1, arr.length);           //45213
    //Result Concat in String
    String res = new String(arr);
    // To long
    long sol = Long.parseLong(res);
    if(sol <= Integer.MAX_VALUE){
        return (int) sol;
    }
    return -1;
   }
}