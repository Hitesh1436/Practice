//  split method in java returns array of strings** 
class Solution {
   public int mostWordsFound(String[] sentences) {

    int max = 0;
	
    for(String s : sentences){
        int count =1;
		
        for(int i = 0; i<s.length(); i++){
		
            if(s.charAt(i)==' '){
                count++;
            } 
			
        }
        if(max<count){
        max = count;
        }
    }
    return max;

    }
}