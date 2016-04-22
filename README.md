# automation-challenge

In this public repository you will find a test to join TFG automation team.


## Requirements:

1. Fork this repository to your Github account

2. Install and setup Android Studio

3. Install and setup a test automation framework 


## Instructions:

1. Create a list with all the scenarios to test this app

2. Write the automated scripts based on the scenarios you created in the previous steps

3. Create a report with the test results

4. Don't forget to create a file containing the instructions to run your tests

5. Commit everything into your repository

6. Send your repository link to recruiting@tfgco.com

##Test Cases

1. Test case - Validating bill total with percentage change of (5%)
Steps: The test script changes the tip to 5% and calculates the bill total with success.
Expected result: bill successfully calculated

2. Test case - Validating bill total with percentage change of (10%)
Steps: The test script changes the tip to 10% and calculates the bill total with success.
Expected result: bill successfully calculated

3. Test case - Calculate the value of the empty bill
Steps: The test script keeps the bill field empty and activates the button calculate tip.
Expected result: There was no change in values. The data entered is invalid.

4. test case - Calculate 0 dolar bill
Steps: The test script inserts a zero value and clicks on calculate tip.
Expected result: There was no change in values. The data entered is invalid.

5. test case - Calculate tip with a negative value
Steps: The test script inserts a negative value on the bill field.
Expected result: Application calculates the bill and tip total with negative values.

6. test case - Validating percentage change to 0%
Steps: The test script changes the tip percentage to zero and calculates a new value.
Expected result: Application calculates the bill total successfully and the total tip with a value of zero.

7- test case - Validating value with a special character
Steps: The test script inserts a special character and calculates the bill.
Expected result:There was no change in values. The data entered is invalid.

8- test case - Validating letters and numbers input
Steps: The test script enter letters and numbers and calculates the bill.
Expected result:The application calculates successfully and does not make use of the input letters.

9- Test case - Validating letters and numbers on the percentage of tip
Steps: The test script enter letters and numbers in the percentage field , save and execute a new calculation.
Expected result:The application calculates successfully and does not make use of the input letters.

10- Test case - Validating percentage null
Steps: The test script validates critical message to leave the field empty percentage.
Expected result: Application remains on the same screen , the percentage is mandatory.

## Run tests:

1. Import project
2. In the upper vertical menu select the combobox, select run\Debug Configuration
3. Select Edit Configuration
4. Select (+) Add new configutarion
5. Select Android tests
6. You can put any name
7. Select Module > app
8. in the field Specific instrumetation runner (opcional) copy and paste > android.support.test.runner.AndroidJUnitRunner
9. Apply and Ok
10. In the upper vertical menu select the created configuration and play.
11. Or test run for
Access the project in the app folder > src > java > org.traeg.fastip
Select right MainActvityTest the class and then Run ActivityTest


