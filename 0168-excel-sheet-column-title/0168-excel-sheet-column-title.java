class Solution {
    public String convertToTitle(int columnNumber) {
        List<Character> al = new ArrayList<>();
        String alpha = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        while(columnNumber!=0){
            int temp = columnNumber%26;
            columnNumber/=26;
            if(alpha.charAt(temp)=='Z')
                columnNumber--;
            al.add(alpha.charAt(temp));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=al.size()-1;i>=0;i--)
            sb.append(al.get(i));
        return sb.toString();
    }
}