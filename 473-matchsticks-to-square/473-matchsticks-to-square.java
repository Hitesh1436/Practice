class Solution {
    public boolean makesquare(int[] stick) {
        int total =0;
        for(int num : stick){
            total +=num;
        }
        if(total %4 !=0) return false;
        Arrays.sort(stick);
        return dfs(stick,new int[4],stick.length-1,total/4);
    }
    boolean dfs(int []stick,int []sums,int idx,int tar){
        if(idx == -1) return true;
       for(int i=0;i<4;i++){
            if((sums[i]+stick[idx]>tar) || (i>0 && sums[i]==sums[i-1])) continue;
            sums[i]+=stick[idx];
            if(dfs(stick,sums,idx-1,tar)) return true;
            sums[i]-=stick[idx];
        }
        return false;
    }
}