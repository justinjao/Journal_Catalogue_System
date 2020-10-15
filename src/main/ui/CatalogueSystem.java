//package ui;
//
//import model.Article;
//import model.Catalogue;
//import model.PrimaryArticle;
//
//import java.util.Scanner;
//
//// NOTE: the TellerApp project files were heavily consulted during the writing of this class for the UI
//
//// A cataloguing system for organizing journal articles
//public class CatalogueSystem {
//
//    private Catalogue catalogue;
//    private Scanner input;
//
//    // constructor to load the catalogue system
//    public CatalogueSystem() {
//        loadCatalogue();
//    }
//
//    private void loadCatalogue() {
//        boolean keepGoing = true;
//        String command = null;
//
//        init();
//
//        while (keepGoing) {
//            displayMenu();
//            command = input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//
//        System.out.println("\nClosing Application");
//    }
//}
//    // MODIFIES: this
//    // EFFECTS: processes user command
//    private void processCommand(String command) {
//        if (command.equals("a")) {
//            addRecord();
//        } else if (command.equals("r")) {
//            removeRecord();
//        } else if (command.equals("v")) {
//            viewArticleList();
//        } else {
//            System.out.println("Selection not valid...");
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: initializes catalogue and scanner for use in the system
//    private void init() {
//        catalogue = new Catalogue();
//        input = new Scanner(System.in);
//    }
//
//    // EFFECTS: displays menu of options to user
//    private void displayMenu() {
//        System.out.println("\nSelect from:");
//        System.out.println("\ta -> Add Article");
//        System.out.println("\tr -> Remove Article");
//        System.out.println("\tv -> View Articles in System");
//        System.out.println("\tq -> Quit");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: adds a new journal article record to the system
//    private void addRecord() {
//        //need to come back and add functionality to change which type of article is added
//        //Article selectedType = selectArticleType();
//        //System.out.print("What type of article are you entering in?");
//
//        Article article = new PrimaryArticle();
//
//
//        double amount = input.nextDouble();
//
//        if (amount >= 0.0) {
//            selected.deposit(amount);
//        } else {
//            System.out.println("Cannot deposit negative amount...\n");
//        }
//
//        printBalance(selected);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: removes a journal article from the system
//    private void removeRecord() {
//        Account selected = selectArticleType();
//        System.out.print("Enter amount to withdraw: $");
//        double amount = input.nextDouble();
//
//        if (amount < 0.0) {
//            System.out.println("Cannot withdraw negative amount...\n");
//        } else if (selected.getBalance() < amount) {
//            System.out.println("Insufficient balance on account...\n");
//        } else {
//            selected.withdraw(amount);
//        }
//
//        printBalance(selected);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: returns the list of articles currently in the system
//    private void viewArticleList() {
//        System.out.println("\nTransfer from?");
//        Account source = selectArticleType();
//        System.out.println("Transfer to?");
//        Account destination = selectArticleType();
//
//        System.out.print("Enter amount to transfer: $");
//        double amount = input.nextDouble();
//
//        if (amount < 0.0) {
//            System.out.println("Cannot transfer negative amount...\n");
//        } else if (source.getBalance() < amount) {
//            System.out.println("Insufficient balance on source account...\n");
//        } else {
//            source.withdraw(amount);
//            destination.deposit(amount);
//        }
//
//        System.out.print("Source ");
//        printBalance(source);
//        System.out.print("Destination ");
//        printBalance(destination);
//    }
//
//    // EFFECTS: prompts user to specify which type of article they are entering in
//    private Article selectArticleType() {
//        String selection = "";  // force entry into loop
//
//        while (!(selection.equals("p") || selection.equals("m"))) {
//            System.out.println("p for Primary Article");
//            System.out.println("m for Methods Article");
//            selection = input.next();
//            selection = selection.toLowerCase();
//        }
//
//        if (selection.equals("p")) {
//            new PrimaryArticle();
//        } else {
//            return sav;
//        }
//    }
//
//    // EFFECTS: prints balance of account to the screen
//    private void printBalance(Account selected) {
//        System.out.printf("Balance: $%.2f\n", selected.getBalance());
//    }
//}
//


