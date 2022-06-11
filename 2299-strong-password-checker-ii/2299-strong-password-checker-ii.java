class Solution {
    public boolean strongPasswordCheckerII(String pass) {
        boolean up = false, lo = false, di = false, sp = false;
        if(pass.length()<8)
            return false;
        String low = "abcdefghijklmnopqstruvwxyz";
        String upp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String spe = "!@#$%^&*()-+";
        String digi = "0123456789";
        char t = 'a';
        for(int i=0;i<pass.length();i++){
            char a = pass.charAt(i);
            if(low.indexOf(a) != -1)
                lo = true;
            else if(upp.indexOf(a) != -1)
                up = true;
            else if(spe.indexOf(a)!=-1)
                sp = true;
            else if(digi.indexOf(a)!=-1)
                di = true;
            if(i !=0 && a == t)
                return false;
            t = a;
        }
        
        if(lo && up && sp && di)
            return true;
        return false;
    }
}