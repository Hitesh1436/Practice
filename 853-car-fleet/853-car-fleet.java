class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        for(int i=0;i<position.length;i++){
            Car c = new Car(position[i],speed[i]);
            pq.add(c);
        }
        int groups =0;
        double time =0;
        while(pq.size()>0){
            Car rem = pq.remove();  // cTime -> current time 
            double cTime = (target -rem.pos)*1.0 /rem.speed;
            if(cTime > time){
                time = cTime;
                groups++;
            }
        }
        return groups;
    }
    class Car implements Comparable<Car>{
        int pos;
        int speed;
        Car(int pos,int speed){
            this.pos = pos;
            this.speed = speed;
        }
        public int compareTo(Car c){
            return c.pos - this.pos;
        }
    }
}