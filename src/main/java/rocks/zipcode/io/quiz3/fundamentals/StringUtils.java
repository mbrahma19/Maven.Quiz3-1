package rocks.zipcode.io.quiz3.fundamentals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon on 09/12/2018.
 */
public class StringUtils {
    public static String capitalizeNthCharacter(String str, Integer indexToCapitalize) {
        char[] chars = str.toCharArray();
        chars[indexToCapitalize] = Character.toUpperCase(str.charAt(indexToCapitalize));
        return String.valueOf(chars);
    }

    public static Boolean isCharacterAtIndex(String baseString, Character characterToCheckFor, Integer indexOfString) {
        return baseString.charAt(indexOfString) == characterToCheckFor.charValue();
    }

    public static String[] getAllSubStrings(String string) {
        List<String> result = new ArrayList<>();

        for(int i = 0 ; i <= string.length() ; i++){
            for(int j = i+1 ; j <= string.length() ; j++){
                String sub = string.substring(i,j);
                if(!result.contains(sub)) {
                    result.add(sub);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static Integer getNumberOfSubStrings(String input){
        return (input.length()*(input.length()+1))/2 -1;
    }
}
