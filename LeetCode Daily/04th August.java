class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int low = nums[0];
        int high = nums[0];
        
        for(int ele:nums){
            if(ele<low) low = ele;
            if(ele>high) high = ele;
        }

        HashSet <Integer> set = new HashSet<>();
        List <Integer> ans = new ArrayList<>();

        for(int ele:nums){
            set.add(ele);
        }

        for(int i=low; i<=high; i++){
            if(!set.contains(i)) 
            ans.add(i);
        }
        return ans;
    }
}
