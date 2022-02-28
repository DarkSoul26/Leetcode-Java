class Solution {

    Random r = new Random();
    int[] arr;
    int[] original;
    public Solution(int[] nums) {
        arr = nums.clone();
        original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        arr = original.clone();
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=arr.length-1;i>=0;i--)
        {
            int random = r.nextInt(i+1); // (i+1) bcs it is till upperboound-1 hence the bound needs to be from 0-i 
            int temp = arr[i];
            arr[i] = arr[random];
            arr[random] = temp;
        }
        return arr;
    }
}