class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
        return 0; 

        int currmax = nums[0]; 
        int maxsofar = nums[0];

        for (int i=1; i<nums.length; i++){
            currmax = Math.max(nums[i], currmax + nums[i]);
            maxsofar = Math.max(maxsofar, currmax);
        }
        return maxsofar;
        
    }
}
