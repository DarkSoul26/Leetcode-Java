class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n + 1]; 
        
        for(int i = 0; i <= n; i++){ 
            res[i] = solve(i, res);
        }
        return res;

    }
    public int solve(int n, int arr[]){

        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(arr[n] != 0) return arr[n];
        if(n % 2 == 0) {
            arr[n] = solve(n / 2, arr);
            return solve(n / 2, arr);
        }
        else {
            arr[n] = 1 + solve(n / 2, arr);
            return 1 + solve(n / 2, arr);
        } 
    }
}