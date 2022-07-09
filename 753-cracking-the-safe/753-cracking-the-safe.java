class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(0);
        }
        HashSet<String> vis = new HashSet<>();
        vis.add(sb.toString());
        
        int limit = (int)Math.pow(k,n);
        dfs(sb,vis,limit,n,k);
        
        return sb.toString();
    }
    private boolean dfs(StringBuilder sb,HashSet<String> vis,int lim,int n,int k){
        if(vis.size()== lim){
            return true;  // mtlb answer milgya 
        }
        String lnm1 = sb.substring(sb.length()-(n-1));  // lnm1-> length n minus one mtlb last ke n-1 change krna h new pwsrd bnne ke liye 
        for(int i=0;i<k;i++){
            String npwd = lnm1 + i; // npwd - > new password
            if(!vis.contains(npwd)){
                vis.add(npwd);
                sb.append(i);
                boolean flag = dfs(sb,vis,lim,n,k);
                if(flag == true){
                    return true;
                }else{
                    vis.remove(npwd);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return false;
    }
}