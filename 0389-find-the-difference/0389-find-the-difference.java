class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length()==0){
            return t.charAt(0);
        }
        char[] a=new char[s.length()];
        char[] b=new char[t.length()];
        for(int i=0;i<t.length();i++){
            if(i!=t.length()-1){
                a[i]=s.charAt(i);
            }
            b[i]=t.charAt(i);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<s.length();i++){
                if(a[i]!=b[i]){
                    return b[i];
                }
        }
        return b[t.length()-1];
    }
}