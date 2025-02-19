package com.liuhuang.fitness.VO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebTest {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        try {
            driver.get("http://localhost:8080/login");
            System.out.println("Title of page:" + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}