class Solution {
    public  int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<routes[i].length;j++){   // routes[0] ni lena bcz soute size vary krskta hai
                int busStopNo = routes[i][j];
                ArrayList<Integer> busNo = map.getOrDefault(busStopNo,new ArrayList<>());
                busNo.add(i);               // 0,1,2,3 add kia
                map.put(busStopNo,busNo);  // busStopNo ke corresponding busNo ko put kia h
            }
        }
        
        LinkedList<Integer> qu = new LinkedList<>();
        HashSet<Integer> busStopVis = new HashSet<>();
        HashSet<Integer> busVis = new HashSet<>();
        int level = 0;
        
        qu.addLast(S);     // queue mn source add kia 
           busStopVis.add(S);  // busStop ke vis array mn bhi source add kia
        
        // bfs lgao ab
        while(qu.size()>0){
            int size = qu.size();
            while(size-->0){
                int rem = qu.removeFirst();
                
                if(rem== T){       // jo remove kia h vhi target hua toh vhi level ans hoga
                    return level;
                }
                ArrayList<Integer> buses = map.get(rem); // 
                for(int bus : buses){
                    if(busVis.contains(bus)==true){    // dkha agr busVis mn vo bus already h toh continue krdnge
                        continue;
                    }
                    int []arr = routes[bus];      // array bnya remove ki hui ka
                    for(int busstop : arr){
                        if(busStopVis.contains(busstop)==true){
                            continue;
                        }
                        qu.addLast(busstop);
                        busStopVis.add(busstop);
                    }
                    busVis.add(bus);
                }
            }
            level++;
        }
        return -1;
  }
}