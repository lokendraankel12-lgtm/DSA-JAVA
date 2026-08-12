class Solution {
    int countTriplets(int sum, int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0; // Standard int Data Type

        for (int i = 0; i < n - 2; i++) {
            int lp = i + 1;
            int rp = n - 1;

            while (lp < rp) {
                int s = arr[i] + arr[lp] + arr[rp];

                if (s >= sum) {
                    rp--;
                } else {
                    count = count + (rp - lp);
                    lp++;
                }
            }
        }
        return count;
    }
}
