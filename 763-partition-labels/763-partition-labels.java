class Solution {
    public List<Integer> partitionLabels(String s) {
        StringBuffer sb1 = new StringBuffer(s);
        sb1.reverse();
        String sb = sb1.toString();
        int i = 0;
        int j = 0;
        int startInd = -1;
        List<Integer> al = new ArrayList<>();
        while(i<=j && i<s.length()){
            startInd = j;
            while(i<=j){
                char c = s.charAt(i);
                int ind = s.length()-sb.indexOf(c)-1;
                // System.out.println(c+" "+ind);
                if(ind>j)
                    j = ind;
                i++;
            }
            al.add(j-startInd+1);
            i = j+1;
            j++;
        }
        return al;
    }
}