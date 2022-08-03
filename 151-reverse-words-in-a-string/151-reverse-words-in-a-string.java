class Solution {
    public String reverseWords(String s) {
        s = s.trim();//triming all the extra spaces in front or back of the string!
        String str[] = s.split("\\s+");//Splitting String where words are separated by regular whitespace or multiple whitespaces or tabs!
        Stack<String> st = new Stack<>();
        for(String sus: str){
            st.push(sus);//pushsing all string inside the stack ==> as stack is filo so it will reverse the order of the string!
        }
        Stack<String> sus2 = new Stack<>();
        String ans = "";//to store our ans!
        while(!st.isEmpty()){
            ans+=(st.pop());//adding all strings to our ans from our st stack!
            ans+=" ";//ans simultaniously adding regular whitespaces
        }
        ans = ans.trim();//at last eliminating trailing space
        return ans;
    }
}