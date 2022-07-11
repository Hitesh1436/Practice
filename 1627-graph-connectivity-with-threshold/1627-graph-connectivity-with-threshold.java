class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int len = queries.length;
        List<Boolean> result = new ArrayList<>(len);
        UnionFind uf = new UnionFind(n);
        for (int i = threshold + 1; i * 2 <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                uf.union(i, j);
            }
        }
        for (int[] query: queries) {
            result.add(uf.isConnected(query[0], query[1]));
        }
        return result;
    }   
    class UnionFind {
        int[] root;
        int[] rank;
        public UnionFind(int n) {
            root = new int[n + 1];
            rank = new int[n + 1];
        }    
        public int find(int target) {
            if (root[target] == 0) return target;
            return root[target] = find(root[target]);
        }
        public boolean isConnected(int t1, int t2) {
            return find(t1) == find(t2);
        }
        public void union(int t1, int t2) {
            int r1 = find(t1);
            int r2 = find(t2);
            if (r1 != r2) {
                if (rank[r1] > rank[r2]) {
                    root[r2] = r1;
                } else if (rank[r2] > rank[r1]) {
                    root[r1] = r2;
                } else {
                    root[r2] = r1;
                    rank[r1]++;
                }
            }
        }
    }
}