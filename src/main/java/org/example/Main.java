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


    public static void main(String[] args) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        boolean checkConnection = hasConnected();
        while (!checkConnection) {
            checkConnection = hasConnected();
        }
        Canvas canvas = new Canvas(new LoginInformation());

       String link = findZoomLink(canvas.analyticsAnnouncement());
        openLink(link);

    }

        public static void openLink (String link){
            Desktop desk = Desktop.getDesktop();

            try {
                desk.browse(new URI(link));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        public static String findZoomLink(String link){
                String temp = link.substring(link.indexOf("https"),link.lastIndexOf(" ")).trim();
                String temp2= temp.substring(0, temp.indexOf("\n"));
            if(temp2.contains("L")){
                temp2= temp2.substring(0, temp2.indexOf("L"));
            }
            return temp2;
        }
        public static boolean hasConnected () throws MalformedURLException {
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


