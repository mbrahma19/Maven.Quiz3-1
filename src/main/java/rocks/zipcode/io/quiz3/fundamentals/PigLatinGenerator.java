package rocks.zipcode.io.quiz3.fundamentals;

/**
 * @author leon on 09/12/2018.
 */
public class PigLatinGenerator {
    public String translate(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            if (!VowelUtils.isVowel(s.charAt(0)) && !VowelUtils.isVowel(s.charAt(1)) && VowelUtils.isVowel(s.charAt(2))) {
                sb.append(s.substring(2) + s.substring(0, 2) + "ay");
                sb.append(" ");
            } else if (!VowelUtils.hasVowels(s)) {
                sb.append(s + "ay");
                sb.append(" ");
            } else {
                if (VowelUtils.startsWithVowel(s)) {
                    sb.append(s + "way");
                    sb.append(" ");
                }
                if (!VowelUtils.startsWithVowel(s)) {
                    int i = VowelUtils.getIndexOfFirstVowel(s);
                    sb.append(s.substring(i) + s.substring(0, i) + "ay");
                    sb.append(" ");
                }
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
