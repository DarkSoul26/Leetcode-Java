class Solution {
    public String minimizeResult(String str) {
        
        int n=str.length();
        int idx=0;
        while(idx<n && str.charAt(idx)!='+') idx++;
        idx++;
        int ans=1000000000;
        String res="";
        for(int i=0;i<idx-1;i++){
            for(int j=idx;j<n;j++){
                StringBuilder sb=new StringBuilder(str);
                sb.insert(j+1,')');
                sb.insert(i,'(');
                
                int a=0,b=0,c=0,d=0,k=0;
                for(;sb.charAt(k)!='(';k++){
                    a=a*10+(sb.charAt(k)-'0');
                }
                k++;
                for(;sb.charAt(k)!='+';k++){
                    b=b*10+(sb.charAt(k)-'0');
                }
                k++;
                for(;sb.charAt(k)!=')';k++){
                    c=c*10+(sb.charAt(k)-'0');
                }
                k++;
                for(;k<sb.length();k++){
                    d=d*10+(sb.charAt(k)-'0');
                }
                b=b+c;
                if(a==0) a=1;
                if(d==0) d=1;
                
                int abc=a*b*d;
                if(abc<ans){
                    res=sb.toString();
                    ans=abc;
                }
            }
        }
        return res;
    }
}