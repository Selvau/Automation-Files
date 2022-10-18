Feature: Verify inteliquent portal

  Background: 
    When User given login credentials
    Then User navigates to the main page

  @Dashboard
  Scenario: Verify local and Toll free count
    Given User fetch the Local and toll free count from dashboard
    Then User verify the Local and toll free count in Numbers module

  @Local_Number
  Scenario: Verify user can add new Local number
    Given User navigates to "Numbers" module
    When User click the "Local Numbers" module
    Then User stores the numbers count
    And User click the add numbers
    And User click the search button
    And User select the number and click Buy Number button
    And User enter the emergency contact "Test QA "
    And User enter the Street number "7460"
    And User enter the Street name "Warren pkwy"
    And User enter the city "Frisco"
    And User enter the zipcode "75034"
    And User select the country "US"
    And User select the state "TX"
    And User click the validate button
    Then User click the ok button
    And User enter Outbound caller Name "AutomationQA"
    Then User click the placeorder button
    Then User fetch the ordered number

  @Toll_Free_Number
  Scenario: Verify user can add new Toll free number
    Given User navigates to "Numbers" module
    When User click the "Toll Free Numbers" module
    Then User stores the numbers count
    And User click the add numbers
    And User click the search button
    And User select the number and click Buy Number button
    And User enter the emergency contact "Test QA "
    And User enter the Street number "7460"
    And User enter the Street name "Warren pkwy"
    And User enter the city "Frisco"
    And User enter the zipcode "75034"
    And User select the country "US"
    And User select the state "TX"
    And User click the validate button
    Then User click the ok button
    And User enter Outbound caller Name "Localqa"
    Then User click the placeorder button

  @return/restorenumbers
  Scenario: Local return/restore credentials
  #Given User navigates to number screen
  #When User click the ordered local number
  #And User change enable to disable E911 services
  #And User change enable to outbount caller name
  #And User change enable to international features
  #And User click the return number
  #Then User click the return
  
  @verifyorders
  Scenario: Fetch order number and filtered in numbers
    Given User navigates to "Numbers" module
    Then User fetch the order number
    Then User navigates to "Orders" module
    Then User apply the filter

  @History
  Scenario: History credentials
    Given User navigates to the history screen
    When User verify the widget title
    And User stores the history count

  @user
  Scenario: User credentials
    Given User navigates to the user screen
    When User stores the user count
    And User click the filter tab
    And User enter the First name "Test"
    And User enter the Last name "QA"
    And User enter the Email "selva.manikandan@inteliquent.com"
    And User click the Status "All"
    Then User click the Filter button
  @profile
  Scenario: Profile setup
   Given User navigates to the profile tab
   And User click the Myprofile subtab 
   When User verify the Widget title "PROFILE"
   Then User click the Update button 
   And User get the successfully message
   And User enter the current password "P@ssc0de" 
   And User enter the New password "P@ssc0de"
   And User enter the confirm New password "P@ssc0de"
   Then User click change password 
   And User upload the profile picture
   Then User click the upload picture
