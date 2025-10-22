import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

abstract class JavaModule {
    protected String moduleName;
    protected int score = 0;
    protected Scanner sc;

    public JavaModule(String name, Scanner sc) {
        this.moduleName = name;
        this.sc = sc;
    }

    public abstract void askQuestions();
    public abstract void showStudyMaterial();

    public void showScore() {
        System.out.println("\nYour score in " + moduleName + " Module: " + score + " points\n");
    }

    protected void runQuiz(String[] questions, String[][] options, int[] answers) {
        score = 0; // Reset score at the start of quiz
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + questions[i]);
            for (int j = 0; j < 4; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }

            int choice;
            while (true) {
                System.out.print("Enter your choice (1-4): ");
                String input = sc.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= 4) break;
                    else System.out.println("Please enter a number between 1 and 4.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            if (choice == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! Correct answer: " + options[i][answers[i] - 1]);
            }
        }
    }
}

class BeginnerModule extends JavaModule {
    public BeginnerModule(Scanner sc) {
        super("Beginner", sc);
    }
    public void showStudyMaterial() {
        System.out.println("\n Beginner Module Study Material:");
        System.out.println("Java classes are defined using the 'class' keyword. Variables have default values based on type.");
        System.out.println("This module covers basic syntax, keywords, and primitive data types.");
        System.out.println(" Learn more: https://www.javatpoint.com/java-tutorial");
    }
    public void askQuestions() {
        String[] questions = {
            "Which keyword is used to define a class in Java?",
            "What is the default value of an int variable?",
            "Which symbol is used to end a statement in Java?",
            "Which keyword is used to create an object?",
            "What does JVM stand for?"
        };
        String[][] options = {
            {"object", "class", "define", "public"},
            {"0", "null", "undefined", "1"},
            {".", ",", ";", ":"},
            {"new", "create", "object", "make"},
            {"Java Variable Manager", "Java Virtual Machine", "Java Version Module", "Joint Variable Machine"}
        };
        int[] answers = {2, 1, 3, 1, 2};
        runQuiz(questions, options, answers);
    }
}

class IntermediateModule extends JavaModule {
    public IntermediateModule(Scanner sc) {
        super("Intermediate", sc);
    }
    public void showStudyMaterial() {
        System.out.println("\n Intermediate Module Study Material:");
        System.out.println("Java has 8 primitive types. 'String' is not one of them — it's a class.");
        System.out.println("Use 'equals()' to compare string content, not '=='.");
        System.out.println(" Learn more: https://www.geeksforgeeks.org/java/");
    }
    public void askQuestions() {
        String[] questions = {
            "Which of the following is not a primitive data type in Java?",
            "Which method is used to compare two strings in Java?",
            "Which keyword is used to inherit a class in Java?",
            "Which loop runs at least once even if the condition is false?",
            "What is the size of int in Java?"
        };
        String[][] options = {
            {"int", "boolean", "String", "char"},
            {"equals()", "==", "compare()", "match()"},
            {"inherits", "extends", "implements", "instanceof"},
            {"for", "while", "do-while", "none"},
            {"2 bytes", "4 bytes", "8 bytes", "Depends on OS"}
        };
        int[] answers = {3, 1, 2, 3, 2};
        runQuiz(questions, options, answers);
    }
}

class AdvancedModule extends JavaModule {
    public AdvancedModule(Scanner sc) {
        super("Advanced", sc);
    }
    public void showStudyMaterial() {
        System.out.println("\n Advanced Module Study Material:");
        System.out.println("'final' in Java is used to declare constants, methods that cannot be overridden, and immutable classes.");
        System.out.println("Java supports single inheritance. Inheritance enables code reuse.");
        System.out.println(" Learn more: https://www.w3schools.com/java/java_inheritance.asp");
    }
    public void askQuestions() {
        String[] questions = {
            "What is the purpose of the 'final' keyword in Java?",
            "Which concept allows one class to inherit from another?",
            "Which access modifier makes a member visible to all classes?",
            "Which exception is thrown when a negative array size is declared?",
            "Which keyword is used to implement abstraction in Java?"
        };
        String[][] options = {
            {"To define constants", "To define loops", "To import classes", "To override methods"},
            {"Encapsulation", "Abstraction", "Inheritance", "Polymorphism"},
            {"private", "protected", "default", "public"},
            {"NegativeSizeException", "NegativeArraySizeException", "ArrayIndexOutOfBoundsException", "IllegalArgumentException"},
            {"abstract", "interface", "implements", "inherit"}
        };
        int[] answers = {1, 3, 4, 2, 1};
        runQuiz(questions, options, answers);
    }
}

class User {
    String name, email, mobile, username, password;
    boolean isPremium;
    public User(String name, String email, String mobile, String username, String password, boolean isPremium) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.isPremium = isPremium;
    }
}

public class JavaLearningApp {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, User> users = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(" Welcome to the Java Learning App");
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> registerUser();
                case 2 -> {
                    User currentUser = loginUser();
                    if (currentUser != null) launchModule(currentUser);
                }
                case 3 -> {
                    System.out.println(" Thank you for using the app!");
                    return;
                }
                default -> System.out.println(" Invalid choice.");
            }
        }
    }

    // Validation utilities
    static String promptValidEmail() {
        while (true) {
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            if (email.endsWith("@gmail.com")) return email;
            System.out.println(" Email must end with @gmail.com");
        }
    }
    static String promptValidMobile() {
        while (true) {
            System.out.print("Enter Mobile Number: ");
            String mobile = sc.nextLine();
            if (mobile.matches("\\d{10}")) return mobile;
            System.out.println(" Mobile number must be 10 digits");
        }
    }
    static String promptValidUsername() {
        while (true) {
            System.out.print("Choose a Username (max 20 characters): ");
            String username = sc.nextLine();
            if (username.length() > 20) {
                System.out.println(" Username too long.");
                continue;
            }
            if (users.containsKey(username)) {
                System.out.println(" Username already exists.");
                continue;
            }
            return username;
        }
    }
    static String promptValidPassword() {
        while (true) {
            System.out.print("Choose a Password (min 8 chars, 1 number, 1 special char): ");
            String password = sc.nextLine();
            if (isValidPassword(password)) return password;
            System.out.println(" Invalid password format.");
        }
    }

    static void registerUser() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        String email = promptValidEmail();
        String mobile = promptValidMobile();
        String username = promptValidUsername();
        String password = promptValidPassword();
        users.put(username, new User(name, email, mobile, username, password, false));
        System.out.println(" Registration Successful! Please login to continue.");
    }

    static boolean isValidPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[!@#$%^&*()_+=-].*");
    }

    static User loginUser() {
        while (true) {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            if (!users.containsKey(username)) {
                System.out.println(" Username does not exist.");
                System.out.println("1. Try Again\n2. Exit");
                if (sc.nextLine().equals("2")) return null;
                else continue;
            }
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            if (users.get(username).password.equals(password)) {
                System.out.println(" Login successful! Welcome, " + users.get(username).name);
                return users.get(username);
            } else {
                System.out.print(" Wrong password. Forgot password or Exit? (forgot/exit): ");
                if (sc.nextLine().equalsIgnoreCase("forgot")) {
                    forgotPassword(username);
                } else {
                    return null;
                }
            }
        }
    }

    static void forgotPassword(String username) {
        String otp = String.valueOf(new Random().nextInt(9000) + 1000);
        System.out.println(" OTP sent to registered email/mobile.");
        System.out.println("(Debug: OTP is " + otp + ")");
        System.out.print("Enter OTP: ");
        if (!sc.nextLine().equals(otp)) {
            System.out.println(" Incorrect OTP. Password reset failed.");
            return;
        }
        users.get(username).password = promptValidPassword();
        System.out.println(" Password reset successful!");
    }

    static void launchModule(User user) {
        int currentModule = 1;
        while (currentModule <= 3) {
            JavaModule module = null;
		switch (currentModule) {
   		 case 1:
     		   module = new BeginnerModule(sc);
     		   break;
   		 case 2:
   		     module = new IntermediateModule(sc);
   		     break;
   		 case 3:
   		     if (!user.isPremium) {
    		        System.out.println("You are not a premium member.");
         		   System.out.print("Buy premium to access Advanced Module? (yes/no): ");
     		       if (sc.nextLine().equalsIgnoreCase("yes")) {
      		          simulatePayment(user);
      		          if (!user.isPremium) return;
      		      } else {
      		          return;
     		       }
    		    }
   		     module = new AdvancedModule(sc);
   		     break;
	}

            boolean retrying = false;
            while (true) {
                if (!retrying) module.showStudyMaterial();
                System.out.println("\n1. Take Quiz\n2. Exit to Main Menu");
                if (!sc.nextLine().equals("1")) return;

                module.askQuestions();
                module.showScore();

                if (module.score >= 4) {
                    if (currentModule == 3) {
                        generateCertificate(user);
                        return;
                    }
                    currentModule++;
                    break;
                } else {
                    System.out.print("You need at least 4 points. Retry? (yes/no): ");
                    if (sc.nextLine().equalsIgnoreCase("yes")) {
                        retrying = true;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    static void simulatePayment(User user) {
        System.out.println("\n Premium Subscription: ₹5000");
        System.out.print("Proceed? (yes/no): ");
        if (!sc.nextLine().equalsIgnoreCase("yes")) return;

        String otp = String.valueOf(new Random().nextInt(9000) + 1000);
        System.out.println(" OTP sent to registered mobile/email.");
        System.out.println("(Debug: OTP is " + otp + ")");
        System.out.print("Enter OTP: ");
        if (!sc.nextLine().equals(otp)) {
            System.out.println(" Incorrect OTP. Payment failed.");
            return;
        }
        user.isPremium = true;
        System.out.println(" Payment successful! You are now Premium.");
    }

    static void generateCertificate(User user) {
        String border = "+------------------------------------------------------------+";
        System.out.println("\n" + border);
        System.out.println("|                    JAVA COMPLETION CERTIFICATE           |");
        System.out.println(border);
        System.out.printf ("|  This is to certify that %-30s         |\n", user.username.toUpperCase());
        System.out.println("|  has successfully completed all modules.                 |");
        System.out.println(border + "\n");
    }
}
