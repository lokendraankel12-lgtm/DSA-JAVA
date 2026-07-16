import java.util.*;

class Main {
    public static int[] twosum(int arr[], int target){
        // 1. M कैपिटल किया -> HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[2];
        
        for(int i = 0; i < arr.length; i++){
            int first = arr[i];
            int second = target - first; 
            
            // 2. K कैपिटल किया (containsKey) और 'sec' को बदलकर 'second' किया
            if(map.containsKey(second)){
                ans[0] = i;
                ans[1] = map.get(second); // 3. 'sec' को 'second' किया
                break;
            }
            map.put(first, i);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;
        
        // 4. जवाब को एक डिब्बे (result) में लिया और उसे प्रिंट करवाया
        int[] result = twosum(arr, target);
        
        System.out.print("Indices are: " + result[0] + " and " + result[1]);
    }
}
