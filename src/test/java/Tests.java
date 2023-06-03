import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Tests {
    @Test
    public static void testCase() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(actualTitle.equals(expectedTitle));
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginBtn.click();

        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "Web Orders";
        Assert.assertEquals(actualTitle1, expectedTitle1);

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'List of All Orders')]"));
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(header.getText(), expectedHeader);

    }

    @Test
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginBtn.click();
        Thread.sleep(1000);

        WebElement viewButton = driver.findElement(By.linkText("View all products"));

        viewButton.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        viewButton = driver.findElement(By.linkText("View all products"));
        Thread.sleep(2000);
        Assert.assertTrue(viewButton.isEnabled());
        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'List of Products')]"));
        String expectedHeader = "List of Products";
        Assert.assertEquals(header.getText(), expectedHeader);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("Products"));

    }

    @Test
    public static void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginBtn.click();
        Thread.sleep(1000);

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        String linkName1 = viewAllOrders.getAttribute("href");
        System.out.println(linkName1);

        WebElement viewAllProducts = driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        String link2 = viewAllProducts.getAttribute("href");
        System.out.println(viewAllProducts.getAttribute("href"));
        WebElement orders = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        String link3 = orders.getAttribute("href");
        Assert.assertTrue(linkName1.contains("Default.aspx"));
        Assert.assertTrue(link2.contains("Products.aspx"));
        Assert.assertTrue(link3.contains("Process.aspx"));

    }

    @Test
    public void Test4() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        loginBtn.click();
        WebElement orderBtn= driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderBtn.click();
        Thread.sleep(2000);
        WebElement screenSaver= driver.findElement(By.tagName("select"));
        Select select = new Select(screenSaver);
        select.selectByValue("ScreenSaver");
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement City = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        City.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zip.sendKeys("60018");
        WebElement cardType = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        cardType.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys("444993876233");
        WebElement expiration = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expiration.sendKeys("03/24");
        WebElement process = driver.findElement(By.cssSelector(".btn_light"));
        Thread.sleep(2000);
        process.click();
        WebElement text = driver.findElement(By.tagName("strong"));
        String expectedText = "New order has been successfully added.";
//
        Assert.assertEquals(text.getText().trim(),expectedText);
        Thread.sleep(2000);
        WebElement viewAllOrders = driver.findElement(By.linkText("View all orders"));
        viewAllOrders.click();
        List<WebElement> ordersActual = driver.findElements(By.xpath("//tr[2]//td"));
        List<String>ordersExpected = Arrays.asList("CodeFish IT School","ScreenSaver","5","06/02/2023","2200 E devon","Des Plaines","Illinois","60018","MasterCard","444993876233","03/24");
        for(int i =1,j=0;i<ordersActual.size()-1;i++,j++){

            System.out.println(ordersActual.get(i).getText());

                Assert.assertEquals(ordersActual.get(i).getText(),ordersExpected.get(j));

            }

        }


    }


