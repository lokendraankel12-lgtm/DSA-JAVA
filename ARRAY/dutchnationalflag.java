//most optimize way with using only  1parse by using technique 3 pointer low ,high ,mid time complexity O(n) 
class Solution {
    void segregate0and1(int[] arr) { // Sort Colors / DNF Algorithm
        int n = arr.length;
        
        // Pointers ko loop se BAAHAR declare karo
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // Condition <= honi chahiye
        while (mid <= high) {
            if (arr[mid] == 0) {
                // 0 milne par low aur mid ko swap karo
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // 1 milne par bas mid ko aage badhao
                mid++;
            } else {
                // 2 milne par mid aur high ko swap karo aur high ko piche lao
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                
                high--;
            }
        }
    }
}
// and now there is one more optimize way which gives same time complexity but there is 2 parse array me 2 bar chlna pdega
class Solution {
    public void sortColors(int[] nums) {
        // Step 1: Teen variables ginti (count) rakhne ke liye
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // Array mein traverse karke counting karo
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        // Step 2: Original array ko rewrite karo
        int index = 0;

        // Pehle saare 0s daal do
        for (int i = 0; i < count0; i++) {
            nums[index] = 0;
            index++;
        }

        // Phir saare 1s daal do
        for (int i = 0; i < count1; i++) {
            nums[index] = 1;
            index++;
        }

        // Phir saare 2s daal do
        for (int i = 0; i < count2; i++) {
            nums[index] = 2;
            index++;
        }
    }
}
// there is also brute force technique 
import java.util.ArrayList;

class Solution {
    public void sortColors(int[] nums) {
        // 3 Alag ArrayLists 0s, 1s, aur 2s ke liye
        ArrayList<Integer> zeros = new ArrayList<>();
        ArrayList<Integer> ones = new ArrayList<>();
        ArrayList<Integer> twos = new ArrayList<>();

        // Step 1: Normal index-based loop se elements ko alag-alag lists mein daalo
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (num == 0) {
                zeros.add(0);
            } else if (num == 1) {
                ones.add(1);
            } else {
                twos.add(2);
            }
        }

        // Step 2: Main array ko teeno lists se sequence-wise fill karo
        int index = 0;

        // Pehle saare 0s daalo
        for (int i = 0; i < zeros.size(); i++) {
            nums[index] = zeros.get(i);
            index++;
        }

        // Phir saare 1s daalo
        for (int i = 0; i < ones.size(); i++) {
            nums[index] = ones.get(i);
            index++;
        }

        // Phir saare 2s daalo
        for (int i = 0; i < twos.size(); i++) {
            nums[index] = twos.get(i);
            index++;
        }
    }
}
