@SmokeFeature
Feature: Student Creation

  Background:
    Given user is on login page
    
    #When user enters username invalid "admin@" and invalid password "asdga@#56"
    When user enters valid username "admin@gmail.com" and valid password "admin@2025#"
    And clicks on the login button
    Then admin can view Dashboard

  @smoketest
  Scenario: QR System student
    When admin click on Student Details
    And click on add student button
    Then user can view add new student page
    When user enter student info
    And click on save button
    And click on cancel button

  #@smoketest
  #Scenario: ID card Page
    When click on IDMenu
    Then click on search field and enter email
    And searching student email Id in table
    And click on view IdCard button
    And download IdCard PDF

#  @smoketest
 # Scenario: College Page
    When click on College Menu	
    And click on searchbox text and enter email
    Then user searching email in table
    And click on college profile edit button
    Then enter information in field
     And scroll the page and click on edit button
     
     #Scenario: Attendance Filter
     Then click on attendance filter
     And click on download attendance report
    And Logout admin
   # And close the browser
