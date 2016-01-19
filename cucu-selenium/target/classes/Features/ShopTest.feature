@wip
Feature: Buy a Product in Shop Page

Scenario:  Buy a Product
	Given User is on Home Page
	When user navigates to Shop Page to buy few products
	Then cart count should get updated
	
