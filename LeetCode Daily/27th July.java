// 1464. Maximum Product of Two Elements in an Array

class Solution {
    public int maxProduct(int[] nums) {
        int first = 0; 
        int second = 0;

        for(int ele : nums){
            int digit = ele;

            if(digit>first){
                second = first;
                first = digit;
            }

            else if(digit>second){
                second = digit;
            }
        }
        return (first-1) * (second-1);
    }
}
