class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        findCombinations(0,nums,target,ans,new ArrayList<>());
        return ans;
    }
    void findCombinations(int idx,int[]arr,int tar,List<List<Integer>>ans,List<Integer>ds){
        if(idx == arr.length){
            if(tar ==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[idx]<= tar){
            ds.add(arr[idx]);
            findCombinations(idx,arr,tar -arr[idx],ans,ds);  // pick kia h 
    // when recusrion is backtracking toh ds mn se arr[idx] htarhe hn 
            ds.remove(ds.size()-1);
        }
        findCombinations(idx+1,arr,tar,ans,ds); // pick ni kia tab
    }
}