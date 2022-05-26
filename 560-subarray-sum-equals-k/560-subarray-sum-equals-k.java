class Solution {
    int count =0;
    int preSum=0;
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int i=0;i<n;i++){
            preSum += arr[i];
            if(map.containsKey(preSum -k)){
                count += map.get(preSum - k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }   
}