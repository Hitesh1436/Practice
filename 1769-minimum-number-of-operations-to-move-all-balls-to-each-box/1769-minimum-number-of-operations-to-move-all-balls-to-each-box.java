class Solution {
    public int[] minOperations(String boxes) {
        if(boxes == null || boxes.length()==0) return new int[]{};
        int n = boxes.length();
        
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];
        
        // Left to Right
        int balls = boxes.charAt(0) == '1' ? 1 : 0;
        for(int i=1;i<n;i++) {
            left[i] = left[i-1] + 1 * balls;
            balls += boxes.charAt(i) == '1' ? 1 : 0;
        }
        
        // Right to Left
        balls = boxes.charAt(n-1) == '1' ? 1 : 0;
        for(int i=n-2;i>=0;i--) {
            right[i] = right[i+1] + 1 * balls;
            balls += boxes.charAt(i) == '1' ? 1 : 0;
        }
        
        for(int i=0;i<n;i++) {
            result[i] = left[i] + right[i];
        }
        return result;
    }
}
