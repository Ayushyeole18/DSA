//1979. Find Greatest Common Divisor of Array

class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[nums.length - 1];

        while (max % min != 0) {
            int rem = max % min;
            max = min;
            min = rem;
        }

        return min;
    }
}
