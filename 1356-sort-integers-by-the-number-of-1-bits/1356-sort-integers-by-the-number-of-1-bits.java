class Solution {
    public int[] sortByBits(int[] arr) {
        var nums = Arrays.stream(arr)
                         .boxed()
                         .toArray(Integer[]::new);

        Arrays.sort(nums, Comparator.comparingInt(Integer::bitCount)
                                    .thenComparingInt(n -> n));

        return Arrays.stream(nums)
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}