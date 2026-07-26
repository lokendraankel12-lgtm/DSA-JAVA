//brute bruce which give O(n2) time complexity
class Solution {
    public int maxArea(int[] height) {
        int maxwater=0;
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int width=j-i;
                int ht=Math.min(height[i],height[j]);
                int area=width*ht;
                maxwater=Math.max(maxwater,area);
            }
        }
        return maxwater;
        
    }
}
//  optimize approch which give O(n)
class Solution {
    public int maxArea(int[] height) {
        int maxwater = 0;
        
        // Fix 1: lp ko index 0 rakho, height[0] nahi!
        int lp = 0; 
        int rp = height.length - 1;

        while (lp < rp) {
            int width = rp - lp;
            
            // Fix 2: height[lp] aur height[rp] access karo
            int ht = Math.min(height[lp], height[rp]); 
            int area = width * ht;

            maxwater = Math.max(maxwater, area);

            // Fix 3: Heights ke basis par pointers move karo
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxwater;
    }
}
