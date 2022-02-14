class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        
        sb1.reverse();
        sb2.reverse();
        // char[] a = num1.toCharArray();
        // char[] b = num2.toCharArray();
        boolean carry = false;
        StringBuilder sb3 = new StringBuilder();
        int len = Math.max(num1.length(), num2.length());
        for(int i=0;i<len;i++){
            if(i>sb1.length()-1){
                if(carry){
                    int x = Integer.parseInt(sb2.substring(i,i+1))+1;
                    if(x>9)
                        sb3.append(0);
                    else{
                        sb3.append(x);
                        carry = false;
                    }
                }
                else{
                    int x = Integer.parseInt(sb2.substring(i,i+1));
                    if(x>9){
                        sb3.append(0);
                        carry = true;
                    }
                    else{
                        sb3.append(x);
                        carry = false;
                    }
                }
            }
            else if(i>sb2.length()-1){
                if(carry){
                    int x = Integer.parseInt(sb1.substring(i,i+1))+1;
                    if(x>9)
                        sb3.append(0);
                    else{
                        sb3.append(x);
                        carry = false;
                    }
                }
                else{
                    int x = Integer.parseInt(sb1.substring(i,i+1));
                    if(x>9){
                        sb3.append(0);
                        carry = true;
                    }
                    else{
                        sb3.append(x);
                        carry = false;
                    }
                }
            }
            else{
                int x = Integer.parseInt(sb1.substring(i,i+1))+Integer.parseInt(sb2.substring(i,i+1));
                if(carry){
                    x+=1;
                    if(x>9){
                        sb3.append(x%10);
                    }
                    else{
                        carry = false;
                        sb3.append(x);
                    }
                }
                else{
                    if(x>9){
                        carry = true;
                        sb3.append(x%10);
                    }
                    else{
                        carry = false;
                        sb3.append(x);
                    }
                }
            }
        }
        if(carry)
            sb3.append("1");
        sb3.reverse();
        return sb3.toString();
    }
}