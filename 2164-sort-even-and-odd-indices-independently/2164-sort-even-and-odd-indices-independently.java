class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0 && i!=1)
                al1.add(nums[i]);
            else
                al2.add(nums[i]);
        }
        Collections.sort(al1);
        Collections.sort(al2, Collections.reverseOrder());
        int j = 0, k = 0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0 && i!=1)
                nums[i] = al1.get(j++);
            else
                nums[i] = al2.get(k++);
        }
        return nums;
    }
}