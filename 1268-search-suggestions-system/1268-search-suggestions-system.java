class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(String product : products){
            String key = "";
            for(int i=0;i<product.length();i++){
                key += product.charAt(i);
                if(map.get(key) == null){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(product);
            }
        }
        String key = "";
        for(int i=0;i<searchWord.length();i++){
            key += searchWord.charAt(i);
            List<String> wordsWithPrefix = map.get(key);
            if(wordsWithPrefix == null){
                result.add(new ArrayList<>());
                continue;
            }
            Collections.sort(wordsWithPrefix);
            List<String> curr = new ArrayList<>();
            for(int j=0;j<3 && j<wordsWithPrefix.size();j++){
                curr.add(wordsWithPrefix.get(j));  
            }
            result.add(curr);    
        }
        return result;        
    }
}