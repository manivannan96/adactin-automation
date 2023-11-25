
@search
Feature: Verifying Adactin Search Hotel details

  Scenario Outline: Verifying Adactin Search Hotel page and Verify Select Hotel message
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"
    And User should enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>","<Children per Room>" and User should click on Search Box
    Then User should verify after Search success message "Select Hotel"

    Examples: 
      | UserName         | Password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | MANIVANNAN123456 | 123456789 | Sydney   | Hotel Creek | Standard  | 1 - One         | 17/11/2022    | 18/11/2022     | 1 - One         | 0 - None          |

  Scenario Outline: Verifying Adactin Search Hotel page with Mandatory fields and Verify Select Hotel message
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"
    And User should enter only Mandatory field "<Location>",,"<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>" and User should click on Search Box
    Then User should verify after Search success message "Select Hotel"

    Examples: 
      | UserName         | Password  | Location | Number of Rooms | Check In Date | Check Out Date | Adults per Room |
      | MANIVANNAN123456 | 123456789 | Sydney   | 1 - One         | 17/11/2022    | 18/11/2022     | 1 - One         |

  Scenario Outline: Verifying Adactin Search Hotel page,giving wrong Dates and Verfying the date error message
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"
    And User should enter "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>","<Children per Room>" and User should click on Search Box
    Then User should verify after Search error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | UserName         | Password  | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | MANIVANNAN123456 | 123456789 | Sydney   | Hotel Creek | Standard  | 1 - One         | 26/11/2022    | 25/11/2022     | 1 - One         | 0 - None          |

  Scenario Outline: Verifying Adactin Search Hotel page without giving any details and click on search and verifying error message
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"
    And User should click on Search Box without enter any field and click on Search
    Then User should verify after Search error message "Please Select a Location"

    Examples: 
      | UserName         | Password  |
      | MANIVANNAN123456 | 123456789 |
