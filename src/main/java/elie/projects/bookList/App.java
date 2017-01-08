package elie.projects.bookList;

import elie.projects.bookList.models.Book;

import java.io.IOException;

public class App {
    static final short ADD_BOOK = 1;
    static final short VIEW_BOOKS = 2;

    public static void main(String[] args) {
        try {
            UserInput input = UserInput.getInstance();

            Runtime.getRuntime().exec("clear");
            System.out.println("Welcome to your Books");
            // TODO - refactor menu choices into own class
            printMenuOptions();
            int choice = input.getUserChoice();
            while (choice != 3) {
                // delegate here
                switch (choice) {
                    case ADD_BOOK:
                        System.out.println("Add a book!!!!!!!");
                        break;
                    case VIEW_BOOKS:
                        System.out.println("VIEW BOOKS!!1");
                        break;
                }
                printMenuOptions();
                choice = input.getUserChoice();
            }
            System.out.print("Thanks for using my book software!");
        } catch (IOException ioException) {
            System.err.println(ioException.getMessage());
        }
    }

    // TODO - add ability to list books by tag
    public static void printMenuOptions() {
        System.out.println("1) Add a book");
        System.out.println("2) View books");
        System.out.println("3) Exit");
    }
}
