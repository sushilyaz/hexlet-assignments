package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static KeyValueStorage swapKeyValue(KeyValueStorage storage) {
        Map<String, String> buffMap = new HashMap<>(storage.toMap());
        KeyValueStorage result = new InMemoryKV(new HashMap<>());

        for (Map.Entry<String, String> line : storage.toMap().entrySet()) {
            storage.unset(line.getKey());
        }
        for (Map.Entry<String, String> line : buffMap.entrySet()) {
            storage.set(line.getValue(), line.getKey());
        }
        
        return storage;
    }
}
// END
