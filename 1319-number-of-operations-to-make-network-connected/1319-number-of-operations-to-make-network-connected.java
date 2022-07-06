class Solution {
    int[] root;
    int[] rank;
    int count;

    public void init(int n) {
	    root = new int[n];
        rank = new int[n];
        count = n;
        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int findRoot(int x) {
        if(x == root[x])
            return x;
        return root[x] = findRoot(root[x]);
    }

    public void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if(rootX == rootY)
            return;
        if(rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        }
        else if(rank[rootX] < rank[rootY]){
            root[rootX] = root[rootY];
        }
        else {
            root[rootY] = root[rootX];
            rank[rootX] += 1;
        }
        count--;
    }

    public int makeConnected(int n, int[][] connections) {
        init(n);
        if(connections.length < n-1)
            return -1;
        for(int[] connection : connections)
            union(connection[0], connection[1]);

        return count - 1;
    }

}