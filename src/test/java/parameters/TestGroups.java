package parameters;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

//@Test(groups= "selenium-test")
public class TestGroups {

    @BeforeGroups(value = "user-creation", alwaysRun = true)
    public void setupEnvironment() {
        System.out.println("setupEnvironment()");
    }

    @AfterGroups(value = "user-creation", alwaysRun = true)
    public void cleanEnvironment() {
        System.out.println("cleanEnvironment()");
    }

    @Test(groups = "user-creation")
    public void createUserPositive() {
        System.out.println("createUserPositive()");
    }

    @Test(groups = {"user-creation"})
    public void createUserNegative() {
        System.out.println("createUserNegative()");
    }

    @Test(groups = {"data-sharing"})
    public void shareDataPositive() {
        System.out.println("shareDataPositive()");
    }

    @Test(groups = {"data-sharing"})
    public void shareDataNegative() {
        System.out.println("shareDataNegative");
    }

    @Test(dependsOnGroups = {"user-creation", "data-sharing"})
    public void runFinal() {
        System.out.println("runFinal");
    }

}
