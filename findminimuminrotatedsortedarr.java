public class Solution {
    public int findMinBruteForce(int[] nums) {
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i]; // Chota element milte hi update kar do
            }
        }
        
        return min;
    }
}
// is approach me dikkt ye he ki time O(n) ka lg rh he 
// or dusri chize ye he ki array rotated sorted he iska fayda nhi uta pa rhi he ye approach yha blindly searching ho rhi he pure array pr .
//.
.//
.//
.//

// ab is logic me hm sorted roted array ko use krenge or blndly search nhi krenge 
public class Solution {
    public int findMinBetter(int[] nums) {
        // Agar array rotated nahi hai ya 1 element ka hai
        if (nums.length == 1) return nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Jahan pe graph niche gira, wahi minimum hai
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        
        // Agar poora loop chal gaya matlab array rotate hua hi nahi tha (e.g. [1, 2, 3, 4])
        return nums[0];
    }
}
//.
//.
//most otimize approach using binary search jiski time comlexityo(logn)and space complexity is o(1)
int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            // Agar mid wala element end wale se bada hai, toh minimum RIGHT side mein hai
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } 
            // Nahi toh minimum LEFT side mein hai (ya mid khud minimum hai)
            else {
                end = mid;
            }
        }
        
        // Loop khatam hone par start aur end dono minimum index par hi aakar rukenge
        return nums[start];
