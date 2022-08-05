class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    void findCombinations(int idx,int []arr,int tar,List<List<Integer>> ans,List<Integer>ds){
        if(tar == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>tar){
                break;
            }
            ds.add(arr[i]);
            findCombinations(i+1,arr,tar-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}