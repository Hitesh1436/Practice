class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int i=0;
        int j=0;
        int ans=0;
        int smaller=0;
        
        while(i!=A.length){
            if(A[i]>=L && A[i]<=R){
                smaller=i-j+1;
                ans+=smaller;
            }else if(A[i]<L){
                ans+=smaller;
            }else{
                j=i+1;
                smaller=0;
            }
            i++;
        }
        return ans;
    }
}