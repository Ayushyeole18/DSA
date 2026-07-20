// APPROACH 1: Not Optimal

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(nums[j] == 0){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}

// APPROACH 2: Optimal Solution

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;

        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        while(index<n){
            nums[index] = 0;
            index++;
        }

    }
}
