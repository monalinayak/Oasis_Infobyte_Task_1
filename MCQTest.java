/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mcqtest;

/**
 *
 * @author monalinayak
 */
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MCQTest 
{
    private static String username = "testuser";
    private static String password = "testpass";
    private static String name = "Test User";
    private static int age = 25;
    private static String email = "testuser@test.com";
    private static int score = 0;
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        login(scanner);
        if (isLoggedIn) {
            updateProfile(scanner);
            takeTest(scanner);
        }
        logout();
    }

    private static void login(Scanner scanner) 
    {
        System.out.println("Welcome to the MCQ Test!");
        System.out.print("Enter your username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String inputPassword = scanner.nextLine();
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            isLoggedIn = true;
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void updateProfile(Scanner scanner) 
    {
        System.out.println("Update Profile:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.print("Enter your new name: ");
        name = scanner.nextLine();
        System.out.print("Enter your new age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter your new email: ");
        email = scanner.nextLine();
        System.out.println("Profile updated.");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.print("Enter your new password: ");
        password = scanner.nextLine();
        System.out.println("Password updated.");
    }

    private static void takeTest(Scanner scanner) {
        String[] questions = {
                "What is the capital of France?\n(A) Paris\n(B) London\n(C) Berlin\n(D) Rome\n",
                "Who invented the telephone?\n(A) Alexander Graham Bell\n(B) Thomas Edison\n(C) Nikola Tesla\n(D) Isaac Newton\n",
                "What is the largest planet in our solar system?\n(A) Jupiter\n(B) Saturn\n(C) Neptune\n(D) Earth\n"
        };
        String[] answers = {"A", "A", "A"};
        Timer timer = new Timer();
        int duration = 120; // 2 minutes
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                submitAnswers(questions, answers, scanner);
                logout();
                System.exit(0);
            }
        }, duration * 1000);
        System.out.println("You have " + duration + " seconds to complete the test.");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ":\n" + questions[i]);
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals(answers[i])) {
                score++;
            }
        }
        submitAnswers(questions, answers, scanner);
    }

    private static void submitAnswers(String[] questions, String[] answers, Scanner scanner) {
        System.out.println("Time's up! Submitting answers...");
        for (int i = 0; i < questions.length; i++) {
        System.out.println("Question " + (i + 1) + ":\n" + questions[i]);
        System.out.println("Your answer: " + answers[i]);
    }
    System.out.println("Your score: " + score);
}

private static void logout() {
    System.out.println("Logging out...");
    isLoggedIn = false;
}

}

/*
Sample Input Output
java -cp /tmp/R9WHiqrXnZ Main
Welcome to the MCQ Test!Enter your username: testuser
Enter your password: testpass
Login successful.
Update Profile:
Name: Test User
Age: 25
Email: testuser@test.com
Enter your new name: Monali
Enter your new age: 25
Enter your new email: monali.monalinayak@gmail.com
Profile updated.
Name: Monali
Age: 25
Email: monali.monalinayak@gmail.comEnter your new password: newpass
Password updated.
You have 120 seconds to complete the test.
Question 1:
What is the capital of France?
(A) Paris
(B) London
(C) Berlin
(D) Rome

Enter your answer: A
Question 2:
Who invented the telephone?
(A) Alexander Graham Bell
(B) Thomas Edison
(C) Nikola Tesla
(D) Isaac Newton

Enter your answer: A
Question 3:
What is the largest planet in our solar system?
(A) Jupiter
(B) Saturn
(C) Neptune
(D) Earth

Enter your answer: A
Time's up! Submitting answers...Question 1:
What is the capital of France?
(A) Paris
(B) London
(C) Berlin
(D) Rome
Your answer: AQuestion 2:
Who invented the telephone?
(A) Alexander Graham Bell
(B) Thomas Edison
(C) Nikola Tesla
(D) Isaac Newton

Your answer: A
Question 3:
What is the largest planet in our solar system?
(A) Jupiter
(B) Saturn
(C) Neptune
(D) Earth

Your answer: A
Your score: 3
Logging out...
Time's up! Submitting answers...
Question 1:
What is the capital of France?
(A) Paris
(B) London
(C) Berlin
(D) Rome

Your answer: A
Question 2:
Who invented the telephone?
(A) Alexander Graham Bell
(B) Thomas Edison
(C) Nikola Tesla
(D) Isaac Newton

Your answer: A
Question 3:
What is the largest planet in our solar system?
(A) Jupiter
(B) Saturn
(C) Neptune
(D) Earth

Your answer: A
Your score: 3
Logging out...
*/


