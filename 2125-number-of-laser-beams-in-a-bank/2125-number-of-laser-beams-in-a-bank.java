class Solution {
    public int numberOfBeams(String[] bank) {
        int prevOnes=0;
        int ans =0;
        for(String s: bank){
            int count =0;
            for(char ch :s.toCharArray()){
                if(ch =='1'){
                    count++;
                }
            }
            if(count >0){
                ans += prevOnes *count;
                prevOnes = count;
            }
        }
        return ans;
    }
}