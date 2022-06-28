class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n ==0) return ans;
        
        for(int i=0;i<n;i++){
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for(int j=1;j<i+1;j++){
                res.add(res.get(res.size()-1)*(i-j+1)/j);
            }
            ans.add(res);
        }
        return ans;
    }
}