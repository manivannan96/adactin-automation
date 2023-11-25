
@select
Feature: Verifying Adactin Select Hotel details

  Scenario Outline: Verifying Adactin Search Hotel page,Verifying Select Hotel message,Click on Select hotel and then Click on continue
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"
    And User should enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>","<Children per Room>" and User should click on Search Box
    Then User should verify after Search success message "Select Hotel"
    And User should Select a Hotel and Click on Continue
    Then User should verify after Continue Success message "Book A Hotel"

    Examples: 
      | UserName         | Password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | MANIVANNAN123456 | 123456789 | Sydney   | Hotel Creek | Standard  | 1 - One         | 17/11/2022    | 18/11/2022     | 1 - One         | 0 - None          |

  Scenario Outline: Verifying Adactin Search Hotel page,Verifying Select Hotel message and Click on continue without Select a Hotel
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"
    And User should enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>","<Children per Room>" and User should click on Search Box
    Then User should verify after Search success message "Select Hotel"
    And User should Click on Continue without Selecting a Hotel
    Then User should verify after Continue Error message "Please Select a Hotel"

    Examples: 
      | UserName         | Password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | MANIVANNAN123456 | 123456789 | Sydney   | Hotel Creek | Standard  | 1 - One         | 17/11/2022    | 18/11/2022     | 1 - One         | 0 - None          |
