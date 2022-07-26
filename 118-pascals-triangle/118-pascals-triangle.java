class Solution {
    public List<List<Integer>> generate(int val) {
        List<List<Integer>>ans = new ArrayList<>();
        if(val <=0){
            return ans;
        }
        for(int i=0;i<val;i++){
            List<Integer> sub = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i){
                    sub.add(1);
                }else{
                    sub.add(ans.get(i-1).get(j-1)+ ans.get(i-1).get(j));
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}