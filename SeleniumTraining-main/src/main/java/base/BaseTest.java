package base;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.lang.reflect.Method;


public class BaseTest {

    protected WebDriver driver;
    protected Logger log;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser,
                      @Optional String deviceName, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();

        log = LogManager.getLogger(testName);


        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);

        driver = factory.createDriver();
        driver.manage().window().maximize();

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
