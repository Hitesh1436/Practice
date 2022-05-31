class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
       int sum = 0;
        for(int i:arr)
            sum+=i;
        if(sum%3!=0)
            return false;
        int sumOfpartition = sum/3;
        int startIndex = 0;
        int count = 0;
        for(int j=0;j<3;j++){
            int temp = 0;
            for(int i=startIndex;i<arr.length;i++){
                temp+=arr[i];
                if(temp==sumOfpartition){
                    startIndex=i+1;
                    count++;
                    break;
                }
            }
        }
        return count ==3;
    }
}