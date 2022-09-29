class Solution {
    public int minSteps(String s, String t) {
        int alpha1[] = new int[26];
        int alpha2[] = new int[26];
        for(int i=0;i<s.length();i++)
            alpha1[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++)
            alpha2[t.charAt(i)-'a']++;
        int count = 0;
        for(int i=0;i<26;i++)
            count+=Math.abs(alpha1[i]-alpha2[i]);
        return count/2;
    }
}