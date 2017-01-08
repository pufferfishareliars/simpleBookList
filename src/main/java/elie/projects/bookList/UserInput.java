package elie.projects.bookList;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    private static final UserInput instance = new UserInput();

    private UserInput() {
        this.scanner = new Scanner(System.in);
    }
    public static UserInput getInstance() {
        return instance;
    }

    public int getUserChoice() {
        // Options are only 1 - add book, and 2 - view books
        // TODO - refactor, shouldn't know about adding and viewing options
        int userInput = scanner.nextInt();
        // check we have input
        if(userInput > 0 && userInput <= 3) {
            return userInput;
        } else {
            System.out.println("invalid choice, please try again");
            return getUserChoice();
        }
    }
}
