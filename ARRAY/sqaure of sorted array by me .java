// pure mere smjhe hue logic se by using two pointer technique
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans []= new int[n];
        int k=ans.length-1;
        while(low<=high){
            int leftsq =nums[low]*nums[low];
          int  rightsq=nums[high]*nums[high];
            if(leftsq>rightsq){
                ans[k]=leftsq;
                low++;
                k--;
            }else if(leftsq==rightsq){
                ans[k]=leftsq;
                low++;
                k--;
            }else{
                // agr rightsq bada hua to leftsq se 
                ans[k]=rightsq;
                high--;
                k--;
            }

        }
        return ans;

    }
}
