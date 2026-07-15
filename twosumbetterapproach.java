import java.util.Arrays; // सॉर्टिंग करने के लिए इस लाइब्रेरी की जरूरत पड़ती है

class Main {
    
    public static int[] target(int arr[]) {
        int target = 9;
        
        // 1. सबसे पहले एरे को छोटे से बड़े क्रम में सॉर्ट (Sort) किया
        Arrays.sort(arr); 
        
        int start = 0;
        int end = arr.length - 1;
        
        // यह हमारा जवाब स्टोर करने वाला सीधा-साधा डिब्बा है जिसमें 2 साइज की जगह है
        int[] ans = new int[2]; 
        
        // 2. जब तक start पॉइंटर end पॉइंटर से छोटा है, तब तक लूप चलेगा
        while (start < end) { 
            
            // दोनों पॉइंटर्स पर रखी वैल्यूज का जोड़ निकाला
            int sum = arr[start] + arr[end]; 
            
            // अगर जोड़ टारगेट के बराबर मिल गया
            if (sum == target) {
                ans[0] = start; // पहले खाने में start वाला इंडेक्स डालो
                ans[1] = end;   // दूसरे खाने में end वाला इंडेक्स डालो
                return ans;     // तैयार डिब्बे को वापस भेज दो
            } 
            // अगर जोड़ टारगेट से बड़ा है, तो पीछे से एक कदम कम करो
            else if (sum > target) {
                end--;
            } 
            // अगर जोड़ टारगेट से छोटा है, तो आगे से एक कदम बढ़ाओ
            else {
                start++;
            }
        }
        
        // अगर पूरे लूप में कहीं भी टारगेट नहीं मिला, तो खाली डिब्बा रिटर्न कर दो
        int[] emptyAns = new int[0]; 
        return emptyAns; 
    }
    
    public static void main(String[] args) {
        int arr[] = {5, 2, 11, 7, 15};
        
        // फंक्शन को कॉल किया और उसने जो एरे दिया, उसे 'result' में रख लिया
        int[] result = target(arr);
        
        // अगर result का साइज 2 है, मतलब हमें जोड़ी मिल गई है
        if (result.length == 2) {
            System.out.print("Indices are: " + result[0] + " and " + result[1]);
        } else {
            System.out.print("No pair found");
        }
    }
}
