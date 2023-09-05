package exercise;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> resultList = new ArrayList<>();
        var count = 0;
        for (var name : books) {
            count = 0;
            for (Map.Entry<String, String> ofName : where.entrySet()) {
                if (name.containsKey(ofName.getKey()) && name.containsValue(ofName.getValue())) {
                    count++;
                }
            }
            if (where.size() == count) {
                resultList.add(name);
            }
        }
        if (resultList.isEmpty()) {
            return new ArrayList<>();
        }
        else return resultList;

    }
}
//END
