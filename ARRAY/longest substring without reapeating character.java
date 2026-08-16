import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxlen = 0; // -1 nahi, 0 se shuru karo

        while (j < n) {
            Character ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Case 1: Saare characters unique hain
            if (map.size() == (j - i + 1)) {
                maxlen = Math.max(maxlen, j - i + 1);
                j++;
            } 
            // Case 2: Duplicate aa gaya (map size chota ho gaya window size se)
            else if (map.size() < (j - i + 1)) {
                while (map.size() < (j - i + 1)) {
                    Character leftchar = s.charAt(i);
                    map.put(leftchar, map.get(leftchar) - 1);
                    
                    if (map.get(leftchar) == 0) {
                        map.remove(leftchar);
                    }
                    i++; // i++ ko hamesha IF ke baad aakhiri me badhana hai
                }
                j++;
            }
        }

        return maxlen;
    }
}
