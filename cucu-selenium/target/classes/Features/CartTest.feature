
Feature: Products in Cart Page
As a User when I buy products
I should be able to see the Products in cart

Background:
	Given User has selected few products to buy
	When user navigates to cart Page

Scenario:  Products in the Cart
	Then all products should be displayed in cart
		

Scenario: Remove a product
	Then user can remove a product

Scenario: Empty Cart
	Then user can empty the cart

Scenario: Checkout the products	
	And user checksOut the products
	Then user should be able to checkout the cart
	