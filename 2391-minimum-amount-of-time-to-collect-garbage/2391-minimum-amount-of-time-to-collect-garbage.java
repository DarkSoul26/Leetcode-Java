class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int flag1 = -1, flag2 = -1, flag3 = -1, flag4 = -1, flag5 = -1, flag6 = -1;
        for(int i=0;i<garbage.length;i++){
            int m = 0, g = 0, p = 0;
            for(int j=0;j<garbage[i].length();j++){
                char a = garbage[i].charAt(j);
                if(a == 'M')
                    m++;
                else if(a == 'P')
                    p++;
                else
                    g++;
            }
            // if(flag1 == -1 && m>0)
            //     flag1 = i;
            // if(flag2 == -1 && p>0)
            //     flag2 = i;
            // if(flag3 == -1 && g>0)
            //     flag3 = i;
            if(m>0)
                flag4 = i;
            if(p>0)
                flag5 = i;
            if(g>0)
                flag6 = i;
            ans+=m+g+p;
            // ans+=(i == garbage.length-1?0:travel[i]);
        }
        // System.out.println(flag4+" "+flag5+" "+flag6);
        for(int i=0;i<travel.length;i++){
            if(flag4 != -1 && flag4>i)
                ans+=travel[i];
            if(flag5 != -1 && flag5>i)
                ans+=travel[i];
            if(flag6 != -1 && flag6>i)
                ans+=travel[i];
            
        }
        // ans+=m+g+p;
        return ans;
    }
}