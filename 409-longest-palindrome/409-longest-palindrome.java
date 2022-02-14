class Solution { 
    public int longestPalindrome(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++)
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i),0)+1);
        boolean flag = false;
        int count = 0;
        for(Map.Entry el: m.entrySet()){
            int x = (int)el.getValue();
            if(x%2==0 && x!=1){
                count+=x;
            }
            else{
                if(!flag)
                    count+=x;
                else
                    count+=x-1;
                flag = true;
            }
        }
        return count;
    }
}