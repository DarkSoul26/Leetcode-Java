class Solution {
    public int ans = 0;
    public List<Integer> arr;
    public void count(int s, int t, int steps){
        if(s == t){
            ans = Math.min(steps, ans);
            return;
        }
        if(!arr.contains(s)){
            arr.add(s);
            if(s<t)
                count(s*2, t, steps+1);
            count(s-1, t, steps+1);
        }
        // arr.add(s);
    }
    public int brokenCalc(int X, int Y) {
        // arr = new ArrayList<>();
        // count(startValue, target, 0);
        // return ans;
        int res = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        return res + X - Y;
    }
}