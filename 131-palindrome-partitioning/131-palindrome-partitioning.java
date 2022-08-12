class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        helper(0,s,sub,ans);
        return ans;
    }
    void helper(int idx,String s,List<String>sub,List<List<String>>ans){
        if(idx == s.length()){
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i) == true){
                sub.add(s.substring(idx,i+1));
                // System.out.println(ans);
                helper(i+1,s,sub,ans);
                sub.remove(sub.size()-1);
            }
        }
    }
    boolean isPalindrome(String s,int st,int end){
        while(st <=end){
            if(s.charAt(st++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}