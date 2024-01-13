package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.*;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.*;
import org.springframework.web.context.annotation.*;

// BEGIN
@Scope("prototype")
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    public Daytime getTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        if (isDayTime(currentTime)) {
            return new Day();
        } else {
            return new Night();
        }
    }

    private boolean isDayTime(LocalDateTime currentTime) {
        LocalTime time = currentTime.toLocalTime();
        return time.isAfter(LocalTime.of(6,0)) && time.isBefore(LocalTime.of(22,0));
    }
    // END
}
