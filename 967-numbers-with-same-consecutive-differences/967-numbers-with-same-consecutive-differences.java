class Solution {
    List<String> al = new ArrayList<>();
    public void val(StringBuffer sb, int n, int k){
        if(sb.length()>=n){
            al.add(sb.toString());
            return;
        }
        // al.add(sb.toString());
        for(int i=0;i<=9;i++){
            if(Math.abs((i+'0')-(int)sb.charAt(sb.length()-1)) == k){
                sb.append(i);
                val(sb, n, k);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=9;i++){
            sb.append(i);
            val(sb, n, k);
            sb.delete(sb.length()-1, sb.length());
        }
        // val(new StringBuffer(), n, k);
        int[] ans = new int[al.size()];
        for(int i=0;i<al.size();i++)
            ans[i] = Integer.parseInt(al.get(i));
        
        return ans;
    }
}