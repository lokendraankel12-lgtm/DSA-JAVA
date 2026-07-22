// is code me hm linear search lgate he jisme time complexity o(n) ati he and space complexity to constant ati he 
class Solution {
    public int search(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
        
    }
}
.//
.//
// is code me hm rotated sorted array ka use krke binary search lgate he jisme time complexity optimize ho jati O(logn) ho jati he space same rhti O(1)
class Solution {
    public int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            // Step 1: Target mid par mil gaya
            if (nums[mid] == target) {
                return mid;
            }

            // Step 2: Check karo ki LEFT part sorted hai ya nahi
            if (nums[st] <= nums[mid]) {
                // Agar target LEFT sorted part ke range mein hai
                if (nums[st] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            } 
            // Step 3: Agar left sorted nahi hai, toh zaroor RIGHT part sorted hoga
            else {
                // Agar target RIGHT sorted part ke range mein hai
                if (nums[mid] <= target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // Target nahi mila
        return -1;
    }
}
