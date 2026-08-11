//using 2pointer pattern which give o(n2) time complexity
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
         int closestsum=nums[0]+nums[1]+nums[2];
        for(int i=0; i<n-2; i++){
            int lp=i+1;
            int rp=n-1;
            while(lp<rp){
                int currentsum=nums[i]+nums[lp]+nums[rp];
                if(currentsum==target){
                    return currentsum;
                }
                if(Math.abs(target-currentsum)<Math.abs(target-closestsum)){
                    closestsum=currentsum;
                }
                if(currentsum<target){
                    lp++;
                }else{
                    rp--;
                }
            }
        }
        return closestsum;

        
    }
}
