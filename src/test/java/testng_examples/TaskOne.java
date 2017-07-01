package testng_examples;

import org.testng.annotations.*;

public class TaskOne {

    /***
     * Create test class and use in it following annotations:

     @Test
     @BeforeClass
     @AfterClass
     @BeforeMethod
     @AfterMethod


     // Example

     @BeforeClass
     public void beforeClass() {
        System.out.println("I will print something before class");
     }

     @AfterMethod
     public void afterMethodPrint() {
        System.out.println("I will printh something after method");
     }
     */

    @Test
    public void myFirstTest() {
        System.out.println("This is my first test!");
    }

    @Test(groups = "login", enabled = false)
    public void mySecondTest() {
        System.out.println("This is my second test!");
    }

    @BeforeMethod
    public void preConditions() {
        System.out.println("This preconditions before Method");
    }

    @BeforeClass
    public void preConditionsBeforeClass() {
        System.out.println("This preconditions before Class");
    }

    @AfterMethod
    public void preConditionsAfterMethod() {
        System.out.println("This preconditions after Method");
    }

    @AfterClass
    public void preConditionsAfterClass() {
        System.out.println("This preconditions after Class");
    }



}
