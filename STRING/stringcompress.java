import java.util.*;

public class Main {

    public static String compress(String str) {
        // String newStr = ""; ki jagah StringBuilder use kiya
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;

            // Jab tak agla character same hai, count badhao
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            // newStr += str.charAt(i); ki jagah sb.append()
            sb.append(str.charAt(i));

            // Agar count > 1 hai to number bhi append kar do
            if (count > 1) {
                // newStr += count.toString(); ki jagah sb.append()
                sb.append(count);
            }
        }

        // Return karte waqt String me convert kar diya
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaabbcccdd";
        System.out.println(compress(str));
    }
}
