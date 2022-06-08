// We need to observe that if the string is already a palindrome, we can just select the whole of it and delete it in one go and hence give the result as 1.
// If the string is already empty, that means our initial state is our final goal of the problem statement too. Hence, no deletions are required

// But if none of above conditions satisfy, we can leverage the fact that there are only 2 character types in the given string always and hence, we can select the longest one or all the characters of one type, delete it since any length of one type of characaters is always a palindrome, then select the whole remaining string with the other type, delete it. Giving the result as 2 operations.

class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i) != s.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    public int removePalindromeSub(String s){
        int n = s.length();
        if(n == 0){
            return 0;
        }
        return isPalindrome(s) ? 1: 2;
    }
}