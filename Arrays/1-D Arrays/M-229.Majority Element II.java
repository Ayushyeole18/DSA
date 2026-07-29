class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int ele:nums){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(int key:map.keySet()){
            if(map.get(key) > n/3)
            ans.add(key);
        }
        return ans;
    }
}
