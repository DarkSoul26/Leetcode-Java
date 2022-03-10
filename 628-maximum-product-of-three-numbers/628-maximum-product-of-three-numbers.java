class Solution {

        public int maximumProduct (int[] nums) {

        int n1 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE, n3 = Integer.MIN_VALUE, n4 = Integer.MAX_VALUE, n5 = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {

            if(nums[i]>n1){
                n3 = n2;
                n2 = n1;
                n1 = nums[i];
            }
            else if(nums[i]>n2){
                n3 = n2;
                n2 = nums[i];
            }
            else if(nums[i]>n3)
                n3 = nums[i];
            if(nums[i]<n5){

                n4 = n5;

                n5 = nums[i];

            }
            else if(nums[i]<n4)
                n4 = nums[i];

        }

        System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5); 
//         if(n2 == n3 && n2 == Integer.MIN_VALUE){

//             return n1*n4*n5;

//         }

//         else if(n4 == Integer.MAX_VALUE)
//             return n1*n2*n3;

        return Math.max(n1*n2*n3, n1*n4*n5);
        }
}