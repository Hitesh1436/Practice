class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Test Cases
        //1-> if bricks < required and we have used given ladders already
        //2-> if next height is smaller then curr height toh bas jump
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            int diff = heights[i+1] - heights[i];
            
            if(diff>0){
                pq.add(diff);
            }
            if(pq.size()>ladders){
                bricks = bricks - pq.remove();
            }
            if(bricks<0){
                return i;
            }
        }
        return heights.length -1;
    }
}