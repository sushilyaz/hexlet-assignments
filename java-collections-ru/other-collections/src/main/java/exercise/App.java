package exercise;

import java.util.*;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff (Map<String,Object> data1, Map<String, Object> data2) {
        NavigableSet<String> unionKey = new TreeSet<>();
        Set<String> keySetData1 = new HashSet<>();
        Set<String> keySetData2 = new HashSet<>();
        for (Map.Entry<String, Object> name : data1.entrySet()) {
            keySetData1.add(name.getKey());
        }
        for (Map.Entry<String, Object> name : data2.entrySet()) {
            keySetData2.add(name.getKey());
        }
        unionKey.addAll(keySetData1);
        unionKey.addAll(keySetData2);
        LinkedHashMap<String, String> res = new LinkedHashMap<>(unionKey.size());

        for (var line : unionKey) {
            if (!data1.containsKey(line) && data2.containsKey(line)) res.put(line, "added");
            else if (data1.containsKey(line) && !data2.containsKey(line)) res.put(line, "deleted");
            else if (data1.containsKey(line) && data2.containsKey(line) && !data1.get(line).equals(data2.get(line))) res.put(line, "changed");
            else if (data1.containsKey(line) && data2.containsKey(line) && data1.get(line).equals(data2.get(line))) res.put(line, "unchanged");
        }

//        for (Map.Entry <String, String> line : res.entrySet()) {
//            if (!data1.containsKey(line.getKey()) && data2.containsKey(line.getKey())) line.setValue("added");
//            else if (data1.containsKey(line.getKey()) && !data2.containsKey(line.getKey())) line.setValue("deleted");
//            else if (data1.containsKey(line.getKey()) && data2.containsKey(line.getKey()) && !data1.get(line.getKey()).equals(data2.get(line.getKey()))) line.setValue("changed");
//            else if (data1.containsKey(line.getKey()) && data2.containsKey(line.getKey()) && data1.get(line.getKey()).equals(data2.get(line.getKey()))) line.setValue("unchanged");
//        }
        return res;
    }
}
//END
