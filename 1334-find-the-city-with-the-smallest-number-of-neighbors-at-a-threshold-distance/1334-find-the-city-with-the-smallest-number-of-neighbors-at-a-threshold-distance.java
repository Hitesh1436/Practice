class Solution {
    public int findTheCity(int N, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>(); // Initialize the Graph

        for(int[] edge : edges){ // Add Each edge entry in both Cities as graph is bidirectional

            graph.putIfAbsent(edge[0], new ArrayList<>()); // Add the first City if not already present
            graph.putIfAbsent(edge[1], new ArrayList<>()); // Add the second City if not already present
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]}); // Add edge from City A to City B
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]}); // Add edge from City B to City A

        }

        int res = Integer.MAX_VALUE; // res represents the least count seen in the loop
        int city = Integer.MIN_VALUE; // city represents the city with the least count

        for(int i = 0; i < N; ++i){ // We implement Dijkstra's for each City from 0 to (N - 1)

            /* count for the current city i.
               We start from -1 to not count the current city we are in
             */
            int count = -1;

            // Priority Queue must compare the weights, which is the second param in our passed int[] array
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            // Holds minimum Distances from the i'th city to all other cities. Initially will be filled with Int Max
            int[] minDistances = new int[N];
            Arrays.fill(minDistances, Integer.MAX_VALUE);

            // Starting city's (i) distance will be Zero
            minDistances[i] = 0;

            // int[i][0] represents int[startingCity][startingWeight]
            pq.add(new int[]{i, 0});

            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int currCity = curr[0], currWeight = curr[1];

                /* if the currWeight > minDistance it means this city can
                   be skipped as we already have a more optimal solution.
                   This check also acts as a check for whether a city has already been
                   visited or not and hence we need not use a boolean[] visited array
                 */
                if(currWeight > minDistances[currCity]) continue;

                if(!graph.containsKey(currCity)) continue; // Check if graph contains currCity or not

                // If the currWeight is less than or equal to threshold, we can increment the count
                if(currWeight <= distanceThreshold) count ++;

                if(!graph.containsKey(currCity)) continue;

                /* For Each Neighbouring city from the currCity,
                   we implement the Relaxation part of Dijkstra's Algorithm
                 */
                for(int[] neighbours : graph.get(currCity)){

                    // Get the Neighbouring City and the weight of the edge connecting it to currCity
                    int newCity = neighbours[0], newWeight = neighbours[1];

                    /* Check if the currWeight and the weight to the next city(newCity) < value of distance to
                       reach the new City present in minDistances Array
                     */
                    if(newWeight + currWeight < minDistances[newCity]){

                        // Update minDistances Array
                        minDistances[newCity] = newWeight + currWeight;

                        // Add a new entry to the Priority Queue
                        // PS : PriorityQueue is an unbounded Queue, so the methods .add() and .offer() are Synonymous
                        pq.add(new int[]{newCity, newWeight + currWeight});
                    }
                }
            }

			// If curent city's count is less than least seen count(res), update res and city
            if(count <= res){
                res = count;
                city = i;
            }
        }
        return city;
    }
}