class Solution {
     public String[] codes = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            List<String> bcase = new ArrayList<>();
            return bcase;
        }
        
         else if(digits.length()==1){
            List<String> bcase = new ArrayList<>();
              char ch = digits.charAt(0);
             String strforch = codes[ch -'0'];
             for(int i=0; i<strforch.length(); i++){
                 bcase.add(strforch.substring(i,i+1));
             }
            return bcase;
        }
        
        char ch = digits.charAt(0);
        List<String> shortans = letterCombinations(digits.substring(1));
        List<String> ans = new ArrayList<>();
        String strforch = codes[ch -'0'];
        for(int i=0; i<strforch.length(); i++){
            for(int j=0; j<shortans.size(); j++){
                ans.add(strforch.charAt(i) + shortans.get(j));
            }
        }
       return ans;
    }
}