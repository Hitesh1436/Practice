class Solution {
    // BFS start with bus first
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0) return -1;
        if (S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>(); // stop -> {list bus pass through this stops}
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.computeIfAbsent(stop, v -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();      // bus queue
        for (int bus : map.get(S)) queue.offer(bus);
        Set<Integer> visitedBus = new HashSet<>();
        Set<Integer> visitedStop = new HashSet<>();
        visitedStop.add(S);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int bus = queue.poll();
                if (!visitedBus.add(bus)) continue;
                for (int stop : routes[bus]) {
                    if (stop == T) return count+1;
                    if (!visitedStop.add(stop)) continue;
                    for (int nextBus : map.get(stop)) 
                        if (!visitedBus.contains(nextBus)) {
                            queue.offer(nextBus);
                        }
                }
            }
            count++;
        }
        return -1;
    }
}