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
//better approch me tisri loop ht jaygi but dono me [0 or -1 vale number ki condition nhi lgi hui he ]
public class Solution {
    public static int maxProductSubarrayBetter(int[] numbers) {
        int maxProduct = Integer.MIN_VALUE; // Max product track karne ke liye

        // 1. Outer loop: Subarray ka starting point
        for (int i = 0; i < numbers.length; i++) {
            
            // Har naye starting point ke liye product ko 1 se reset karenge
            int currProduct = 1; 

            // 2. Inner loop: Subarray ko ek-ek karke aage badhata hai
            for (int j = i; j < numbers.length; j++) {
                
                // Jo aapne kaha—bilkul simple tarike se multiply kiya
                currProduct = currProduct * numbers[j]; 

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
        System.out.println("Maximum Product: " + maxProductSubarrayBetter(nums)); 
        // Output: 6
    }
}
