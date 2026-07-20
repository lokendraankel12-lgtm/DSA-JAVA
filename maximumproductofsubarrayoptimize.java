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
        // agr array me negative number honge to piche se loop lgega taki maximum product phle hi nikl jaye or agr array me zero hoga to uski condition already cover he 
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
