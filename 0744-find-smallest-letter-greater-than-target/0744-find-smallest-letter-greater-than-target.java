class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length-1;
        while(l<=r){
            int m = (r+l)/2;
            if(letters[m]==target){
                if(m>=letters.length-1)
                    return letters[0];
                if(letters[m+1]==letters[m]){
                    l = m+1;
                    continue;
                }
                return letters[m+1];
            }
            else if(letters[m]>target){
                if(m==0)
                    return letters[m];
                r = m-1;
            }
            else{
                if(m!=letters.length-1 && letters[m+1]>target)
                    return letters[m+1];
                if(m>=letters.length-1)
                    return letters[0];
                l = m+1;
            }
        }
        return 'a';
    }
}