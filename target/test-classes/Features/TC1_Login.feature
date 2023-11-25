@Login
Feature: Verifying Adactin Hotel login details

  Scenario Outline: Verifying Adactin Hotel Login Valid
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login success message "Hello manivannan123456!"

    Examples: 
      | UserName         | Password  |
      | MANIVANNAN123456 | 123456789 |

  Scenario Outline: Verifying Adactin Hotel Login Valid by Enter Key
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>" by using Enter key
    Then User should verify after login success message "Hello manivannan123456!"

    Examples: 
      | UserName         | Password  |
      | MANIVANNAN123456 | 123456789 |

  Scenario Outline: Verifying Adactin Hotel Login Invalid credentials
    Given User is on Adaction page
    When User should perform Login "<UserName>","<Password>"
    Then User should verify after login with invalid credentials error message contains "Invalid Login"

    Examples: 
      | UserName         | Password   |
      | MANIVANNAN123456 | 1234567891 |
