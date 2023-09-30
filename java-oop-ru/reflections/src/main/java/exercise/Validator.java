package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
// BEGIN
public class Validator {
    public static List<String> validate(Address instance) {
        List<Field> fields = List.of(instance.getClass().getDeclaredFields());
        return fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(field -> {
                    Object value;
                    try {
                        field.setAccessible(true);
                        value = field.get(instance);
                        field.setAccessible(false);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return value == null;
                })
                .map(Field::getName)
                .collect(Collectors.toList());
    }
}
// END
