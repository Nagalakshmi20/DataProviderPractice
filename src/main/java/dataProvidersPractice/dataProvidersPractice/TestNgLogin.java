package dataProvidersPractice.dataProvidersPractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestNgLogin {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","D:\\lakshmi\\library\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://www.demo.guru99.com/v4/");
		
		
	}
	@DataProvider
	public Object[][] getLoginData() throws IOException
	{
		XlsReader re=new XlsReader();
		Object data[][]=re.ReadData();
			return data;
				
			
		}
	@Test
	public void login()
	{
		
	}
	@Test(dataProvider= "getLoginData")
	public void Loginpage(String uname,String pword) throws InterruptedException,NullPointerException
	{
		System.out.println("hellow world");
		System.out.println("unameis ::"+uname);
		System.out.println("Password is ::"+pword);
		Thread.sleep(20);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("asdfasd");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}
	
	 @AfterMethod
	    public void tearDown() throws Exception {
	        driver.quit();
}
}
