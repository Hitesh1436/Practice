class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> ans = new ArrayList<>();
         ans.add(1);
        if(n==0){
            return ans;
        }
        List<Integer> prev = getRow(n-1);
        for(int i=0;i<prev.size()-1;i++){
            ans.add(prev.get(i)+prev.get(i+1));
        }
        ans.add(1);
        return ans;
    }
}