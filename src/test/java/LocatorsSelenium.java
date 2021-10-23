import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsSelenium {
    @Test
    public void findByIdTest()  {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://contributor-accounts.shutterstock.com/");
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        WebElement inputFieldLogin = driver.findElement(By.id("login-username"));
        inputFieldLogin.sendKeys("test123456");
        inputFieldLogin.submit();

        WebElement inputFieldPassword = driver.findElement(By.id("login-password"));
        inputFieldPassword.sendKeys("test12345");
        inputFieldPassword.submit();
        System.out.println("Test findByIdTest :The test finds the required ID fields and enters information into them");

        Actions actions = new Actions(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void findByTagNameTest()  {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://akniga.org/");
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.tagName("iframe"));
        List<WebElement> listFrame = driver.findElements(By.tagName("iframe"));
        System.out.println("Count frame : " + listFrame.size());
        System.out.println("Test findByTagNameTest: The test finds the required frame tag and counts the number of items");
        
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.close();
            }



    @Test
    public void findByLinkTest()  {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.shutterstock.com/g/Zaretsky?rid=181467612");
        driver.manage().window().maximize();
        WebElement buttonNext = (new WebDriverWait(driver,5))
                .until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Далее")));
        buttonNext.click();
        System.out.println("Test findByLinkText: The test finds the necessary" +
                " link for the \"Далее\" button, clicks on the button and goes to the next page");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void findByCssSelectorTest()  {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://akniga.org/");
        driver.manage().window().maximize();
        WebElement svgPicture=driver.findElement(By.cssSelector("html body div[class='container__main'] a svg"));
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("html body div[class='container__main'] a svg")));

        System.out.println("Test findByCssSelectorTest: The test finds a code element" +
                " according to the given css selectors path");

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void findCssSelectorChildElementTest()  {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://akniga.org/");
        driver.manage().window().maximize();
        WebElement buttonLink=driver.findElement(By.cssSelector("div>a[href='https://akniga.org/paid/']"));;
        WebDriverWait wait=(new WebDriverWait(driver,5));
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div>a[href='https://akniga.org/paid/']")));
        buttonLink.click();

        System.out.println("Test findByCssSelectorTest: The test finds a code element" +
                " according to the given css selectors path");

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void findByXpathTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://akniga.org/");
        driver.manage().window().maximize();
        WebDriverWait waiter=new WebDriverWait(driver,10);
        List<WebElement> listSpan = waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span")));
        System.out.println("Count Span : " + listSpan.size());
        System.out.println("Test findByXpathTest: " +
                "The test finds the required elements tag and counts the number of items");

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void findByXpathAttributeTest()  {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.shutterstock.com/g/Zaretsky");
        driver.manage().window().maximize();
        WebDriverWait waiter=new WebDriverWait(driver,15);
        WebElement searchByAttribute;
        List<WebElement> listByAttributeAlt=driver.findElements
                (By.xpath("img[@alt='Shocked cat looks with open mouth at dollar signs']"));
        System.out.println("Test findByXpathAttributeTest: The test finds the required alt attribute Image");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.close();
    }
    @Test
    public void findByXpathTextTest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.shutterstock.com/g/Zaretsky");
        driver.manage().window().maximize();
        WebElement searchByText=driver.findElement(By.xpath("//*[text()='Информация']"));
        WebDriverWait wait=(new WebDriverWait(driver,5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Информация']")));
        searchByText.click();
        System.out.println("Test findByXpathTextTest: The test found the 'Information' button and opened the page");

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.close();
    }

}