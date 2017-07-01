package testng_examples.parameters;

import org.testng.annotations.Test;

public class TimeoutTest {

    @Test(timeOut = 5000) // time in milliseconds
    public void testThisShouldPass() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test(timeOut = 5000)
    public void testThisShouldFail() {
        while (true);
    }

}
