class Solution {
    public List<String> finalAns;
    public void findAllPossible(int n, int j, StringBuffer sb){
      if(sb.length()==10 && j==n){
        // System.out.println(sb);
        String s1 = sb.toString().substring(0,4);
        String s2 = sb.toString().substring(4,10);
        int hrs = Integer.parseInt(s1, 2);
        int min = Integer.parseInt(s2, 2);
        StringBuffer sbNew  = new StringBuffer();
        if(min>=60){
            return;
        }
        if(hrs>11)
            return;   
        sbNew.append(hrs);
        sbNew.append(":");
        // System.out.print(hrs+":");
        if(min/10==0){
            sbNew.append("0");
            sbNew.append(min);
        }
        else    
            sbNew.append(min);
        finalAns.add(sbNew.toString());
        return;
      }
      if(sb.length()>=10 || j>n)
        return;
      sb.append("0");
      findAllPossible(n, j,sb);
      sb.delete(sb.length()-1, sb.length());
      sb.append("1");
      findAllPossible(n, j+1,sb);
      sb.delete(sb.length()-1, sb.length());
    }
    public List<String> readBinaryWatch(int turnedOn) {
        finalAns = new ArrayList<>();
        findAllPossible(turnedOn, 0, new StringBuffer());
        return finalAns;
    }
}