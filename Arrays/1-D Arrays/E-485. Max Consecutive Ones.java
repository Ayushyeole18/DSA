class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int currentCount = 0;
        int maxCount = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                currentCount += 1;
                maxCount = Math.max(currentCount, maxCount);
            }
            else currentCount = 0;
        }
        return maxCount;
    }
}
