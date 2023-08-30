package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
//    public static void main (String [] args) {
//        System.out.println(scrabble("", "hexlet"));
//    }
    public static boolean scrabble(String str, String word) {
        List<String> strList = new ArrayList<>(str.length());
        List<String> wordList = new ArrayList<>(word.length());
        List<String> resultList = new ArrayList<>(word.length());
        String[] strSplit = str.toLowerCase().split("");
        strList.addAll(Arrays.asList(strSplit));
        String[] wordSplit = word.toLowerCase().split("");
        wordList.addAll(Arrays.asList(wordSplit));
        for (var letter : wordList) {
            if (strList.contains(letter)) {
                strList.remove(letter);
                resultList.add(letter);
            }
        }
        if (resultList.equals(wordList)) return true;
        return false;
    }
}
//END
