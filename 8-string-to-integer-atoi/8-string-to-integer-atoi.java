// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string is null");
        }
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int idx = 0;
        // Ignoring the leading whitespace
        while (idx < len && s.charAt(idx) == ' ') {
            idx++;
        }
        if (idx == len) {
            return 0;
        }
        // Checking for sign
        int sign = 1;
        char c = s.charAt(idx);
        if (c == '-' || c == '+') {
            if (c == '-') {
                sign = -1;
            }
            idx++;
        }
        int result = 0;
        while (idx < len && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10
                    // Here Checking for sign is not required as for Int.MIN last digit is 8 which
                    // is greater than 7.
                    && digit > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            idx++;
        }
        return sign * result;
    }
}