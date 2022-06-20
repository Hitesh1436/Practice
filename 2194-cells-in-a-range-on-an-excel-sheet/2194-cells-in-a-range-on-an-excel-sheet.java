class Solution {
    public List<String> cellsInRange(String s) {
        // S ka format A1:D3  mtlb A-D ->4 column and 3 row  
        char [] temp = s.toCharArray();
        List<String> ans = new ArrayList<>();
        // yeh loop laya on alphabets
        for(char c1=temp[0];c1<=temp[3];c1++){
            for(char c2=temp[1];c2<=temp[4];c2++){  // yh loop h for numbers
                ans.add("" + c1 + c2);
            }
        }
        return ans;
    }
}