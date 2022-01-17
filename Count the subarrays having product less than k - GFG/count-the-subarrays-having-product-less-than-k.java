// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.countSubArrayProductLessThanK(a, n, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    // final long max = Long.MAX_VALUE;
    // int finalCount = 0;
    // public void solve(long a[], int n, long k, int i, int j){
    //     long pdt = 1;
    //     if(i>=j)
    //         return;
    //     for(int m=i;m<=j;m++){
    //         if(pdt*a[m]>max){
    //             solve(a,n,k,i,j-1);
    //             solve(a,n,k,i+1,j);
    //         }
    //         pdt*=a[m];
    //     }
    //     if(pdt<k){
    //         int x = j-i+1;
    //         System.out.println(i+" "+j);
    //         finalCount+=(x*(x-1)/2);
    //         return;
    //     }
    //     else{
    //       solve(a,n,k,i,j-1);
    //       solve(a,n,k,i+1,j); 
    //     }
    // }
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        int i = 0;
        int j = 0;
        long pdt = 1;
        int count = 0;
        while(i<=j && j<(int)n){
            pdt*=a[j];
            // if(pdt>=k){
                while(i<j && pdt>=k){
                    pdt/=a[i];
                    i++;
                }
                // j++;
                
            // }
            if(pdt<k){
                count+=j-i+1;
                
            }
            j++;
        }
        return count;
    }
}