// Following 4 steps are required in algo.

// Create graph as adjacency matrix of int[][][] type and keep edge weight and indices in the matrix. Indices are kept so that we don't loose track of indices while sorting edges in Kruskal's algo
// Create MST using Kruskal's algo on our graph created in step 1. Store this tree in new adjacency list(variable mst in code) and also the set of edges Indices used to create MST(variable mstSet)
// For each edge (u,v) not in MST, if there exist edge (x,y) in MST on path from u to v such that cost(u,v) = cost(x,y) then u,v is a psuedo critical edge
// For each edge (u,v) in MST, if it is not a psuedo critical edge, then it's a critical edge.
// Please check https://web.stanford.edu/class/archive/cs/cs161/cs161.1138/lectures/14/Small14.pdf.
// There is proof of prim's algo(also applicable for kruskal's algo) in this pdf, which can help understand the validity of step 3 and step 4.

// Intuition behind step 3: Let's say path from u to v is denoted by P(u,v) in MST. For any two vertices u and v there exists one and only path P(u,v) in MST because MST is one connected tree covering all n vertices with n-1 edges. Therefore, adding any edge (u,v) not in MST to MST will create one cycle . If (x,y) is in P(u,v) in MST such that cost(u,v) = cost(x,y), and if we remove (x,y) from MST and add (u,v) to MST, our cost of MST will remain same because we are deleting and adding same weight edge, and the cycle created by adding edge (u,v) to MST will break after we remove edge x,y, which will create new MST implying that edge (u,v) was psuedo critical.

// Intuition behind step 4: All edges in MST except psuedo critical edges were the minimum edges that we found during our algo, if we try to delete it, then the total weight cost of MST will only increase because there is no edge of the same(if such exist, it could be psuedo-critical) or less weight in non-MST which could have been added during algo run.

// Time Complexity:
// Time complexity of Kruskal = O(ELogE + ELogV)
// Time complexity to find psuedo critical edges = O(E(E'+V)) where E' are no. of edges in MST.
// We are running path on MST which is tree, therefore E' = V-1
// Hence, Time complexity to find psuedo critical edges = O(EV)
// Time complexity to find critical edges = O(E)

// Total time complexity = O(EV)

class Solution {
	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
		int[][][] g = new int[n][n][2]; //{w,ind}
		for(int i = 0; i < edges.length; i ++) {
			int[] e = edges[i];
			int f = e[0];
			int t = e[1];
			int w = e[2];
			g[f][t][0] = w;
			g[t][f][0] = w;
			g[f][t][1] = i;
			g[t][f][1] = i;
		}

		List<Integer>[] mst = new List[n];
		for(int i = 0; i < n; i ++) {
			mst[i] = new LinkedList<>();
		}

		boolean[] mstSet = new boolean[edges.length];

        Arrays.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));
        
        buildMST(n, edges, mstSet, mst, g);
		
		List<List<Integer>> ans = new ArrayList<>(2);
		Set<Integer> pce = new HashSet<>();
		List<Integer> ce = new LinkedList<>();
		
		// psuedo critical edges
		for(int i = 0; i < edges.length; i ++) {
            int f = edges[i][0], t = edges[i][1];
            int w = edges[i][2];
            int ind = g[f][t][1];
			if(!mstSet[ind]) {
                Set<Integer> cur = new HashSet<>();
				boolean p = path(f, t, w, -1, mst, g, cur);
                if(p && cur.size() > 0) {
                    pce.addAll(cur);
                    pce.add(ind);
                }
				if(!p) {
					System.out.println("Should not reach here");
				}
			}
			
		}

		// critical edges
		for(int i = 0; i < edges.length; i ++) {
            int f = edges[i][0], t = edges[i][1];
            int w = edges[i][2];
            int ind = g[f][t][1];
			if(mstSet[ind] && !pce.contains(ind)) {
				ce.add(ind);
			}
		}
		
		
		ans.add(ce);
		ans.add(new LinkedList<>(pce));
		return ans;

	}

	boolean path(int f, int t, int w, int p, List<Integer>[] mst, int[][][] g, Set<Integer> ind) {
		if(f == t) {
			return true; 
		}
		for(int nbr: mst[f]) {
			if(p != nbr) {
				
				if(path(nbr, t, w, f, mst, g, ind)) {
					if(g[f][nbr][0] == w) {
						ind.add(g[f][nbr][1]);
					}
					return true;
				}
				
			}
		}
		return false;
	}
    
    private void buildMST(int n, int[][] edges, boolean[] mste, List<Integer>[] mstg, int[][][] g){
        int weight = 0; 
        DisjointSet ds = new DisjointSet(n);
        
        for (int i = 0; i < edges.length; i++) {
            
            if (ds.union(edges[i][0], edges[i][1])) {
                weight += edges[i][2];
                int[] edge = edges[i];
                mstg[edge[0]].add(edge[1]);
                mstg[edge[1]].add(edge[0]);
                mste[g[edge[0]][edge[1]][1]] = true;
            }
        }
    }
}


class DisjointSet {
    int[] parent;
    
    public DisjointSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int i) {
        return (i == parent[i]) ? i : (parent[i] = find(parent[i]));
    }
    
    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) {
            return false;
        }
        parent[pu] = pv;
        return true;
    }
}
