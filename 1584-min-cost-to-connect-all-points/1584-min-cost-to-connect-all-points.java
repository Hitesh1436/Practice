class Solution {
    Set<Integer> visited;
    PriorityQueue<Pair<int[],Integer>> pq;
    
    public void calculateDistance(int[][] points, int start){
        for (int i = 0; i < points.length; i++){
            if (i == start) continue;
            if (visited.contains(i)) continue;
            int distance = Math.abs(points[i][1] - points[start][1])+Math.abs(points[i][0] - points[start][0]);
            int[] arr = new int[]{start,i};
            Pair<int[],Integer> p = new Pair<>(arr,distance);
            pq.add(p);
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        int count = 0;
        int cost = 0;
        visited = new HashSet<>();
        visited.add(0);
        pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue()); //min Heap
        calculateDistance(points,0);
        while (count < points.length-1){
            Pair<int[],Integer> p = pq.poll();
            if (visited.contains(p.getKey()[1])) continue;
            count++;
            cost += p.getValue();
            visited.add(p.getKey()[1]); 
            calculateDistance(points,p.getKey()[1]);
        }
        return cost;
    }
}