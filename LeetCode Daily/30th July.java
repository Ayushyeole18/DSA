class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        int pushes = 1;

        while (n > 8) {
            ans += 8 * pushes;
            n -= 8;
            pushes++;
        }

        ans += n * pushes;
        return ans;
    }
}
