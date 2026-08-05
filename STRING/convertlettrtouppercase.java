import java.util.*;

public class Main {

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        // Pehle character (index 0) ko hamesha uppercase bana do
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        // Baaki poori string par loop chalao
        for (int i = 1; i < str.length(); i++) {
            
            // Agar current character 'Space' hai AND hum last element par nahi hain
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i)); // Space ko as it is append karo
                i++; // Agle character par jao
                sb.append(Character.toUpperCase(str.charAt(i))); // Us agle character ko uppercase banakar append karo
            } else {
                sb.append(str.charAt(i)); // Normal characters ko as it is add karo
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "hi, i am shradha";
        System.out.println(toUpperCase(str));
    }
}
