package TimeTest;

import com.stackbuilders.picoplaca.models.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeUnitTests {

    @Test
    @DisplayName("Test 01 - correct time creation")
    void testCreationTime(){
        String stringTime = "12:05:05";
        Time time = new Time(stringTime);
        assertEquals(stringTime, time.getLocalTime().toString());
    }

    @ParameterizedTest
    @DisplayName("Test 02 - incorrect time creation with invalid data")
    @ValueSource(strings = {"12:05:60", "12:60:05", "25:05:05", "12:05:05:05", "12:555"})
    void testIncorrectCreationTimeWithInvalidData(String stringTime){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Time(stringTime));
        assertEquals("Invalid time, please enter a valid value.", exception.getMessage());
    }

}
