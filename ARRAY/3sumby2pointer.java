// time complexity n2 and using 2pointer pattern
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Array ko sort karna zaruri hai

        for (int i = 0; i < nums.length - 2; i++) {
            // First element ke duplicates skip karo
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int lp = i + 1;
            int rp = nums.length - 1;

            while (lp < rp) {
                int sum = nums[i] + nums[lp] + nums[rp];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    lp++;
                    rp--;

                    // Left pointer ke duplicates skip karo
                    while (lp < rp && nums[lp] == nums[lp - 1]) {
                        lp++;
                    }
                    // Right pointer ke duplicates skip karo
                    while (lp < rp && nums[rp] == nums[rp + 1]) {
                        rp--;
                    }
                } else if (sum < 0) {
                    lp++; // Sum chhota hai to left pointer aage badhao
                } else {
                    rp--; // Sum bada hai to right pointer piche lao
                }
            }
        }
        return ans;
    }
}
