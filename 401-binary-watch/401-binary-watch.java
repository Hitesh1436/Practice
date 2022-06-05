class Solution {
    public List<String> readBinaryWatch(int n) {
        if(n<0 || n>10){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        for(int hr=0;hr<=11;hr++){
            for(int mnt =0;mnt<=59;mnt++){
                // If number of bits in hour + number of bits in minute equals num
				// add to result or else do nothing.
                if(Integer.bitCount(hr) + Integer.bitCount(mnt)== n){
                    ans.add(String.format("%d:%02d",hr,mnt));
                }
            }
        }
        return ans;
    }
}