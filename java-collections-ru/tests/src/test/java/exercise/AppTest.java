package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int count = 2;
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> actualList = App.take(numbers1, count);
        assertThat(actualList).isEqualTo(expectedList);
    }
}
