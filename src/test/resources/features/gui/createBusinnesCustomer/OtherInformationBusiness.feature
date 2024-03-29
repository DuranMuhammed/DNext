@VFALFT-22209 @regression @otherInformationForBusiness
Feature:New Business Customer-Other Information

  Background:
    Given  I have opened the "Customer Management" application
    Given  I enter a value "gerta.vathi" in the Username or email field on Sign In page
    Given  I enter a value "1234" in the Password field on Sign In page
    Given  I click the Sign in button on Sign In page
    Given  User opens Create Business Customer page on Home page
    ##giriş
    When  User fills in the NIPT field with valid and non-existing  "Y26105375H" on Search Organization page
    Then  User clicks the Search button on Search Organization page
    And   User clicks the Next button on Search Organization page
    Given User clicks Industry dropdown on general information page
    Then  User should selects any option in the Industry dropdown on general information page
    And   User clicks Name Field on general information page
    Then  User enters a value "Leannon" consisting of letters and special characters in the name box on general information page
    Given User clicks Segment dropdown on general information page
    Then  User should selects any options in the Segment dropdown on general information page
    Given User enters valid "ABC@ABC.COM" in to the email field on general information page
    Given User clicks Communication Method dropdown on general information page
    Then  User should selects SMS option in the Tax Exempt dropdown on general information page
    And   User clicks mobile phone numbers field on general information page
    And   User enters mobile valid phone number "698933127" on general information page
    Given User clicks Issuing Date field and user selects "18/03/2024" from calendar on general information page
    And   User adds a "document.jpg" of which format is image on general information page
    Then  User clicks the Next button on general information page
    And   User clicks on the Identification Number field on Admin Information Page
    When  User enters one non existing valid "Z03798271L" ID number into the Identification Number field on Admin Information page
    Then  User should see "Please click search icon!" warning under the Identification Number field on Admin Information Page
    And   User clicks the search icon in Identification Number field after Organization Search on Admin Information page
    And   User  clicks the First Name field and enters the  first name as "Judy" into the First Name field on Admin Information Page
    And   User  clicks the Last Name field and enters the  first name as "Koch" into the First Name field on Admin Information Page
    Given User enters valid "ABC@ABC.COM" in to the email field on  Admin Information Page
    Given User Male option from gender on Admin Information Page
    And   User selects of valid birth date as "18/03/2006" on Admin Information Page
    And   User selects the country as Albania as country of birth on Admin Information Page
    And   User selects Berat as place of birth on Admin Information Page
    And   User adds "623456789" the Mobile Phone  Number into the Mobile Phone Number on Admin Information Page
    And   User add the "document.jpg" and should see the name of file on the screen on Admin Information Page
    And   User clicks next Button on Admin Information Page
    And   User clicks Next button on Contact Information Page
    When  User clicks City dropdown on Address Information Page
    And   User should select "BERAT" option in the City dropdown on Address Information Page
    Then  User enters a value "FIRST ADDRESS" in the Address Line 1 textbox on Address Information Page
    And   User clicks Next button on Address Information Page
    And User enters valid "612345678" into the phone number field on Invoice Account page
    Given User enters valid "ABC@ABC.COM" in to the email field on Invoice Account page
    And   User clicks Next button on Invoice Account page

  @checkFieldsForBusinessOther
  Scenario: As a user I want to Check the Company name, Organization Number and Industry fields
    When User checks the Company Name field on the Other Information page
    Then User should see the values previously entered in the Company Name field on Other Information Page
    When User checks the Organization Number field on the Other Information page
    Then User should see the values previously entered in the Organization Number field on Other Information Page
    When User checks the Industry field on the Other Information page
    Then User should see the values previously entered in the Industry field on Other Information Page

  @clickGenerateFormForBusinessOther
  Scenario: As a user I want to Check and Download the Generate Form
    When User click Generate Form button on the Other Information page
    Then User should see the Generate Form open in a new window
    When User adds a "document.jpg" of which format is image on Other Information page
    Then User should see the name of "document.jpg" added jpg document on the screen on Other Information page

  @createNewUserForBusinessOther
  Scenario: As a user I want to Create New User
    When User click Save button on Other Information Page
    Then User should see Customer Create popup on customer360