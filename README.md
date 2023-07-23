
# Skillo final assignment

The idea of this project is to test the functionalities in the training.skillo-bg.com webpage. 

This is a final assignment to get certified. 



## Authors

- [@maria.hristoforova](https://www.github.com/maria.hristoforova)


## Requirements

- IntelliJ
- Java 8 
- TestNg 
- Selenium
- Maven 

## Setting up

Install dependencies and plugins in pom.xml file: 
- selenium-java (dependency)
- testng (dependency)
- commons-io (dependency)
- webdrivermanager (dependency)
- Maven Compiler plugin
- Maven Surefire plugin


## Running Tests

Selenium WebDriver is the primary run tool which permits you to execute cross-browser tests. 
For all the tests is used ChromeDriver. 


## Test Scenarios Steps

- Test for sccessfully login 
 1. Navigate to Home page
  2. Navigate to Login page
  3. Check url is correct
  4. Check the Sign in is displayed
  5. Enter username
  6. Enter password
  7. Click the Sign in button
  8. Check url is correct
  9. Profile section is visible
  10. Check that the Sign out button is visible

- Test for login without entering password in the password field 
  1. Navigate to Home page
  2. Navigate to Login page
  3. Enter username
  4. Click the Sign in button
  5. Pop-up message that the password cannot be empty shows up

- Test for login without entering username in the UsernameOrEmail field
  1. Navigate to Home page
  2. Navigate to Login page
  3. Enter password
  4. Click the Sign in button
  5. Pop-up message that the username or the email cannot be empty shows up

- Test for login with incorrect credentials
  1. Navigate to Home page
  2. Navigate to Login page
  3. Check url is correct
  4. Check the Sign in is displayed
  5. Enter username
  6. Enter password
  7. Click the Sign in button
  8. Pop-up message that the user is not found shows up

- Test for successful logout 
1. Navigate to Home page
2. Navigate to Login page
3. Check url is correct
4. Check the Sign in is displayed
5. Enter username
6. Enter password
7. Click the Sign in button
8. Check url is correct
9. Check the Profile seccion is visible 
10. Click the logout button
11. Check that the login button is visible again 

- Test for like or dislike public post 
1. Navigate to Home page
2. Navigate to Login page
3. Enter username
4. Enter password
5. Click the Sign in button
6. Go to Home page and load all posts
7. Choose user's post 
8. Check if the button to like the post is visible
9. Click on the heart button to like the post
10. Click the heart button again and check if the pop-up message is "You don't like this post anymore!

- Test for following or unfollowing an user
1. Navigate to Home page
2. Navigate to Login page
3. Enter username
4. Enter password
5. Click the Sign in button
6. Go to Home page and load all posts
7. Choose user's post 
8. Check if the button to Follow or Unfollow  is visible
9. Click on the button to "Follow" or Unfollow
10. Get text of the button after following/unfollowing the user and click again to see if it works correctly

- Test for comment a public post 
1. Navigate to Home page
2. Navigate to Login page
3. Enter username
4. Enter password
5. Click the Sign in button
6. Go to Home page and load all posts
7. Choose user's post 
8. Click the post
9. Check if the modal container of the post is loaded
10. Check visibility of the comment field
11. Click the comment field
12. Write a text in the field
13. Go to the comment in the all comments container and verify it is visible or check the text

- Test for add public information in the profile 
1. Go to the website
2. Click on Login
3. Enter credentials (username and password)
4. Go to profile button and click it
5. Go to the icon to edit profile and click it
6. Check if the form for editing of a profile is visible
7. Find "Public info" section and write something for the user
8. Click on Save button
9. Go back to the Edit profile icon
10. Verify the information and if the text in "Public info" text is saved
