class Solution {
    
    // "parents" and "ranks" arrays required for applying DSU
    int[] parents;
    int[] ranks;
    
    // v: vertex
    private int find(int v) {
        // using recursion, we'll find the "ultimate" leader after going from parent to parent (until v is its parent i.e. parents[v] == v), which will be the base case
        if(parents[v] == v) {
            return v;
        }
        
        // we got our leader
        int leader = find(parents[v]);
        // for efficiency, now we'll update our parent with leader directly (so that next time we won't have to travel that long). This step is called "path compression"
        parents[v] = leader;
        
        return leader;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        // tree: a connected, acyclic graph. Here, it is also "undirectional". 
        // no. of "edges" for this tree = no. of "vertices" - 1
        
        // vc: vertices count
        int vc = edges.length;
        
        // We'll find the "redundant edge" using DSU (disjoint set union). For DSU, we actually need "edges" which are convenient given (instead of graph) 
        // looking at the input, we observe that the vertices are 1-indexed (will take care of that)
        parents = new int[vc];
        ranks = new int[vc];
        
        // initialization of parents and ranks
        for(int i = 0; i < vc; i++) {
            // initially, for each vertex parent is itself and rank is 0
            parents[i] = i;
            ranks[i] = 0;
        }
        
        // preparation done for applying DSU: done using union() and find(). If we write a separate function union() for DSU (here done below), the above preparatory steps are done in there
        
        // now, we'll loop through each edge and check to see if it is redundant using DSU
        for(int i = 0; i < edges.length; i++) {
            // since vertices of the edges are given to be 1-indexed, we'll assume 1 as 0 (by subtracting u and v by 1 below)
            int u = edges[i][0]; u--;
            int v = edges[i][1]; v--;
            
            // lu: leader (group leader) of u, lv: leader (group leader) of v
            int lu = find(u);
            int lv = find(v);
            
            if(lu != lv) {
                // u and v belong to different groups 
                // i.e. merging of those groups will take place (based on ranks of lu and lv)
                // smaller rank vertex will go into the group of larger rank vertex
                if(ranks[lu] < ranks[lv]) {
                    // lu will make lv its parent
                    parents[lu] = lv;
                    
                } else if(ranks[lu] > ranks[lv]) {
                    // lv will make lu its parent
                    parents[lv] = lu;
                    
                } else {
                    // ranks[lu] == ranks[lv]
                    // anyone can go in any group; but whoever's group it goes will increase its rank by 1
                    parents[lu] = lv;
                    ranks[lv]++; // increasing rank of lv by 1 (since lu merged its group under lv)
                    
                }
                
            } else {
                // we found our redundant edge
                return edges[i];
            }
        }
        
        // some invalid edge (will not hit this case)
        return new int[] {-1, -1}; 
    }
}