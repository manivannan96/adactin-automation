

@cancel
Feature: Verifying Adactin Cancel Booking details

  Scenario Outline: Verifying Adactin Search Hotel page and Cancel the current Order Id
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"
    And User should enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>","<Children per Room>" and User should click on Search Box
    Then User should verify after Search success message "Select Hotel"
    And User should Select a Hotel and Click on Continue
    Then User should verify after Continue Success message "Book A Hotel"
    And User should Book Hotel "<First Name>","<Last Name>" and "<Billing Address>"
      | Credit Card No   | Credit Card Type | Select Month | Select Year | CVV Number |
      | 1234567890123456 | VISA             | October      |        2022 |       1234 |
      | 8563767890123456 | American Express | December     |        2022 |       8564 |
      | 1698637890123456 | Master Card      | November     |        2022 |       7439 |
    Then User should verify after Booking Success message "Booking Confirmation" and Save the Order Id
    And User Should cancel the current Order Id
    Then User Should verify After cancel Order Id success message "The booking has been cancelled."

    Examples: 
      | UserName         | Password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | First Name | Last Name | Billing Address |
      | MANIVANNAN123456 | 123456789 | Sydney   | Hotel Creek | Standard  | 1 - One         | 17/11/2022    | 18/11/2022     | 1 - One         | 0 - None          | Cristiano  | Ronaldo   | Portugal        |

  Scenario Outline: Verifying Adactin Search Hotel page and Cancel the Existing Order Id
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"
    And User Should cancel the Existing "<Order Id>"
    Then User Should verify After cancel Order Id success message "The booking has been cancelled."

    Examples: 
      | UserName         | Password  | Order Id   |
      | MANIVANNAN123456 | 123456789 | 325T878ZJ2 |
