class Solution {
    int ans;
    public int countVowelStrings(int n) {
       // char[] ch ={'a','e','i','o','u'};
        ans=0;
        count(0,n);
        return ans;
    }
    void count(int src,int n){
        if(n==0){ans++;return;}
        for(int i=src;i<5;i++){
            count(i,n-1);
        }
    }
}