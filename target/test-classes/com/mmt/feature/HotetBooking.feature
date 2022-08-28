Feature: Hotel Booking in MakeMyTrip application

@Positive
Scenario: User Login In the Web Application
Given user Launch the MakeMyTrip Application
When user Clicks The Username In Login  Field and Username Tab Opens 
And user Enters The Username In Username Field 
And user Clicks On Continue Button and It Navigates To Password Tab
And user Enter The Password In Password Field
Then user Click The Login Button and It Navigates To Home Page 

@Negative
Scenario: User Login In the Web Application with Invalid Username and Invalid Password
Given user Launch the MakeMyTrip Application
When user Clicks The Username In Login  Field and Username Tab Opens 
And user Enters The Invalid Username In Username Field 
And user Enters The Invalid password
Then user Click The Login Button 





Scenario: User Searches The Hotel 
When user Select The Hotel From The Navigation Catalogue
And user Select The Location Of The Hotel From The Available Location List 
And user Enter The Check In Date In Check In Date Field
And user Enter The Check Out Date In Check Out Date Field
And user Select Number Of Adults Per Room
And user Select Number Of Childrens Per Room
Then user Click The Search Button and It Navigates TO Select Hotel Page

Scenario: user Selects the Hotel
When  user Click On The First Hotel In List Of Hotels Available
And user Navigates To Booking Hotel Page  
Then user Click on Book now option




