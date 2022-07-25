// T = O(s + n) | S = O(s + n)
    // where s is the size of the string and n is the sizeof the array.
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int firstPipeIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '|') {
                firstPipeIndex = i;
                break;
            }
        }
        int[] leftPlates = new int[s.length()];

        int platesCount = 0;
        for (int i = firstPipeIndex + 1; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                ++platesCount;
            } else {
                leftPlates[i] = platesCount;
                for (int j = i - 1; s.charAt(j) != '|'; --j) {
                    leftPlates[j] = platesCount;
                }
            }
        }
        for (int j = s.length() - 1; j >= 0 && s.charAt(j) != '|'; --j) {
            leftPlates[j] = platesCount;
        }
        int[] rightPlates = new int[s.length()];
        platesCount = 0;
        int currentPlatesCount = 0;
        for (int i = firstPipeIndex + 1; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                ++currentPlatesCount;
            } else {
                platesCount += currentPlatesCount;
                currentPlatesCount = 0;
            }
            rightPlates[i] = platesCount;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            result[i] = Math.max(0, rightPlates[queries[i][1]] - leftPlates[queries[i][0]]);
        }
        return result;
    }
}