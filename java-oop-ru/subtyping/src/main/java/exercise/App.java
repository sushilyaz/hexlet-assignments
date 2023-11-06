package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> modifyStorage = new HashMap<>();
        modifyStorage.putAll(storage.toMap());
        for (Map.Entry<String, String> entry : modifyStorage.entrySet()) {
            storage.unset(entry.getKey());
            storage.set(entry.getValue(), entry.getKey());
        }

    }
}
// END
