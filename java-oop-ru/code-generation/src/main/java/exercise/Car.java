package exercise;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

// BEGIN
// END
public class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    public Car(int id, String brand, String model, String color, User owner) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.owner = owner;
    }
    public Car () {}

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public User getOwner() {
        return owner;
    }

    // BEGIN
    public static String serialize(Car car) {
        ObjectMapper objectMapper = new ObjectMapper();
        String res = "";
        try {
            res = objectMapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static Car unserialize(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car();
        try {
            car = objectMapper.readValue(new File(json), Car.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return car;
    }
    // END
}
