class Solution {
    int bit[];
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length, min=nums[0], max=nums[0];
        for(int x: nums){
            min=Math.min(min, x);
            max=Math.max(max, x);
        }
        min=(min<0?min:0);
        int net=max-min+5;
        bit=new int[net];
        Integer arr[]=new Integer[n];
        for(int i=n-1;i>=0;i--)
        {
            nums[i]-=min;
            arr[i]=(Integer)get(nums[i]-1);
            update(nums[i], net);
        }
        return Arrays.asList(arr);
    }
    public int get(int x){
        int sum=0;
        for(++x; x>0; x-=(x&(-x)))
            sum+=bit[x];
        return sum;
    }
    public void update(int x, int n){
        for(++x; x<n;x+=(x&(-x)))
            bit[x]+=1;
    }
}