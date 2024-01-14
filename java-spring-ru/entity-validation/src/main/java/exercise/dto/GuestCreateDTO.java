package exercise.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.*;

// BEGIN
@Getter
@Setter
public class GuestCreateDTO {
    @NonNull
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^\\+[0-9]{11,13}$")
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}")
    private String clubCard;

    @Future(message = "Срок действия карты истек")
    private LocalDate cardValidUntil;

}
// END
