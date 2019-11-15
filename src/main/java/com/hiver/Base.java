package com.hiver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {


        protected static Properties prop;
        protected static WebDriver driver;
        protected static Actions actions;
        protected static WebDriverWait wait;

        public Base(){
            try {
                prop = new Properties();
                FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources"
                        + "/config.properties");
                prop.load(ip);
            } catch (FileNotFoundException e) {
                // We should ideally log error but here just printing the exception
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        protected static void initialization(){
            String browserName = prop.getProperty("browser");

            if(browserName.equals("chrome")){
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
            }
            else if(browserName.equals("firefox")){
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
            }
            driver.manage().deleteAllCookies();
            driver.get(prop.getProperty("url"));
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, 5);
        }

//	public static Actions getActions() {
//		return action;
//	}
}
