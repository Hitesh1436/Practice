class Solution {
    int c = 0;
    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis = new HashSet<>();
        Queue<String> que = new ArrayDeque<>();
        int level = 0;
        que.add(s1);
        while(que.size()>0){
            int size = que.size();
            while(size-->0){
                String config = que.remove();
                if(vis.contains(config)){
                    continue;
                }
                vis.add(config);
                if(config.equals(s2)){
                    return level;
                }
                for(String s: getNeighbors(config,s2)){
                    if(!vis.contains(s)){
                        que.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    private ArrayList<String> getNeighbors(String s1, String s2){
        ArrayList<String> list = new ArrayList<String>();
        int idx = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                idx = i; break;
            }
        }
        for(int i=idx+1;i<s2.length();i++){
            if(s1.charAt(i)==s2.charAt(idx)){
                String s = swap(s1,i,idx);
                list.add(s);
            }
        }
        return list;
    }
    
    private String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        char c = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,c);
        return sb.toString();
    }
}