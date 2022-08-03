class Solution {
    public int repeatedStringMatch(String A, String B) {
    // create string builder for storing A
    StringBuilder sb = new StringBuilder(A);
    int i=1;
// Add in A until it is less then B
    while(sb.length()<B.length()){
        i++;
        sb.append(A);
    }
// now check after adding in A b is substring of A or not   
    if(sb.indexOf(B)!=-1){
        return i;
    }
 //  else add one more time   
    sb.append(A);
    i++;
 // check after appended B is substring of A or not if yes then      return i else return -1;
    return sb.indexOf(B)!=-1?i:-1;
  }
}