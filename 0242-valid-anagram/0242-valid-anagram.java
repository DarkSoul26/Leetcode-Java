class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        String s1=Arrays.toString(a);
        String s2=Arrays.toString(b);
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}