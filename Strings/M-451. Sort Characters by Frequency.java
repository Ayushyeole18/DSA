class Solution {
    public String frequencySort(String s) {

        int[] freq = new int[128];

        
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        StringBuilder ans = new StringBuilder();

        
        while (true) {
            int max = 0;

            for (int i = 0; i < 128; i++) {
                if (freq[i] > freq[max]) {
                    max = i;
                }
            }

            if (freq[max] == 0)
                break;

            while (freq[max] > 0) {
                ans.append((char) max);
                freq[max]--;
            }
        }

        return ans.toString();
    }
}
