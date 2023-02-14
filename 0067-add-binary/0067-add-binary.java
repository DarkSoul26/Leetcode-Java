class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int len1 = a.length();
        int len2 = b.length();
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        int temp = len1, temp1 = len2;
        String c = b;
        if(len1>len2){
          temp = len2;
          temp1 = len1;
          c = a;
        }
        int i = 0;
        for(i=0;i<temp;i++){
          if(a.charAt(i)=='1' && b.charAt(i)=='1'){
            if(carry){
              sb.append('1');
            }
            else{
              sb.append('0');
              carry = true;
            }
          }
          else if(a.charAt(i)=='1'){
            if(carry){
              sb.append('0');
              // carry = false;
            }
            else{
              sb.append('1');
              // carry = true;
            }
          }
          else if(b.charAt(i)=='1'){
            if(carry){
              sb.append('0');
              // carry = false;
            }
            else{
              sb.append('1');
              // carry = true;
            }
          }
          else{
            if(carry){
              sb.append('1');
              carry = false;
            }
            else
              sb.append('0');
          }
        }
        for(int j=i;j<temp1;j++){
          if(carry){
            if(c.charAt(j)=='1'){
              sb.append('0');
            }
            else{
              sb.append('1');
              carry = false;
            }
          }
          else
            sb.append(c.charAt(j));
        }
        if(carry)
          sb.append('1');
        return sb.reverse().toString();
    }
}