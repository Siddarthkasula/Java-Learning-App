# Java-Learning-App

Java Learning App
A console-based interactive learning platform built in Java to help users master Java programming fundamentals through progressive modules and quizzes.

Overview
The Java Learning App provides structured learning for users at different skill levels — Beginner, Intermediate, and Advanced. Users progress through levels by scoring at least 80% (4 out of 5 points) in quizzes. Advanced module access is gated behind a premium subscription simulation, and successful completion awards a certificate.

Features
User Registration & Login

Secure validation for username, email (@gmail.com), mobile number, and password.

Option to reset password using a simulated OTP process.

Progressive Learning Modules

Beginner: Covers basic Java syntax, variables, and primitive types.

Intermediate: Focuses on strings, loops, and inheritance fundamentals.

Advanced (Premium): Discusses inheritance, final classes, and abstraction concepts.

Quiz System

Each module contains 5 multiple-choice questions.

Instant feedback is provided after every question.

Minimum 4 correct answers required to progress.

Premium Subscription

Advanced module access requires subscribing for ₹5000 (simulated).

Includes OTP-based payment confirmation.

Certificate Generation

On successful completion of all modules, users receive a console-based completion certificate.

Technologies Used
Language: Java

Paradigm: Object-Oriented Programming (OOP)

Java Packages:

java.util — for Scanner, Random, HashMap

java.time — for date/time formatting

java.util.UUID — for unique identifiers (if needed)

How It Works
Run the App:
Compile and run the program in any standard Java IDE or terminal.

text
javac JavaLearningApp.java
java JavaLearningApp
Register a New User:
Enter name, email, mobile number, username, and password following the rules.

Login & Start Learning:
Select the module and begin with Beginner level. Proceed only if quiz criteria are met.

Upgrade to Premium:
Buy premium access when prompted to unlock the Advanced module.

Earn Certificate:
Upon completing all three modules successfully, a certificate of completion is printed in the console.

File Structure
text
JavaLearningApp.java
├── JavaModule (abstract class)
│   ├── showStudyMaterial()
│   ├── askQuestions()
│   └── runQuiz()
├── BeginnerModule
├── IntermediateModule
├── AdvancedModule
├── User
└── JavaLearningApp (main class)
Learning Flow
Stage	Description	Requirement
Beginner	Basic syntax and data types	Pass quiz with ≥ 4 points
Intermediate	Strings, loops, inheritance	Pass quiz with ≥ 4 points
Advanced	Abstraction, final keyword, exceptions	Premium access + pass quiz with ≥ 4 points
Requirements
JDK 17 or newer

Terminal or IDE with console support

Future Enhancements
GUI-based version with JavaFX

Persistent user data using files or databases

Integration of performance analytics and tracking

Dynamic question banks for varied practice
