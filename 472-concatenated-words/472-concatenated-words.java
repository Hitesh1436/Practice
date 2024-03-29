class Solution {
    class Node {
        Node[] arr = new Node[26];
        boolean eow = false;
    }
    Node root = new Node();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for(String word: words){
            Node temp = root;
            for(char ch: word.toCharArray()){
                if(temp.arr[ch - 'a'] == null){
                    temp.arr[ch - 'a'] = new Node();
                }
                temp = temp.arr[ch - 'a'];
            }
            temp.eow = true;
        }
        List<String> res = new ArrayList<>();
        for(String word: words){
            flag = false;
            wordBreak(word, 0, 0);
            if(flag == true){
                res.add(word);
            }
        }
        return res;
    }
    boolean flag = false;
    private void wordBreak(String word, int i, int wsf){
        if(i == word.length()){  // wsf -> word so far
            if(wsf >= 2){
                flag = true;
            }
            return;
        }
        
        Node temp = root;
        for(int j = i; j < word.length(); j++){
            char ch = word.charAt(j);
            if(temp.arr[ch - 'a'] != null){
                temp = temp.arr[ch - 'a'];
                if(temp.eow == true){
                    wordBreak(word, j + 1, wsf + 1);
                }
            } else {
                return;
            }
        }
    }    
}