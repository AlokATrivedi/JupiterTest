
Feature: Submit a Feedback
As a User I should be
able to submit a feedback

Background: 
	Given that I am in Contact page

Scenario: User need to fill mandatory fields
	When I do not fill all mandatory fields
	Then I should not be able to Submit my feedback

Scenario: User successfully submits feedback
	When I fill all the mandatory fields
	Then I should be able to submit my feedback  