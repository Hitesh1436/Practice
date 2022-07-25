//TC: O(n + q logn) | SC: O(n)
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] answer = new int[queries.length];
        int strLen = s.length();
        
        TreeSet<Integer> candles = new TreeSet<>();
        int[] left = new int[strLen];
        
        int leftPlateCount = 0;
        for(int i=0; i < s.length(); i++){
            if (s.charAt(i) == '|') {
                candles.add(i);
                left[i] = leftPlateCount;
            } else {
                leftPlateCount++;
            }
        }
        
        int i=0;
        for(int query[] : queries){
            Integer leftMostCandle = candles.ceiling(query[0]);
            Integer rightMostCandle = candles.floor(query[1]);
            if(leftMostCandle != null && rightMostCandle != null && leftMostCandle < rightMostCandle)
                answer[i] = left[rightMostCandle] - left[leftMostCandle];
            
            i++;
        }
        return answer;
    }
}