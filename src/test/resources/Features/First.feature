Feature: User Management

Scenario: Verify if name of already created user populates in the list on User Managment page

	And User is logged into the system
	When User clicks on PIM Menu
	And Click on Add button
	And Creates an user with valid details
	When User clicks on Admin menue
	And Click on Add button on user management page
	When User selects role as ESS
	And Enters employee name
	Then Populated list must contain newly created users name


