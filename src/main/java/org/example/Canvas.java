package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Canvas  {

   private static ChromeOptions options = new ChromeOptions();

    private static WebDriver driver = new ChromeDriver(options.addArguments("--headless"));

    private static String canvasEmail ;
    private static  String canvasPassword  ;
    Canvas(LoginInformation information){
            canvasEmail = information.getEmail();
            canvasPassword = information.getPassword();
        }

    public static String getCanvasEmail() {
        return canvasEmail;
    }
    public static String getCanvasPassword() {
        return canvasPassword;
    }
    public static void Login(){
        String url = "https://login.microsoftonline.com/80a45edc-d5ee-46e0-9d75-37c47be9b7cc/reprocess?ppt=select_account&sosid=76111c60-ad53-4500-baad-6d153155ad0d&ctx=rQQIARAA42KwUsgoKSmw0tdPSy3Vy8wrLikqTS4pLUrVS87P1S9OzM0xKhLiEvhkcUclMeyQY4MuU5Nwj0TDKkYdkLZiiL7kxLyyxGIM3Tn56Zl5YDMOMarGm5gmphkaWRjqpqWkpeqamJmm6CYaJRvqWpgmmhokppkkpRimXWBkfMHIeIuJNRhk8S8m09KiPKv8xOLMYqu8xNzUYquSZKtgR18fK0M9Q7BIZopuWn5RbmKJVWlecUFqcmZaZmrKJmYVC4NEE9PUlGTdFNNUkGWpBrqWKeamusbmySbmSamWSebJyY-YpRONDIwMDQ1MDC0dEN5ITSnVK8jYwMJ4gYXnFQuPAbMVBweXAIMEgwLDDxbGRazA4JjPUn122bpqt-kSs2btq_BnOMWqH-nlHBBmWKAfFuSbVJXobO5bZRZZXuxtEhpaWWaQkRiWVljlmpYfUlVplmxraGU4gY33FBvDBzamDnaGWewMuzhJCs8DvAw_-E58nt52d8_htx4A0";
        driver.get(url);
        WebElement login = waitForElement(By.id("i0116"));
        login.sendKeys(getCanvasEmail());
        WebElement submit = waitForElement(By.id("idSIButton9"));
        submit.click();
        login = waitForElement(By.id("i0118"));
        login.sendKeys(getCanvasPassword());
        submit = waitForElement(By.id("idSIButton9"));
        submit.click();
        submit = waitForElement(By.id("idSIButton9"));
        submit.click();

    }
    public static String analyticsAnnouncement(){
        Login();
        driver.get("https://feucanvas.instructure.com/courses/82225/announcements");
        WebElement announcement = waitForElement(By.xpath("//*[@id=\"content\"]/div/span[3]/div[1]/div[2]/a[1]/div"));
        announcement.click();
        String text = driver.findElement(By.xpath("//*[@id=\"discussion_topic\"]/div[1]/div")).getText();
        return text ;
    }

    public static WebElement waitForElement (By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4L));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));

    }


}
