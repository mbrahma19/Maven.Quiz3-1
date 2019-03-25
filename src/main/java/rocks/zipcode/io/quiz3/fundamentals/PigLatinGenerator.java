package rocks.zipcode.io.quiz3.fundamentals;

/**
 * @author leon on 09/12/2018.
 */
public class PigLatinGenerator {
    private StringBuilder sb;

    public PigLatinGenerator() {
        this.sb = new StringBuilder();
    }

    public String translate(String str) {
        String[] words = str.split(" ");

        for (String s : words) {
            if (!VowelUtils.isVowel(s.charAt(0)) && !VowelUtils.isVowel(s.charAt(1)) && VowelUtils.isVowel(s.charAt(2))) {
                buildString(s.substring(2) + s.substring(0, 2),"ay");
            } else if (!VowelUtils.hasVowels(s)) {
                buildString(s, "ay");
            } else {
                if (VowelUtils.startsWithVowel(s)) {
                    buildString(s, "way");
                }
                else{
                    int i = VowelUtils.getIndexOfFirstVowel(s);
                    buildString((s.substring(i) + s.substring(0, i)), "ay");
                }
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void buildString(String string, String append) {
        sb.append(string + append);
        sb.append(" ");
    }
}
