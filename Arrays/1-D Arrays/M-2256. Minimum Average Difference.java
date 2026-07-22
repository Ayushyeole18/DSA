class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for(int ele : nums){
            totalSum += ele;
        }
        long sum = 0;
        long minAvg = Integer.MAX_VALUE;
        int idx = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            long leftAvg = sum / (i+1);
            long rightAvg = (i != n-1)? ((totalSum - sum)/(n-i-1)) : 0;
            long avg = Math.abs(leftAvg - rightAvg);
            if(avg < minAvg){
                minAvg = avg;
                idx = i;
            }
        }
        return idx;
    }
}
