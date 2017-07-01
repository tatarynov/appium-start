package testng_examples;

import org.testng.annotations.*;

public class TaskThree {

    /***
     *
     Create test class and use in it following annotations:

     @BeforeSuite
     @AfterSuite
     @BeforeTest
     @AfterTest

     // Example

     @BeforeSuite
     public void beforeSuiteMethod() {
     System.out.println("BeforeSuite");
     }

     @AfterSuite
     public void afterSuiteMethod() {
     System.out.println("AfterSuite");
     }

     @BeforeTest
     public void beforeTestMethod() {
     System.out.println("BeforeTest");
     }

     @AfterTest
     public void afterTestMethod() {
     System.out.println("AfterTest");
     }
     */

    @Test
    public void taskThreeTest() {
         System.out.println("This is third test!");
    }

     @BeforeSuite
     public void preConditions() {
          System.out.println("Before suite!");
     }

     @BeforeTest
     public void preConditionsBeforeTest() {
          System.out.println("Before Test!");
     }

     @AfterTest
     public void preConditionsAfterTest() {
          System.out.println("After Test!");
     }

     @AfterSuite
     public void preConditionsAfterSuite() {
          System.out.println("After Suite!");
     }

}
