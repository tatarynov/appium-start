import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TaskTwo {

    /***
     *
     Create test class and use in it following annotations:

     @BeforeGroups
     @AfterGroups


     // Example

     @BeforeGroups("findABug") public void beforeGroupsMethod() {
     System.out.println("BeforeGroups");
     }

     @Test(groups = "findABug")
     public void testMethodThird() {
     System.out.println("Test #3");
     }
     */

    @Test(groups = {"login", "regression"}, description = "This login tests")
    public void secondTest() {
        System.out.println("I am tests with groups");
    }

    @BeforeGroups("login")
    public void preconditionBeforeGroup() {
        System.out.println("I am creating accounts before login tests");
    }

    @AfterGroups("login")
    public void postConditionAfterGroup() {
        System.out.println("I am deleting accounts after login tests");
    }
}
