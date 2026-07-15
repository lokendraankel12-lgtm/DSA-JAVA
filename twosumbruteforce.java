class Main {
    // 1. रिटर्न टाइप को 'int' से बदलकर 'int[]' किया क्योंकि हमें एरे रिटर्न करना है
    public static int[] target(int arr[]) {
        int target = 9;
        int ans[] = new int[2];
        
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int second = arr[j];
                int sum = first + second;
                
                if (sum == target) {
                    // 2. यहाँ गड़बड़ थी! sum को रिटर्न करने के बजाय ans में इंडेक्स स्टोर किए
                    ans[0] = i; // पहले नंबर की पोजीशन
                    ans[1] = j; // दूसरे नंबर की पोजीशन
                    return ans; // अब इस पोजीशन वाले डिब्बे को रिटर्न कर दिया
                }
            }
        }
        
        // अगर कोई जोड़ीदार न मिले तो खाली डिब्बा रिटर्न कर दो
        int[] emptyAns = new int[0];
        return emptyAns;
    }
    
    public static void main(String[] args) {
        int arr[] = {5, 2, 11, 7, 15};
        
        // फंक्शन ने जो एरे (डिब्बा) दिया, उसे 'result' में रख लिया
        int[] result = target(arr);
        
        // अगर डिब्बे में 2 इंडेक्स हैं, तो उन्हें प्रिंट कर दो
        if (result.length == 2) {
            System.out.print("Indices are: " + result[0] + " and " + result[1]);
        } else {
            System.out.print("No pair found");
        }
    }
}
