Feature: This is a feature where we are practicing parameterization

Scenario: parameteizing the single step
	Given I have numbers 5 and 6
	When I add them
	Then check if the result is prime
	
Scenario: accept word as parameter
 Given I have first name 'avinash pingale'
 Then Print the first name

@Regression @Smoke @avinash
Scenario: Accept list of fruits
	Given I have following fruits:
	|Apple|2|4|
	|Mango|0|5|
	|Strawberry|4|8|
	|Banana|12|67|
	|Papaya|1|4|
	
Scenario Outline: This is my first data driven test case
	Given I have <pincodes>
	Then print the pincode
Examples:
	|pincodes|
	|'411014'|
	|'411015'|
	|'411016'|
	|'411017'|
	|'411018'|
	|'411019'|
	|'411020'|