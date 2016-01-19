package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jupiter.ui.HtmlTable;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public HtmlTable getCartItems() {
		WebElement element = driver.findElement(By.className("cart-items"));
		HtmlTable table = new HtmlTable(element);
		return table;
	}

	public double getPrice(String productName) throws Exception {

		return Double.parseDouble(getCartItems().getCellValue("Item", productName, "Price").getText().replace("$", ""));
	}

	public double getSubTotal(String productName) throws Exception {

		return Double.parseDouble(getCartItems().getCellValue("Item", productName, "Subtotal").getText().replace("$", ""));
	}

	public double getTotal() throws Exception {

		return Double.parseDouble(driver.findElement(By.className("total")).getText().replace("Total: ", ""));
	}

	public int getQuantity(String productName) throws Exception {

		WebElement quantity = getCartItems().getCellValue("Item", productName, "Quantity");
		return Integer.parseInt(quantity.findElement(By.name("quantity")).getAttribute("value"));
	}

	public void removeItem(String itemName) throws Exception {
		WebElement removeButton = getCartItems().getCellValue("Item", itemName, "Actions");
		removeButton.findElement(By.className("remove-item")).click();

	}

	public void removeItem(int index) throws Exception {
		WebElement removeButton = getCartItems().getRowByIndex(index).findElement(By.className("remove-item"));
		removeButton.click();

	}

	public CheckOutPage goToCheckOut() {
		driver.findElement(By.linkText("Check Out")).click();
		return new CheckOutPage(driver);
	}

	public void clickEmptyCart() {
		driver.findElement(By.linkText("Empty Cart")).click();

	}

	public void clickYes() {
		driver.findElement(By.linkText("Yes")).click();
	}

	public void clickNo() {
		driver.findElement(By.linkText("No")).click();
	}

	public void verifyCartItems() {

	}
}
