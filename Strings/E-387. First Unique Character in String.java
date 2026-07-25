//Approach 1:

class Solution {
    public int firstUniqChar(String s) {
        int [] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1)
            return i;
        }
        return -1;
    }
}


//Approach 2:

class Solution {
    public int firstUniqChar(String s) {
        HashMap <Character, Integer> map = new HashMap<>();

        char [] arr = s.toCharArray();

        for(char ele : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        for(int i=0; i< arr.length; i++){
            if(map.get(arr[i]) == 1){
                return i;   
            }
        }
        return -1;
    }
}
