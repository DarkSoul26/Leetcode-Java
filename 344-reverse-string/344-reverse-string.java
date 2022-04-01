class Solution {
    
    public void reverseIt(char[] s, int i){
        if(i==s.length/2)
            return;
        char temp = s[i];
        s[i] = s[s.length-i-1];
        s[s.length-i-1] = temp;
        reverseIt(s,i+1);
    }
    public void reverseString(char[] s) {
        reverseIt(s,0);
    }
}