class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       Car[] cars = new Car[position.length];
        for(int i=0;i<position.length;i++){
            cars[i] = new Car(position[i],speed[i]);
            
        }
        Arrays.sort(cars);
        
        int groups =0;
        double time =0;
        for(int i= cars.length -1;i>=0;i--){
            Car rem = cars[i];  
            double cTime = (target -rem.pos)*1.0 /rem.speed;  // cTime -> current time 
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
            return this.pos - c.pos;
        }
    }
}