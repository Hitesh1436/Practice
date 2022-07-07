class Solution {
    int []parent;
    int []rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        rank = new int[s.length()];
        
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            rank[i] =0;
        }
         char ch[]=s.toCharArray();
        for(int i=0;i<pairs.size();i++)
        union(pairs.get(i).get(0),pairs.get(i).get(1));
    Map<Integer,PriorityQueue<Character>> mp=new HashMap<>();
    for(int i=0;i<s.length();i++){
        int x=find(i);
        if(mp.containsKey(x)){
            PriorityQueue<Character> pq=mp.get(x);
            pq.offer(ch[i]);
            mp.put(x,pq);
        }
        else{
         PriorityQueue<Character> pq=new PriorityQueue<>();
            pq.offer(ch[i]);
            mp.put(x,pq);
        } 
    }
    char ans[]=new char[parent.length];
    for (int i = 0; i < ans.length; i++) 
        ch[i] = mp.get(find(i)).poll();
    return new String(ch);
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            parent[x]= find(parent[x]);
            return parent[x];
        }
    }
    public void union(int x,int y){
        int xl = find(x);
        int yl = find(y);
        if(rank[xl]<rank[yl]){
            parent[yl]=xl;
        }else if(rank[yl]<rank[xl]){
            parent[xl]=yl;
        }else{
            parent[xl] = yl;
            rank[yl]++;
        }
    }
}