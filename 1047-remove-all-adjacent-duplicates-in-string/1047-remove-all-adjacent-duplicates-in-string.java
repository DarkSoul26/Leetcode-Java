class Solution {
    public String removeDuplicates(String s) {
        List<Character> al = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            al.add(s.charAt(i));
        }
        for(int i=0;i<al.size()-1;i++){
            if(al.get(i)==al.get(i+1)){
                al.remove(i+1);
                al.remove(i);
                //System.out.print(i);
                if(i>=1)
                    i-=2;
            }
        }
        for(int i=0;i<al.size()-1;i++){
            if(al.get(i)==al.get(i+1)){
                al.remove(i+1);
                al.remove(i);
                //System.out.print(i);
                if(i>=1)
                    i-=2;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char a : al)
        {
            sb.append(Character.toString(a));
            //sb.append("\t");
        }
        return sb.toString();
    }
}