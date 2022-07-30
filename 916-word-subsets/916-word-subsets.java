// T.C-> O(N^2) , S.>CO(N)
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> al=new ArrayList<>();
        int target[]=new int[26];
        for(String b:words2){
            int temp[]=new int[26];
            for(char ch:b.toCharArray()){
                temp[ch-'a']++;
                target[ch-'a']=Math.max(target[ch-'a'],temp[ch-'a']);
            }
        }
        for(String word:words1){
            int freq[]=new int[26];
            for(char ch:word.toCharArray()) freq[ch-'a']++;
            if(isSubset(freq,target)){
                al.add(word);
            }
        }
        return al;
    }
    static boolean isSubset(int freq[],int target[]){
        for(int i=0;i<26;i++){
            if(freq[i]<target[i]) return false;
        }
        return true;
    }
}