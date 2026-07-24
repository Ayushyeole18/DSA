
class Solution {
    public boolean isSubset(int a[], int b[]) {
        
        if(b.length > a.length) return false;
        
        HashMap <Integer, Integer> map = new HashMap<>();
        
        for(int ele:a){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        for(int i=0; i<b.length; i++){
            if(!map.containsKey(b[i]) || map.get(b[i]) == 0) return false;
            map.put(b[i], map.get(b[i]) -1);
        }
        return true;
    }
}
