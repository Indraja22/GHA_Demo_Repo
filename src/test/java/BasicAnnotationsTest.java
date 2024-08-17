import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotationsTest {

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("I run before the first test method in the current class!");
    }

    @Test
    public void sampleTest(){
        System.out.println("I am a Test!");
    }

    @BeforeMethod
    public void beforeTestMethod(){
        System.out.println("I run before each test method!");
    }

    @AfterMethod
    public void afterTestMethod(){
        System.out.println("I run after each test method");
    }


}
