class Solution {
    public String multiply(String num1, String num2) {
        int a[] = new int[num1.length()+num2.length()];
        StringBuffer sb1 = new StringBuffer(num1);
        sb1.reverse();
        StringBuffer sb2 = new StringBuffer(num2);
        sb2.reverse();
        
        for(int i = 0;i<num1.length();i++){
            int k = i, carry = 0;
            for(int j=0;j<num2.length();j++){
                int x = Integer.parseInt(sb1.substring(i,i+1))*Integer.parseInt(sb2.substring(j,j+1));
                x+=carry+a[k];
                carry = 0;
                if(x>9){
                   carry = x/10; 
                }
                a[k++] = x%10;
            }
            a[k++]+=carry;
        }
        
        String ans = Arrays.toString(a);
        sb1 = new StringBuffer();
        boolean flag = false;
        for(int i = a.length-1;i>=0;i--){
            if(a[i] == 0 && !flag)
                continue;
            if(a[i]!=0)
                flag = true;
            sb1.append(a[i]);
        }
        if(sb1.length()==0)
            return "0";
        return sb1.toString();
    }
}