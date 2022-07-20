class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0, right = plants.length - 1;
        int alice = capacityA, bob = capacityB, refills = 0;
        while(left <= right){
            if(left == right){
                if(plants[left] > Math.max(alice, bob)){ //check if we need one last refill
                    refills++;
                }
                break; //end simulation since we are on last element
            }
            if(alice < plants[left]){
                refills++;
                alice = capacityA;
            }

            if(bob < plants[right]){
                refills++;
                bob = capacityB;
            }
            alice -= plants[left++];
            bob -= plants[right--];
        }
        return refills;
    }
}