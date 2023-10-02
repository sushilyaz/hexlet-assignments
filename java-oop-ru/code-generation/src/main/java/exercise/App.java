package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.*;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        byte[] bytes;
        bytes = Car.serialize(car).getBytes();
        try {
            Files.write(path, bytes, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract (Path path) {
        User user = new User(8, "Nikolay", "Ivanov", 50);
        return new Car(5, "audi", "q7", "white", user);
    }
}
// END
