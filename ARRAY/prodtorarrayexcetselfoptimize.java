import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // C++ के वेक्टर्स को जावा के एरे में बदला
        int[] ans = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        // जावा में एरे के हर डिब्बे को शुरुआत में 1 से भरने के लिए
        Arrays.fill(ans, 1);
        Arrays.fill(prefix, 1);
        Arrays.fill(suffix, 1);
        
        // 1. Prefix Loop (आगे से पीछे)
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        
        // 2. Suffix Loop (पीछे से आगे) - दीदी ने i = n-2 से शुरू किया है
        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        
        // 3. Final Multiplication Loop
        for(int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }
        
        return ans;
    }
}
// most optimaize code means in this code we are optimize space complexity
import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // आंसर स्टोर करने के लिए एरे बनाया
        int[] ans = new int[n];
        Arrays.fill(ans, 1); // पूरे एरे को शुरुआत में 1 से भर दिया
        
        // 1. Prefix Loop (आगे की यात्रा - लेफ्ट साइड का गुणा)
        for(int i = 1; i < n; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        int suffix = 1;
        // 2. Suffix Loop (पीछे की यात्रा - राइट साइड का गुणा)
        for(int i = n - 2; i >= 0; i--) {
            // दोनों लाइनों का शॉर्टकट खोल दिया है:
            suffix = suffix * nums[i+1]; 
            ans[i] = ans[i] * suffix;
        }
        
        return ans;
    }
}
