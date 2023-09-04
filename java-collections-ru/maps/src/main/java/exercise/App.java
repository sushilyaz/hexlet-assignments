package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class App {
    public static void main(String[] args) {
        String sentence = "the java is the best programming language java";
        Map wordsCount = App.getWordCount(sentence);
        System.out.println(wordsCount);
        String result = App.toString(wordsCount);
        System.out.println(result);
    }

    // BEGIN
    public static Map getWordCount(String sentence) {
        String[] res = sentence.split(" ");
        Map <String, Integer> wordCountMap = new HashMap<>();
        var count = 0;
        for (int i = 0; i < res.length; i++) {
            count = 0;
            for (int j = 0; j < res.length; j++) {
                //if (i == j) continue;
                if (res[i].equals(res[j])) count++;
            }
            wordCountMap.put(res[i], count);
        }
        return wordCountMap;
    }
    public static String toString (Map wordCountMap) {
        Map<String, Integer> wordCountMapMain = new HashMap<>(wordCountMap);
        String str = "{";
        for (Map.Entry<String, Integer> word : wordCountMapMain.entrySet()) {
            str = str + "\n" + "  " + word.getKey() + ": " + word.getValue();
        }
        str = str + "\n" + "}";
        return str;
    }
}
//END
