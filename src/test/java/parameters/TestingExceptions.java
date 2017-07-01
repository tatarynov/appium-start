package parameters;

import org.testng.annotations.Test;

public class TestingExceptions {

    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1 / 0;
    }

}
