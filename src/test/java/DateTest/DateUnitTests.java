package DateTest;

import com.stackbuilders.picoplaca.models.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateUnitTests {

    @Test
    @DisplayName("Test 01 - correct date creation")
    void testCreationDate(){
        String stringDate = "2021-01-01";
        Date date = new Date(stringDate);
        assertEquals(stringDate, date.getLocaDate().toString());
    }

    @ParameterizedTest
    @DisplayName("Test 02 - incorrect date creation")
    @ValueSource(strings = {"20XX-01-01", "2001-80-01", "2001-01-78", "2001/01/01"})
    void testIncorrectCreationDateWithInvalidData(String stringDate){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Date(stringDate));
        assertEquals("Invalid date, please enter a valid value.", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Test 03 - incorrect date creation with leap year")
    @ValueSource(strings = {"2023-02-29", "2022-02-29", "1900-02-31"})
    void testIncorrectCreationDateWithLeapYear(String stringDate){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Date(stringDate));
        assertEquals("Invalid date, please enter a valid value.", exception.getMessage());
    }


}
