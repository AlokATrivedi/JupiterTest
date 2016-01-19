package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends ContactPage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void selectCardType(String type) {
		WebElement cardType = driver.findElement(By.id("cardType"));
		Select select = new Select(cardType);
		select.selectByValue(type);
	}

	public void setCardNumber(String cardNumber) {
		WebElement card = driver.findElement(By.id("card"));
		card.sendKeys(cardNumber);
	}

	public void setAddress(String address) {
		WebElement addressDetail = driver.findElement(By.id("address"));
		addressDetail.sendKeys(address);

	}

	public void clickCheckoutSubmit() {
		driver.findElement(By.id("checkout-submit-btn")).click();

	}
}
