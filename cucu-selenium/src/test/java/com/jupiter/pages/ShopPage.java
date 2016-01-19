package com.jupiter.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jupiter.product.CompareProductByTitle;
import com.jupiter.product.ICompareStrategy;
import com.jupiter.product.Product;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private Product getProduct(ICompareStrategy strategy) throws Exception {
		List<WebElement> list = driver.findElements(By.className("product"));
		for (WebElement ele : list) {
			Product product = new Product(ele);
			if (strategy.CompareProduct(product)) {
				return product;
			}
		}
		throw new Exception("No Product found as per comparison");
	}

	public void buyProduct(String productName) throws Exception {
		ICompareStrategy strategy = new CompareProductByTitle(productName);
		getProduct(strategy).clickBuy();
	}

	public void buyProduct(int numberOfProducts) throws Exception {
		List<WebElement> list = driver.findElements(By.className("product"));
		if (list.size() >= numberOfProducts) {
			for (int i = 1; i <= numberOfProducts; i++) {
				Product product = new Product(list.get(i));
				product.clickBuy();
			}
		} else {
			throw new Exception("Not enough products in the Shop Page");
		}
	}

	public List<Product> buyRandomProduct() throws Exception {
		List<WebElement> list = driver.findElements(By.className("product"));
		if (list.size() >= 1) {
			List<Product> productList = new ArrayList<Product>();
			for (int i = 1; i <= list.size(); i = i + 2) {
				Product product = new Product(list.get(i));
				product.clickBuy();
				productList.add(product);
			}
			return productList;
		} else {
			throw new Exception("Not enough products in the Shop Page");
		}
	}

}
