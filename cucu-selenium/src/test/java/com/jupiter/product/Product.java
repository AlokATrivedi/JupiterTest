package com.jupiter.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {

	
	private WebElement product;

	public Product(WebElement product)
	{
		this.product = product;
	}
	
	public String getTitle()
	{
		return product.findElement(By.className("product-title")).getText();
	}
	
	public double getPrice()
	{
		return Double.parseDouble(product.findElement(By.className("product-price")).getText().replace("$", ""));
	}
	
	public void clickBuy()
	{
		product.findElement(By.linkText("Buy")).click();
	}
	
	
	
}
