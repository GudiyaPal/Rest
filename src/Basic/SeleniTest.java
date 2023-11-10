package Basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniTest {
	
	
	public static void main(String[] args) throws IOException, SQLException  {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("");
		Properties prop=new Properties();
		prop.load(fis);
		prop.getProperty("username");
				
//		System.setProperty("webdriver.chrome.driver", "");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("");
		String st1=driver.getCurrentUrl();
		String st2=driver.getPageSource(); //text of the page
		String st3=driver.getTitle();
		
		driver.navigate().to("");
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().back();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wat=new WebDriverWait(driver,Duration.ofSeconds(5));
		wat.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(st3)));
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(null);
//		WebElement we=wait.until(new Function<WebDriver,WebElement>());
		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		String aim="";
		WebElement el=driver.findElement(By.xpath(aim));
		driver.switchTo().frame(1);
		driver.switchTo().frame(aim);
		driver.switchTo().frame(el);
		driver.switchTo().defaultContent();
		
		Select drop=new Select(el);
		drop.selectByIndex(1);
		drop.deselectByValue(aim);
		drop.deselectByVisibleText(aim);
		List<WebElement> opt=drop.getOptions();
		
		Set<String> st=driver.getWindowHandles();
		for(String win:st)
			driver.switchTo().window(win);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sor=ts.getScreenshotAs(OutputType.FILE);
		File Targ=new File("");
		FileUtils.copyFile(sor, Targ);
		
		Actions act=new Actions(driver);
		act.moveToElement(el).doubleClick().contextClick().click(el).build().perform();
		act.dragAndDrop(el, el).keyDown(Keys.SHIFT).build().perform();
		act.clickAndHold(el).moveToElement(el).release().build().perform();
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("windows.scrollBy(0,500)");
		js.executeScript("document.getElementByid('')");
		js.executeScript("document.querySelector('')");
		
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setExperimentalOption("excludeschedule", Arrays.asList("disable pop-up blocking"));
		
		HashMap<String,String> map= new HashMap<String,String>();
		map.put("Download default Dir", "");
		options.setCapability("Map", map);
		Proxy pro=new Proxy();
		pro.setHttpProxy("HEAD");
		
//		HttpsURLConnection conn=(HttpsURLConnection) new URL(url).openConnection();
//		conn.setRequestMethod(aim);
//		conn.connect();
//		conn.getResponseCode();
		
		Connection db=DriverManager.getConnection(aim);
		Statement st4=db.createStatement();
		ResultSet rs=st4.executeQuery("");
		
		
	}
		
}
