package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws MalformedURLException {

		logger= LogManager.getLogger(this.getClass());

		try {
			FileReader file = new FileReader("./src/test/resources/config.properties");
			p= new Properties();
			p.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities= new DesiredCapabilities();

			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else {
				System.out.println("No Matching OS");
				return;
			}

			switch(br.toLowerCase()) {

			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("Invalid browser name");
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

		}

		if(p.getProperty("execution_env").equalsIgnoreCase("local")){
			switch(br.toLowerCase()){
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			default: System.out.println(" Invalid browser name"); return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"sanity","regression","master"})
	public void teardown() {
		driver.close();
	}


	public String randomString() {
		String generatedString= RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedNumber= RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumeric() {
		String alphaNumeric= RandomStringUtils.randomAlphanumeric(3);
		return (alphaNumeric+"@"+alphaNumeric);
	}

	public String captureScreen(String name)  throws IOException{

		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File sourceFile= screenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+  name + "_"+ timeStamp + ".png";

		File targetFile= new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}


}
