class Solution {
    public List<String> letterCombinations(String digits) {
        String []arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res=new ArrayList<>();
        helper(digits,0,arr,"",res);
        return res;
    }
    public void helper(String digits, int idx, String []arr, String asf, List<String> res){
        if(digits.length()==0){
            return;
        }
        if(idx==digits.length()){
            res.add(asf);
            return;
        }
        
        int index=Integer.parseInt(digits.charAt(idx)+"");
        String curr=arr[index];
        for(int i=0;i<curr.length();i++){
            char ch=curr.charAt(i);
            helper(digits,idx+1,arr,asf+ch,res);
        }
    }
}