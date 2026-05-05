import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PricingEngineTest {

    @Test
    void testCalculation() {
        PricingEngine engine = new PricingEngine();

        double[] prices = {100, 50};
        int[] qty = {1, 2};

        double result = engine.calculate(prices, qty, "REGULAR", "SAVE10");

        assertTrue(result > 0);
    }
}