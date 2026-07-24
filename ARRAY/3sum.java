// brute force approch which have very bad time complexity like O(n3)
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Unique triplets store karne ke liye Set use karenge taaki duplicates na aayein
        Set<List<Integer>> resultSet = new HashSet<>();
        int n = nums.length;

        // Loop 1: Pehla element (i)
        for (int i = 0; i < n - 2; i++) {
            // Loop 2: Doosra element (j)
            for (int j = i + 1; j < n - 1; j++) {
                // Loop 3: Teesra element (k)
                for (int k = j + 1; k < n; k++) {
                    
                    // Check karo kya teeno ka sum 0 hai
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        
                        // Triplets ko sort karke list banate hain taaki [a, b, c] aur [b, a, c] same lagein
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        
                        // Set mein add karne se duplicate triplets apne aap handle ho jayenge
                        resultSet.add(triplet);
                    }
                }
            }
        }

        // Set ko List mein convert karke return kar do
        return new ArrayList<>(resultSet);
    }
}
//
// now we solve with better approach which have o(n2*log(ul)) time complexity
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Unique triplets ke liye global Set
        Set<List<Integer>> resultSet = new HashSet<>();
        int n = nums.length;

        // Loop 1: i
        for (int i = 0; i < n; i++) {
            // Har 'i' ke liye ek naya Hashset jo i aur j ke beech ke numbers rakhega
            Set<Integer> hashset = new HashSet<>();

            // Loop 2: j
            for (int j = i + 1; j < n; j++) {
                
                // Formula: nums[i] + nums[j] + third = 0
                int third = -(nums[i] + nums[j]);

                // Agar third element pehle dekha ja chuka hai
                if (hashset.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplet);
                    resultSet.add(triplet);
                }

                // Current element ko hashset mein daalo aage ke comparisons ke liye
                hashset.add(nums[j]);
            }
        }

        return new ArrayList<>(resultSet);
    }
}
//
//now we are solving this question with most optimize approach  which o(nlogn+n2) and space O(unique triplets)
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Step 1: Array ko sort karna mandatory hai
        Arrays.sort(nums);

        // Outer loop: Pehla element 'i' (direct n tak)
        for (int i = 0; i < n; i++) {
            
            // Step 2: 'i' ke duplicate values ko skip karo
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Two pointers set karo
            int j = i + 1; // Left pointer
            int k = n - 1; // Right pointer

            // Step 4: Two-pointer searching loop
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++; // Sum chota hai -> Left pointer ko aage badhao
                } else if (sum > 0) {
                    k--; // Sum bada hai -> Right pointer ko piche lao
                } else {
                    // Valid triplet mil gaya!
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    j++;
                    k--;

                    // Step 5: 'j' ke duplicate values ko skip karo
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }

        return ans;
    }
}
