## Overview
A simple Android app to test Firebase functions, is ment to be use together with this [other repo](https://github.com/cutiko/testing-functions).
This Android app allow the user to sign up and gets notifications. When the user is registered Firebase Functions will create a node representing it in the Database.
When the registration is complete, the app will register in it's own node the Firebase Cloud Token in order to receive notifications later. **Please use a real device to test notifications, emulators are not reliable**
When the Fab is pressed then the notification will be triggeres, for the moment you have to change the value back manually in the Firebase Console.

# Instructions
1. Clone this
2. Create a Firebase Project
3. Create an Android App inside that project
4. Download the google-service.json from the Firebase Console to the app folder from this project
5. Open the project in Android Studio and start having fun
