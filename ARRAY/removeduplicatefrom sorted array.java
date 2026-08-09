//most optimize approach by using 2 pointer pattern time complexity O(n) and space is constant O(1).
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int off = 0; // Slow pointer (unique elements ki last index)
        int cm = 1;  // Current matching pointer
        int res = 1; // Total unique elements ki count

        while (cm < nums.length) {
            if (nums[cm] == nums[cm-1]) {
                // Duplicate mila, bas aage badho
                cm++; 
            } else {
                // Dynamic unique element mila!
                nums[off+1] = nums[cm];
                off++;
                 
                cm++;
                res++;
                 // Unique count badhao
            }
        }

        return res; // Final unique elements ki count
        
    }
}
