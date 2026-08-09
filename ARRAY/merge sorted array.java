//most optimize solution by ussing 2 pointer pattern time complexityO(n) and space O(1);
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int[] res = new int[m + n];
        
        int lp=0;
        int rp=0;
        int id=0;
        while(lp<m && rp<n){
            if(nums1[lp]<nums2[rp]){
              res[id] =nums1[lp];
              lp++;
              id++;
            }else{
                res[id]=nums2[rp];
                rp++;
                id++;
            }

        }
        while(lp<m){
            res[id]=nums1[lp];
            lp++;
            id++;
        }
        while(rp<n){
            res[id]=nums2[rp];
            rp++;
            id++;
        }
       for (int i = 0; i < m + n; i++) {
    nums1[i] = res[i]; 
}

    }
}
