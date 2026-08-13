// most optimize solution by using sliding window technique  which give time complexity is (n)
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
       int n=arr.length;
       int low=0; 
       int high=k-1;
       int currntsum =0;
       for(int i=low; i<=high; i++){
            currntsum=currntsum+arr[i];
       }
       int maxisum=currntsum;
       while(high<n-1){
           low++;
           high++;
           currntsum=currntsum+arr[high];
           currntsum=currntsum-arr[low-1];
           maxisum = Math.max(currntsum, maxisum);
       }
       return maxisum;
       
    }
    
}
