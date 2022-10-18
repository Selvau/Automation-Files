
Feature: Verify portal login 
  
 @Test1
  Scenario: Login credentials
   Given User navigates into ccp portal
   When  User given login credentials
   Then  User verify the "Admin" text
   Then  User verify the "DASHBOARD" text
   Then  User verify the "Toll Free Number(s) Count" text
   Then  User verify the "Local Number(s) Count" text
  