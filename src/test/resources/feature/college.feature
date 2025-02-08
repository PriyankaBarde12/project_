@SmokeFeature
Feature: College Info

@smoketest
Scenario: college page
				
				Given user is on login page
    		When user enters username "admin@gmail.com" and password "admin@2025#"
  		  And clicks on the login button
  		  Then admin can view Dashboard
  		  When click on College Menu