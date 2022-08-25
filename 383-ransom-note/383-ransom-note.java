class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<magazine.length();i++)
            hm.put(magazine.charAt(i), hm.getOrDefault(magazine.charAt(i), 0)+1);
        
        for(int i=0;i<ransomNote.length();i++){
            if(hm.containsKey(ransomNote.charAt(i))){
                if(hm.get(ransomNote.charAt(i)) == 1)
                    hm.remove(ransomNote.charAt(i));
                else
                    hm.put(ransomNote.charAt(i), hm.get(ransomNote.charAt(i))-1);
            }
            else
                return false;
        }
        return true;
    }
}