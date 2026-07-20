public class Solution {
    public static int maxProductSubarrayBruteForce3Loops(int[] numbers) {
        int maxProduct = Integer.MIN_VALUE; // Max product track karne ke liye

        // 1. Outer loop: Subarray ka starting point
        for (int i = 0; i < numbers.length; i++) {
            int start = i;

            // 2. Inner loop: Subarray ka ending point
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                
                int currProduct = 1; // Har naye subarray ke liye product 1 se start hoga

                // 3. K-loop: 'start' se lekar 'end' tak ke saare elements ko multiply karo
                for (int k = start; k <= end; k++) {
                    currProduct *= numbers[k];
                }

                // Agar current product ab tak ka sabse bada hai, toh update karo
                if (maxProduct < currProduct) {
                    maxProduct = currProduct;
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product: " + maxProductSubarrayBruteForce3Loops(nums)); 
        // Output: 6
    }
}
