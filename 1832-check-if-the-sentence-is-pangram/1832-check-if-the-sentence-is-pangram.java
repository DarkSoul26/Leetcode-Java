class Solution {
    public boolean checkIfPangram(String sentence) {
        int a[] = new int[26];
        for(int i=0;i<sentence.length();i++)
            a[sentence.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            if(a[i] == 0)
                return false;
        }
        return true;
    }
}