class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int recAns = fib(n-1) + fib(n-2);
        int myAns = recAns;
        return recAns;
    }
}