package LicensePlateTests;

import com.stackbuilders.picoplaca.models.LicensePlateNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class LicencePlateNumberUnitTests {

    @ParameterizedTest
    @DisplayName("Test 01 - correct license plate number creation")
    @ValueSource(strings = {"ABC-1234", "XYZ-5678", "QWE-987", "RTY-123"})
    void testCreationLicensePlateNumber(String stringLicensePlateNumber){
        LicensePlateNumber licensePlateNumber = new LicensePlateNumber(stringLicensePlateNumber);
        assertNotNull(licensePlateNumber.getLetters());
        assertNotNull(licensePlateNumber.getNumbers());
    }

    @ParameterizedTest
    @DisplayName("Test 02 - incorrect license plate number creation")
    @ValueSource(strings = {"ABCD-1234", "XYZ-56781", "QaWE-987", "RTY-1x23"})
    void testIncorrectCreationLicensePlateNumber(String stringLicensePlateNumber){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new LicensePlateNumber(stringLicensePlateNumber));
        assertEquals("Invalid licence plate number, please enter a valid value.", exception.getMessage());
    }

}
