class Solution 
{
    public boolean isPowerOfThree(int n) 
    {
        if(n < 0) return false;                         // -ve number
        if(n == 0) return false;                        // == 0 
        if(n == 1) return true;                         // == 1
            
        while(n > 1||n < 0) //except n=1(odd=true), but others satisfy -> n=16 -> even(yes=true), n=3 -> odd(no=false)
        {
            if(n % 3 != 0)          
                return false;
            n = n / 3;              // o(logn - dividing),o(1)
        }
        return true;
        //isPowerOfTwo(n, x+1);
    }
}