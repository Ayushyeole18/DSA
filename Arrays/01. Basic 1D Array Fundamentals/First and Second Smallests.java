import java.util.*;

class Solution {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        Arrays.sort(arr);

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(arr[0]); 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[0]) {
                ans.add(arr[i]); 
                return ans;
            }
        }
        ans.clear();
        ans.add(-1);

        return ans;
    }
}
