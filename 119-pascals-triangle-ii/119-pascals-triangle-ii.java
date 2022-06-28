class Solution {
    public List<Integer> getRow(int n) {
        Integer []arr = new Integer[n+1];
        Arrays.fill(arr,0);
        arr[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=i;j>0;j--){
                arr[j] = arr[j] + arr[j-1];
            }
        }
        return Arrays.asList(arr);
    }
}