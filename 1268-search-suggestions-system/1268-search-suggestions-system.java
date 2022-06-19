class Solution {
     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();

        //sort products lexicographically
        Arrays.sort(products);

        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);

            // Note: binary search returns the index of the first element if it is present,
            // otherwise returns (-)insertion point for the element.
            int index = Arrays.binarySearch(products, prefix);

            // no prefix in products
            // take the next word greater than the prefix.
            if (index < 0) {
                index = -index - 1;
            }

            List<String> suggestions = new ArrayList<>();
            int max = index + 3;
            for (int j = index; j < products.length; j++) {
                if (j == max){ // if we have reached the max number of suggestions
                    break;
                }

                if (products[j].startsWith(prefix)) { // if the product starts with the prefix
                    suggestions.add(products[j]);
                }
            }

            ans.add(suggestions);
        }

        return ans;
    }
}