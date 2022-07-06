class Solution {
    public String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
    public int kSimilarity(String s1, String s2){
        String ans = s1;
        LinkedList<String> q = new LinkedList<>();
        
        q.addFirst(s2);
        int level = -1;
        while(q.size()>0){
            level++;
            int size = q.size();
            while(size-->0){
                String rem = q.removeFirst();
                if(rem.equals(ans)){
                    return level;
                }
                int pos1=-1;
                int pos2=-1;
                
                for(int i=0;i<rem.length();i++){
                    if(rem.charAt(i)!=ans.charAt(i)){
                        pos1=i;
                        break;
                    }  
                }
            for(int j=pos1+1;j<rem.length();j++){
               if(rem.charAt(j)==ans.charAt(pos1) && rem.charAt(j)!=ans.charAt(j)){          
                pos2 = j;
                  String temp = swap(rem,pos1,j);
                 q.addLast(temp); 
                    }         
                             
                 }       
            }  
        }
        return -1;    
    }
}