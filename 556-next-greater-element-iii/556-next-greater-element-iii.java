class Solution {
    public int nextGreaterElement(int n) {
        
        int[] freq = new int[10];
        
        long temp = n;
        int prev = 0;
        while(prev <= temp%10){
            prev = (int) temp%10;
            freq[prev]++;
            temp = temp/10;
        }
        if(temp == 0 ){
            return -1;
        }
        int toReplace = (int) temp%10;
        temp = temp/10;
        freq[toReplace]++;
        
        for(int i=toReplace+1; i<10; i++){
            if(freq[i]>0){
                temp = temp*10 + i;
                freq[i]--;
                break;
            }
        }
        for(int i=0;i<freq.length; i++){
            while(freq[i]>0){
                temp = temp*10 + i;
                freq[i]--;
            }
        }
        
        if(temp>Integer.MAX_VALUE){
            return -1;
        }
        return (int)temp;
    }
}