class Solution{ 
    public int findTheCity(int n, int[][] edges, int distanceThreshold){ 
    //T->  O( V^3 ),  S-> O( V^2 ) 
        int[][] D= new int[n][n];//our matrix, containing all vertex shortest path cost 
        for ( int[] row: D ){
            //filling each row of the matrix with +infinity as the distance is unreachable till now, since we have not accesed the edge list
            //when we access the edge list the actual cost will be added to the matrix cell
             Arrays.fill(row, Integer.MAX_VALUE);
        }
        for ( int[] edge: edges){
        //adding the cost to the matrix cell   
            int from= edge[0];
            int to= edge[1];
            int wt= edge[2];
            
            //undirected edge 
            D[from][to]= wt;
            D[to][from]= wt;
        }
    
        //D -> D0 -> D1 -> D2 -> D3 -> D4 -> ......Dk//At every stage minimizing the cost 
        for ( int k= 0; k< n; k++ ){//evaluating each vertex shortest path //intermediate vertex 
            for ( int i= 0; i< n; i++ ){//Exploring all the starting vertex 
                for ( int j= 0; j< n; j++ ){//Exploring all the ending vertex 
                    if ( D[i][k] == Integer.MAX_VALUE || D[k][j] == Integer.MAX_VALUE)//if we cannot reach the k vertex from ith vertex(source) or if we cannot reach j(dest) from k, we just move on, means thats its ureachable 
                        continue;
                    else if ( ( D[i][k]+ D[k][j] ) < D[i][j] )//if including the vertex k reduce the current cost we replace it with the current cost( arr[i][j] ) //Greedy Approach 
                        D[i][j]= D[i][k] + D[k][j];  
                }
            }
        }
        
        int minNoOfCity= Integer.MAX_VALUE;//Identity of minimum 
        int res= -1;//worst case, if we cannot find any city or vertex in the vicinity of our current vertex  
        
        //every row in our matrix consist of 1 vertex(row number) and it includes min cost to all other vertex as it is a n*n matrix
        
        for ( int i= 0; i< n; i++ ){//Starting vertex 
            int noCityCount= 0;
            for ( int j= 0; j< n; j++ ){//Ending vertex 
                 if ( i == j ) //not consider the city inside city case 
                      continue;
               if ( D[i][j] <= distanceThreshold)//city within the our threshold value 
                   noCityCount+= 1;//increasing the city count for the particular vertex 
            }
            if ( noCityCount <= minNoOfCity ){//updating the minimum city count vertex every time 
                minNoOfCity= noCityCount;
                res= i;//current vertex with min no city
            }
        }
        return res;//returning the vertex with min no of city
    }
}