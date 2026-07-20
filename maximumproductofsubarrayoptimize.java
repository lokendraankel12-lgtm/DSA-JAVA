class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct = Integer.MIN_VALUE;
        int crrproduct = 1;
        
        // 1. Left se Right multiply karo (Prefix)
        for (int i = 0; i < nums.length; i++) {
            crrproduct = crrproduct * nums[i];
            maxproduct = Math.max(maxproduct, crrproduct);
            
            // AGAR ZERO AYE TOH RESET KARO
            if (crrproduct == 0) {
                crrproduct = 1;
            }
        }
        
        // 2. Right se Left multiply karo (Suffix) - Negative numbers ke liye
        crrproduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            crrproduct = crrproduct * nums[i];
            maxproduct = Math.max(maxproduct, crrproduct);
            
            // AGAR ZERO AYE TOH RESET KARO
            if (crrproduct == 0) {
                crrproduct = 1;
            }
        }
        
        return maxproduct;
    }
}
