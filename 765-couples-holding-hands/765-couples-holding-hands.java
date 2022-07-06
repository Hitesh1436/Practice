class Solution {
    public int minSwapsCouples(int[] row) {
        int swaps = 0;
        
        for(int i=0;i<row.length-1;i++) {
            int pair = (row[i]%2 == 0)? row[i]+1: row[i]-1; // get the number's pair, if n is even, its partner is n+1, else its partner is n-1
            
            if(row[i+1] == pair)  i++;// continue if the number is already with its pair 
            
            else for(int j=i+1;j<row.length;j++) // else find its pair and swap it
                if(row[j] == pair) {
                    int temp = row[i+1];
                    row[i+1] = row[j];
                    row[j] = temp;
                    swaps++; // record the number of swaps
                    break;
                    }
        }
        return swaps; // and finally return the number of swaps :)
    }
}