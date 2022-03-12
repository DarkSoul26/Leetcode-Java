// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
// import java.util.*;
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int cap, Item val[], int n) 
    {
        // Your code here
      Arrays.sort(val, new Comparator<Item>(){
        public int compare(Item a, Item b){
          Double t1 = (double)b.value/(double)b.weight;
          Double t2 = (double)a.value/(double)a.weight;
          return t1.compareTo(t2);
        }
      });
      
      double cap1 = cap;
      double ans=0;
      int i = 0;
      while(cap1!=0 && i<val.length){
        if(val[i].weight>cap1){
        //   System.out.println((cap1/val[i].weight)*val[i].value);
          ans+=(cap1/(double)val[i].weight)*(double)val[i].value;
          cap1 = 0;
          break;
        }
        else{
        //   System.out.println(ans);
          ans+=(double)val[i].value;
          cap1-=(double)val[i].weight;
        }
        i++;
      }
      return ans;
    }
}