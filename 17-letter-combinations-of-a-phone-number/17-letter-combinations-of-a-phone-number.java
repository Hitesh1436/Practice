class Solution {
    HashMap<Character,ArrayList<Character>> hm;
    ArrayList<String> al=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        hm=new HashMap<>();
        hm.put('2',new ArrayList<>(Arrays.asList('a','b','c')));
        hm.put('3',new ArrayList<>(Arrays.asList('d','e','f')));
        hm.put('4',new ArrayList<>(Arrays.asList('g','h','i')));
        hm.put('5',new ArrayList<>(Arrays.asList('j','k','l')));
        hm.put('6',new ArrayList<>(Arrays.asList('m','n','o')));
        hm.put('7',new ArrayList<>(Arrays.asList('p','q','r','s')));
        hm.put('8',new ArrayList<>(Arrays.asList('t','u','v')));
        hm.put('9',new ArrayList<>(Arrays.asList('w','x','y','z')));
        if(digits.equals("")){
            return al;
        }
        helper(digits,"");
        return al;
    }
    
    public void helper(String digits, String ans){
        if(digits.equals("")){
            al.add(ans);
            return;
        }
        char ch=digits.charAt(0);
        String subs=digits.substring(1);
        for(char n:hm.get(ch)){
            helper(subs,ans+n);
        } 
    }
}