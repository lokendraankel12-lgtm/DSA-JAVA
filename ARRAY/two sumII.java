//most optimize approach with two pointer pattern time omplexity nlogn and space is O(1) yani zero space
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Step 1: Do pointers initialize karein
        int left = 0; // Array ka starting index
        int right = numbers.length - 1; // Array ka last index

        // Step 2: Loop chalaayein jab tak dono pointers cross nahi kar jaate
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            // Condition 1: Direct match mil gaya
            if (currentSum == target) {
                // Question 1-based indexing maangta hai, isliye + 1 kiya hai
                return new int[] {left + 1, right + 1};
            } 
            // Condition 2: Sum target se chhota hai -> Left ko aage badhao
            else if (currentSum < target) {
                left++;
            } 
            // Condition 3: Sum target se bada hai -> Right ko piche lao
            else {
                right--;
            }
        }

        // Agar koi pair nahi mila (waise question guarantee karta hai ki 1 solution hoga)
        return new int[] {};
    }
}
