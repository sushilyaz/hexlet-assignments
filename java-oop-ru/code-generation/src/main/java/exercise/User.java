package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

// BEGIN
// END
final class User {
    int id;
    String firstName;
    String lastName;
    int age;

    public User(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
