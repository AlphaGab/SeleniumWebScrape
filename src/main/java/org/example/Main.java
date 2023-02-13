package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.*;
import java.time.Duration;
import java.awt.*;



public class Main {
    static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        boolean checkConnection = hasConnected();
        while (!checkConnection) {
            checkConnection = hasConnected();
        }
            LoginInformation myAccount = new LoginInformation();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            try {
                driver.get("https://feucanvas.instructure.com/courses/82225/announcements");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            WebElement login = waitForElement(By.id("i0116"));
            login.sendKeys(myAccount.getEmail());
            WebElement submit = waitForElement(By.id("idSIButton9"));
            submit.click();
            login = waitForElement(By.id("i0118"));
            login.sendKeys(myAccount.getPassword());
            submit = waitForElement(By.id("idSIButton9"));
            submit.click();
            submit = waitForElement(By.linkText("Use a different account"));
            submit.click();
            submit = waitForElement(By.cssSelector("#tilesHolder > div.tile-container > div > div.table"));
            submit.click();
            submit = waitForElement(By.xpath("//*[@id=\"content\"]/div/span[3]/div[1]/div[2]/a[1]/div"));
            submit.click();
            String text = driver.findElement(By.xpath("//*[@id=\"discussion_topic\"]/div[1]/div")).getText();
            System.out.println(text);
            driver.quit();
        }

        public static WebElement waitForElement (By selector){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4L));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));

        }
        public static void openLink (String link){
            Desktop desk = Desktop.getDesktop();

            try {
                desk.browse(new URI(link));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        public static boolean hasConnected() throws MalformedURLException {
            String host = "https://google.com";
            URL url = new URL(host);
            boolean status = true;

            try {
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.connect();
                System.out.println("Connected");
                con.disconnect();


            } catch (Exception e) {
                status = false;
            }
            return status;
        }

    }



