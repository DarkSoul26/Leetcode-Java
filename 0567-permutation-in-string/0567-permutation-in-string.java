class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int a[] = new int[26];
        int b[] = new int[26];
        if(s1.length()>s2.length())
            return false;
        for(int i=0;i<s1.length();i++)
            a[s1.charAt(i)-'a']++;
        int i = 0;
        for(i=0;i<s1.length();i++){
            b[s2.charAt(i)-'a']++;
        }
        int j = i;
        i = 0;
        while(j<s2.length()){
            if(Arrays.equals(a,b)){
                return true;
            }
            // System.out.println(a+" "+b);
            b[s2.charAt(i++)-'a']--;
            b[s2.charAt(j++)-'a']++;
        }
        if(Arrays.equals(a,b)){
            return true;
        }
        return false;
    }
}