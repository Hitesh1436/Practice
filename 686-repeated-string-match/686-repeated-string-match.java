class Solution {
    public int repeatedStringMatch(String a, String b) {
    StringBuilder sb = new StringBuilder();
        int i=0;
    for(i=1; sb.length()<=b.length(); i++){
        sb.append(a);
        if(sb.toString().contains(b)){
            return i;
        }
    }
        if(sb.append(a).toString().contains(b)){
            return i;
        }
        return -1;
    }
}