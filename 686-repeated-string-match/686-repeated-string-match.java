/*
n: length of a, m: length of b , k = n / m ~= constant 
TC: O(nm * k) ~= O(nm), each iteration StringBuilder content size will grow at most n size but it will repeat constant times. 
Then we can asuume time complexity will be O(nm)
SC: O(kn) ~= O(n)
*/
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= b.length() / a.length() + 2; i++) //starting 1 and ending with maximum 2 repeations is enough 
            if(sb.append(a).toString().contains(b))
                return i;
        return -1;
    }
}