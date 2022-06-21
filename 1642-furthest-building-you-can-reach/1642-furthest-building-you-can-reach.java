class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Test Cases
        //1-> if bricks < required and we have used given ladders already
        //2-> if next height is smaller then curr height toh bas jump
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            int diff = heights[i+1] - heights[i];
            
            if(diff>0){
                pq.add(diff);  // add krdia diff pq mn
            }
            if(pq.size()>ladders){
                bricks = bricks - pq.remove();  // agr ladders km h toh pq se remove kia nd bricks ka use kiaa uss height ko climb krne ke liye
            }
            if(bricks<0){  // agr bricks bhi khtm hogyi and ladders bhi already khtm thi toh uss index tk hi phuch skte the hum
                return i;
            }
        }
        return heights.length -1;
    }
}