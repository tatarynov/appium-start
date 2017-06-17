package asserts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Asserts {

    @Test
    public void assertEquals() {
        Assert.assertEquals(5, 5);
    }

    @Test
    public void assertFalse() {
        String string1 = "String1";
        String emptyString = "";
        Assert.assertFalse(string1.equals(emptyString));
    }

    @Test
    public void assertTrue() {
        String string1 = "String1";
        String emptyString = "String1";
        Assert.assertTrue(string1.equals(emptyString));
    }
}
