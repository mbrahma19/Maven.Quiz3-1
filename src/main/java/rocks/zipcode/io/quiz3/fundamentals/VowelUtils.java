package rocks.zipcode.io.quiz3.fundamentals;

/**
 * @author leon on 09/12/2018.
 */
public class VowelUtils {
    public static Boolean hasVowels(String word) {
        Boolean result = false;
        for(char c : word.toCharArray()){
            if(isVowel(c)){
                result = true;
                break;
            }
        }
        return result;
    }

    public static Integer getIndexOfFirstVowel(String word) {
        Integer result = -1;
        for(int i = 0; i < word.length(); i++){
            if(isVowel(word.charAt(i))){
                result = i;
                break;
            }
        }
        return result;
    }


    public static Boolean startsWithVowel(String word) {
        return isVowel(word.charAt(0));
    }

    public static Boolean isVowel(Character character) {
        return character.toString().matches("[aeiouAEIOU]+");
    }
}
