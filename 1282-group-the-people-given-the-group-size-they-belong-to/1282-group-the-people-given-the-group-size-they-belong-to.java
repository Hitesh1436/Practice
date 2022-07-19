class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList();
        HashMap<Integer, List<Integer>> hm = new HashMap();
		// Approach is to create the Integer - List hashmap since we have size of group of current "i" and we have to return the list of lists.
		// We simply add index I to the List corresponding to the given size and if it get filled we add the current completed list to the final answer and empties it.
       
	   for(int i = 0; i < groupSizes.length; i++){
            if(hm.containsKey(groupSizes[i])){                 
                if(hm.get(groupSizes[i]).size() < groupSizes[i]){
                    hm.get(groupSizes[i]).add(i);
                }
                else{
                    res.add(hm.get(groupSizes[i]));
                    hm.put(groupSizes[i], new ArrayList());
                    hm.get(groupSizes[i]).add(i);
                } 
            }
            else{
                List<Integer> first = new ArrayList();
                first.add(i);
                hm.put(groupSizes[i], first);
            }
        }
        for(int key : hm.keySet()){
            res.add(hm.get(key));
        }
        return res;
    }
}