package parameters;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void testThisShouldBeExecuted() {
        Assert.assertEquals(true, true);
    }

    @Test(enabled = false)
    public void testThisShouldBeSkipped() {
        Assert.assertEquals(true, true);
    }

}
