class Solution {
    public int numRescueBoats(int[] people, int limit){
        Arrays.sort(people);
        int li = 0;
        int ri = people.length -1;
        int boats =0;
        
        while(li<=ri){
            boats++;
            if(people[li]+people[ri]<= limit){
                li++;
            }
            ri--;
        }
        return boats;
    }
}