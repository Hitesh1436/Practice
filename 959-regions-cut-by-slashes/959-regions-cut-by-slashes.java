class Solution {
    //Companies : Amazon, Uber, Microsoft
    public int regionsBySlashes(String[] arr) {
        int n = arr.length;
        if( n == 0 ) return 0; // 0 regions
		
		// Mapping co-ordinates , not cells
        int[] par = new int[(n+1)*(n+1)];  // ex: 1*1 matrix  has 1 column but 2 co-ordinates (0,0) & (0,1)
        
        for( int i = 0 ; i < par.length ; i++ ){
            int r = i / (n+1);
            int c = i % (n+1);  
            if( r == 0 || r == n || c == 0 || c == n ){ // boundary
                // set their common global parent
                par[i] = 1; // keep this in array range
            }else{
                par[i] = i;
            }
        }
        int regions = 1;
        for( int i = 0 ; i < arr.length ; i++ ){
            String str = arr[i];
            for( int j = 0 ; j < str.length() ; j++ ){
                char ch = str.charAt(j);
    
                if( ch == '/' ){
                    int x1 = i;
                    int y1 = j+1;
                    int x2 = i+1;
                    int y2 = j;
                    int p1 = findPar( x1*(n+1) + y1 ,par );
                    int p2 = findPar( x2*(n+1) + y2 ,par );
                    if(p1 != p2){
                        par[p2] = p1;
                    }else{
                        regions++;
                    }
                }else if( ch == '\\' ){
                    int x1 = i;
                    int y1 = j;
                    int x2 = i+1;
                    int y2 = j+1;
                    int p1 = findPar( x1*(n+1) + y1 ,par );
                    int p2 = findPar( x2*(n+1) + y2 ,par );
                    if(p1 != p2){
                        par[p2] = p1;
                    }else{
                        regions++;
                    }
                }else{ // empty space    
                }
            }
        }
        return regions;
    }
    public int findPar(int u , int[] par){
        return par[u] == u ? u : ( par[u] = findPar( par[u],par ) );
    }
}