package rocks.zipcode.io.quiz3.arrays;

import java.util.ArrayList;

/**
 * @author leon on 09/12/2018.
 */
public class WaveGenerator {
    public static String[] wave(String str) {
        ArrayList<String> result = new ArrayList<>();
        String lowerStr = str.toLowerCase();

        for(int i = 0 ; i < lowerStr.length(); i++){

            if(isAlphaString(String.valueOf(lowerStr.charAt(i)))){

                char[] charArray = lowerStr.toCharArray();
                charArray[i] = Character.toUpperCase(charArray[i]);
                result.add(String.valueOf(charArray));
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static Boolean isAlphaString(String string) {
        return string.replace(" ", "").matches("[a-zA-Z]+");
    }
}
