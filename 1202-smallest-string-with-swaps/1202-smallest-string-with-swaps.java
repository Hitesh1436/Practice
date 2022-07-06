class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] ch = s.toCharArray();
        UnionFind uf = new UnionFind(ch.length);
        HashMap<Integer,PriorityQueue<Character>>map = new HashMap<>();
        
        // set union find
        for(List<Integer>p : pairs){
            uf.union(p.get(0),p.get(1));
        }
        // set map and pq
        for(int i=0;i<s.length();i++){
            int parent  = uf.find(i);
            PriorityQueue<Character> pq = map.getOrDefault(parent,new PriorityQueue<>());
            pq.add(ch[i]);
            map.put(parent,pq);
        }
        // reorder
         for (int i = 0;i<s.length();i++){
            int parent = uf.find(i);
            ch[i] = map.get(parent).remove();
        }
        return String.valueOf(ch);
    }
}
    public class UnionFind {
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        
        public int find(int i ){
            if (parent[i] == i){
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }
        
        public void union(int i,int j ){
            int a = find(i);
            int b = find(j);
            if (a != b){
                parent[b] = a;
            }
        }
    }
