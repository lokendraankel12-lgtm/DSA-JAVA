import java.util.*;

class Main {
   public static boolean contanduplicate(int nums[]){
       // 1. हर एक एलिमेंट को उठाओ
       for(int i=0; i<nums.length; i++){
           int first = nums[i]; // arr की जगह nums किया
           
           // 2. उसके आगे वाले एलिमेंट्स से तुलना करो
           for(int j=i+1; j<nums.length; j++){
               int second = nums[j]; // arr की जगह nums किया
               
               if(first == second){
                   return true; // डुप्लिकेट मिलते ही तुरंत true रिटर्न करो
               }
               // यहाँ से else { return false; } हटा दिया है
           }
       }
       
       // 3. अगर पूरा लूप खत्म हो गया और कोई डुप्लिकेट नहीं मिला, तब false रिटर्न करो
       return false; 
   }
    
    public static void main(String[] args) {
       int nums[] = {1, 2, 3, 1};
       // आउटपुट को प्रिंट भी करा लेते हैं ताकि स्क्रीन पर दिखे
       System.out.println(contanduplicate(nums)); 
    }
}
