class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List <Integer> ans = new ArrayList<>();

        int len1 = s.length();
        int len2 = p.length();

        if(len1 < len2) 
        return ans;

        int [] pCount = new int[26];
        int [] window = new int[26];

        for(char ch : p.toCharArray()){
            pCount[ch - 'a']++;
        }

        int left = 0;

        for(int right=0; right<len1; right++){
            window[s.charAt(right) - 'a']++;

            if(right - left + 1 > len2){
                window[s.charAt(left) - 'a']--;
                left++;
            }

            if(Arrays.equals(pCount, window))
            ans.add(left);
        }
        return ans;
    }
}
