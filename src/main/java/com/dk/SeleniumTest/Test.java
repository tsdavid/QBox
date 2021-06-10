package com.dk.SeleniumTest;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Reference : https://heodolf.tistory.com/103
 */
public class Test {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        try{
            System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        }catch (Exception e){
            System.out.println("System set properties Error");
            e.printStackTrace();
        }


        WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        String baseUrl = "https://partner.booking.naver.com/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // Wait Untill Reach Specific URL.
        String targetUrl = "https://partner.booking.naver.com/bizes/162405/booking-calendar-view";
        int cnt = 0;
        while(true){
            if(driver.getCurrentUrl().equals(targetUrl)){
                System.out.println(cnt);
                break;
            }
            try{
                Thread.sleep(5000);
                cnt++;
            }catch (Exception e){

            }
        }
        System.out.println("Get Target Url. Then Let's work ");

        //Change status
        //get booking list view url
        String BookListViewUrl = "https://partner.booking.naver.com/bizes/162405/booking-list-view";
        driver.get(BookListViewUrl);

        // Select element.
        driver.findElement(By.id("dropdownBookingStatus")).click(); // 예약상태
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[3]")).click();


        // get the actual value of the title
        actualTitle = driver.getTitle();


        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.quit();
        driver.close();

    }
}
