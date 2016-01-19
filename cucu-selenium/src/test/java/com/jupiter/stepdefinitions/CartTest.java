package com.jupiter.stepdefinitions;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.jupiter.pages.BasePage;
import com.jupiter.pages.CartPage;
import com.jupiter.pages.CheckOutPage;
import com.jupiter.pages.ShopPage;
import com.jupiter.product.Product;

import cucumber.api.java.en.*;

public class CartTest {
	protected WebDriver driver;

	public CartTest(SharedDriver driver) {
		this.driver = driver;
	}
	List<Product> product;
	@Given("^User has selected few products to buy$")
	public void user_has_selected_few_products_to_buy() throws Throwable {
		BasePage base = new BasePage(driver);
	    ShopPage shop= base.goToShop();
	    this.product= shop.buyRandomProduct();
		
	}

	@When("^user navigates to cart Page$")
	public void user_navigates_to_cart_Page() throws Throwable {
		BasePage base = new BasePage(driver);
		base.goToCart();
		
	}

	@Then("^all products should be displayed in cart$")
	public void all_products_should_be_displayed_in_cart() throws Throwable {
		 CartPage cart =new CartPage(driver);
		    int CartCount= cart.getCartCount();
		    Assert.assertEquals(CartCount, cart.getCartItems().getTableSize());
		    if(this.product.size()==cart.getCartItems().getTableSize())
		    {
		    	
		    	for(Product pro: this.product)
		    	{
		    		Assert.assertEquals(pro.getTitle(),cart.getCartItems().getCellValue("Item", pro.getTitle(), "Item"));
		    		Assert.assertEquals(pro.getPrice()*cart.getQuantity(pro.getTitle()),cart.getSubTotal(pro.getTitle()),0.001);
		    		double SubTotal=+cart.getSubTotal(pro.getTitle());
		    		Assert.assertEquals(cart.getTotal(), SubTotal,0.001);
		    				    		
		    	}
		    }
		
	}

	@Then("^user can remove a product")
	public void user_can_remove_a_product() throws Throwable {
		CartPage cart = new CartPage(driver);
		cart.removeItem(1);
		cart.clickYes();		
	}

	@Then("^user can empty the cart$")
	public void user_can_empty_the_cart() throws Throwable {
		CartPage cart = new CartPage(driver);
		cart.clickEmptyCart();
		cart.clickYes();
		
	}

	@When("^user checksOut the products$")
	public void user_checksOut_the_products() throws Throwable {
		CartPage cart = new CartPage(driver);
		cart.goToCheckOut();
		
	}

	@Then("^user should be able to checkout the cart$")
	public void user_should_be_able_to_checkout_the_cart() throws Throwable {

		CheckOutPage checkOutPage = new CheckOutPage(driver);
		checkOutPage.setForenameValue("Testing");
		checkOutPage.setEmailValue("testing@abcedasdsad.com");
		checkOutPage.setAddress("Address one");
		checkOutPage.selectCardType("Visa");
		checkOutPage.setCardNumber("1421 4512 0000 0000 0000");
		checkOutPage.clickCheckoutSubmit();
		checkOutPage.waitForSuccessFeedbackMessageToLoad(15);
	}

}
