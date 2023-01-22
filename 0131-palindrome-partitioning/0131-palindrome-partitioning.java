class Solution {
    public boolean findPali(String s){
        int len = s.length();
        for(int i=0,j=len-1;(i<=len/2 && j>=len/2);i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
    List<List<String>> alFinal = new ArrayList<>();
    public void partPali(String s, int i, int j, List<String> al){
        if(j>=s.length()+1){
            alFinal.add(new ArrayList<>(al));
            return;
        }
        while(j<s.length()+1){
            boolean temp = findPali(s.substring(i,j));
            if(temp){
                al.add(s.substring(i,j));
                
                partPali(s,j,j+1,al);
                al.remove(al.size()-1);
            }
            j++;
        }
    }
    public List<List<String>> partition(String s) {
        List<String> al = new ArrayList<>();
        partPali(s,0,1,al);
        return alFinal;
    }
}