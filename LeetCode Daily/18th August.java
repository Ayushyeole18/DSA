import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {
            
            HashSet<Integer> set = new HashSet<>();

            // Create current window
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Count this window only once for each number
            for (int num : set) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;

        // Find largest number appearing in exactly one window
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                ans = Math.max(ans, num);
            }
        }

        return ans;
    }
}
