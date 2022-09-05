class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c=='#'){
                if(!st1.empty())
                    st1.pop();
            } else
                st1.push(c);
        }
        for(Character c : t.toCharArray()){
            if(c=='#'){
                if(!st2.empty())
                    st2.pop();
            } else
                st2.push(c);
        }
        while(!st1.empty()&&!st2.empty()){
            if(st1.pop()!=st2.pop()){
                return false;
            }
        }
        if(!st1.empty()||!st2.empty()){
            return false;
        }
        return true;
    }
}