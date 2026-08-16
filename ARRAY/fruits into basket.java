//most optimize way to solve this question by using sliding window pattern ek or question hi he iske jesa vo he longest substring with k distinct mtlb k ke size ke brabr vali substring btana he jisme k ki jo bhi size he utne unique character ho length chahe kitni bhi badi ho 
import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxlen = 0;
        int k = 2;

        while (j < n) {
            int ch = fruits[j];
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() < k) {
                maxlen = Math.max(maxlen, j - i + 1);
                j++;
            } 
            else if (map.size() == k) {
                maxlen = Math.max(maxlen, j - i + 1);
                j++;
            } 
            else if (map.size() > k) {
                while (map.size() > k) {
                    int leftchar = fruits[i];
                    map.put(leftchar, map.get(leftchar) - 1);
                    
                    if (map.get(leftchar) == 0) {
                        map.remove(leftchar);
                    }
                    i++; // i++ yahan if ke baad aayega
                }

                if (map.size() <= k) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
                j++;
            }
        }

        return maxlen;
    }
}
