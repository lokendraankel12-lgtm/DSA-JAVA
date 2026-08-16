// most optimize way by using sliding window pattern o(n)
import java.util.HashMap;

class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxlength = -1;

        while (j < n) {
            // 1. Current character (j) ko map me daalo
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // CASE 1: Agar unique characters K se kam hain
            if (map.size() < k) {
                j++; // Bas window expand karo
            }
            
            // CASE 2: Agar unique characters exact K hain
            else if (map.size() == k) {
                maxlength = Math.max(maxlength, j - i + 1); // Answer update karo
                j++; // Aur aage check karne ke liye window expand karo
            }
            
            // CASE 3: Agar unique characters K se zyada ho gaye
            else if (map.size() > k) {
                // Jab tak size K se zyada hai, left se elements nikaalte raho (i++)
                while (map.size() > k) {
                    char leftChar = s.charAt(i);
                    map.put(leftChar, map.get(leftChar) - 1);
                    
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                    i++; 
                }
                
                // Shrink hone ke turant baad agar window wapas valid (k) ho jaye, 
                // to answer yahan bhi update karna zaroori hai.
                if (map.size() == k) {
                    maxlength = Math.max(maxlength, j - i + 1);
                }
                
                j++; // Shrink ka kaam khatam, ab aage badho
            }
        }

        return maxlength;
    }
}
