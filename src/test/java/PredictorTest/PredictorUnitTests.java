package PredictorTest;

import com.stackbuilders.picoplaca.controllers.Predictor;
import com.stackbuilders.picoplaca.models.CarDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PredictorUnitTests {

    @Test
    @DisplayName("Test 01 - correct prediction: the car driven cannot be on the road")
    void testCorrectPredictionCannotBeOnTheRoad() {
        CarDriver carDriver = new CarDriver("Bryan Rosillo", "2025-02-18", "08:30:00", "ABC-1234");
        Predictor predictor = new Predictor(carDriver);
        predictor.predict();
        assertEquals(false, predictor.canBeOnTheRoad);
    }


    @Test
    @DisplayName("Test 02 - correct prediction: the car driven can be on the road")
    void testCorrectPredictionCanBeOnTheRoad() {
        CarDriver carDriver = new CarDriver("Bryan Rosillo", "2025-02-18", "14:30:00", "ABC-1234");
        Predictor predictor = new Predictor(carDriver);
        predictor.predict();
        assertEquals(true, predictor.canBeOnTheRoad);
    }


}
