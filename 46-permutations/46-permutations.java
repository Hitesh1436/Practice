class Solution {
    
    public void permuteHelper(List<List<Integer>> ans,int []arr,int start){
        // base case
        if(start==arr.length){
            List<Integer> base = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                base.add(arr[i]);
            }
            ans.add(base);
            return;
        }
        for(int i=start;i<arr.length;i++){
            swap(arr,start,i);
            permuteHelper(ans,arr,start+1);
            swap(arr,start,i);
        }
        
    } 
    
    public void swap(int []arr , int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]= temp;
    }
        
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteHelper(ans,nums,0);
        return ans;
    }
}