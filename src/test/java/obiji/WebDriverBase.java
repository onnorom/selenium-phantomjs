package obiji;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;

public class WebDriverBase {

  static protected WebDriver driver;

  public static void setup() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "src/test/resources/drivers/phantomjs");

    driver = new PhantomJSDriver(caps);
  }

  public static void main(String[] args) {
    WebDriverBase.setup();
    driver.get("https://www.testingexcellence.com");
    String pageTitle = driver.getTitle();
    System.out.println("Page opened: {} "+pageTitle);
    driver.quit();
  }
}
