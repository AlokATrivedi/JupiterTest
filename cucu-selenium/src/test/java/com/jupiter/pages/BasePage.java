package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public ContactPage goToContact() {
		driver.findElement(By.id("nav-contact")).click();
		return new ContactPage(driver);
	}
	
	public ShopPage goToShop(){
		driver.findElement(By.id("nav-shop")).click();
		return new ShopPage(driver);
	}
	
	public CartPage goToCart(){
		driver.findElement(By.id("nav-cart")).click();
		return new CartPage(driver);
	}
	
	public int getCartCount(){
		return Integer.parseInt((driver.findElement(By.className("cart-count")).getText()));
	}
}
