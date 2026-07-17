class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int currentProduct = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue; 
                }
                currentProduct = currentProduct * nums[j];
            }
            
            ans[i] = currentProduct;
        }
        
        return ans;
        
}
}
