package testng_examples.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider
    private Object[][] credentials() {
        return new Object[][]{
                {"user1@gmail.com", "Password11"},
                {"user2@gmail.com", "Password22"},
                {"user3@gmail.com", "Password33"},
                {"user4@gmail.com", "Password44"}
        };
    }

    @Test(dataProvider = "credentials")
    public void login(String username, String password) {
        System.out.println("Login with: " + username);
        System.out.println("Password for this login: " + password);
        System.out.println("");
        System.out.println("");
    }
}
