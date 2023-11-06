package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
    private Map<String, String> dataStorage = new HashMap<>();
    public InMemoryKV(Map<String, String> dataStorage) {
        this.dataStorage.putAll(dataStorage);
    }

    @Override
    public void set(String key, String value) {
        dataStorage.put(key, value);
    }

    @Override
    public void unset(String key) {
        dataStorage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return dataStorage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dataStorage);
    }
}
// END
