// time complexity of this question is O(n)
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Character -> Last Seen Index store karne ke liye Map
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int maxLength = 0;
        
        // 'right' pointer poori string par aage badhega
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // 1. Agar character pehle se Map me hai
            if (map.containsKey(currentChar)) {
                // Left pointer ko duplicate character ke AAGLE index par jump karwa do
                // Math.max isiliye taaki left pointer kabhi peeche na chale jaye
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            // 2. Map me current character ka NAYA index update kar do
            map.put(currentChar, right);
            
            // 3. Current window ki length calculate karke record update karo: (right - left + 1)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        // Akhir me sabse badi length return kar do
        return maxLength;
    }
}
