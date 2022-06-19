class Solution {
    public List<List<String>> suggestedProducts(String[] pro, String word) {
        List<List<String>> ans = new ArrayList<>();
        if(pro == null ||  pro.length == 0 || word == null || word.length()==0){
            return ans;
        }
        Arrays.sort(pro);
        List<String> possibleAns = new ArrayList<>();
        for(String p : pro){
            possibleAns.add(p);
        }
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            List<String> filtered = new ArrayList<>();
            for(String pd : possibleAns){
                if(i < pd.length() && ch == pd.charAt(i)){
                    filtered.add(pd);
                }
            }
            List<String> atMostThree = new ArrayList<>();
            for(int j=0;j<3 && j<filtered.size();j++){
                atMostThree.add(filtered.get(j));
            }
            
            ans.add(atMostThree);
            possibleAns = filtered;
        }
        return ans;
    }
}