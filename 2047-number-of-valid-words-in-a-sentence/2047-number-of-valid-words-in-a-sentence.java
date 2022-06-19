class Solution {
    public static int countValidWords(String sentence) {
        String[] arr = sentence.trim().split("\s+");
        int valid = 0;
        outer: for(int j=0;j<arr.length;j++)
        {
        String str = arr[j];
        if(str.startsWith("-") || str.endsWith("-") ||
        (str.contains("!") && !str.endsWith("!")) ||
        (str.contains(".") && !str.endsWith(".")) ||
        (str.contains(",") && !str.endsWith(","))
        )
        {
        continue;
        }
        char[] cArr = str.toCharArray();
        boolean hyphenFound = false;
        boolean pFound = false;

        for(int i=0;i<cArr.length;i++)
        {
            char c = cArr[i];
            if(Character.isDigit(c))
            {
                continue outer;
            }
            else if(c=='-')
            {
                if(hyphenFound)
                {
                    continue outer;
                }
                else
                {   
                    if (cArr[i+1] < 'a' || cArr[i+1] >'z')
                    {
                        continue outer;
                    }
                    if (i+1<cArr.length && (cArr[i+1]< 'a' || cArr[i+1]>'z'))
                    {
                        continue outer;
                    }
                    hyphenFound=true;
                }
            }
            else if(c=='!' || c==',' || c=='.')
            {
                if(pFound)
                {
                    continue outer;
                }
                pFound=true;
            }
        }
        valid++;
    }
    return valid;
}
}