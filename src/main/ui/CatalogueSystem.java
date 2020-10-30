package ui;

import model.Article;
import model.Catalogue;
import model.PrimaryArticle;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// NOTE: the TellerApp project files were heavily consulted during the writing of this class for the UI

// A cataloguing system for organizing journal articles
public class CatalogueSystem {

    private Catalogue catalogue;
    private Scanner input;

    // constructor to load the catalogue system
    public CatalogueSystem() {
        loadCatalogue();
    }

    private void loadCatalogue() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nClosing Application");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addRecord();
        } else if (command.equals("r")) {
            removeRecord();
        } else if (command.equals("v")) {
            viewArticleList();
        } else if (command.equals("m")) {
            markArticleRead();
        } else if (command.equals("vu")) {
            viewUnreadList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes catalogue and scanner for use in the system
    private void init() {
        catalogue = new Catalogue();
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add Article");
        System.out.println("\tr -> Remove Article");
        System.out.println("\tm -> Mark Articles Read/Unread");
        System.out.println("\tv -> View Articles in System");
        System.out.println("\tvu -> View Unread Articles Only in System");
        System.out.println("\tq -> Quit");
    }

    // MODIFIES: this
    // EFFECTS: adds a new journal article record to the system
    private void addRecord() {
        //need to come back and add functionality to change which type of article is added
        //Article selectedType = selectArticleType();
        //System.out.print("What type of article are you entering in?");

        Article article = new PrimaryArticle();

        System.out.println("What's the title?");


        String title = input.next();

        article.setTitle(title);

        System.out.println("What's the first name of the author?");
        String firstName = input.next();
        article.setFirstNameAuthor(firstName);

        System.out.println("What's the last name of the author?");
        String lastName = input.next();
        article.setLastNameAuthor(lastName);

        System.out.println("What's the category?");
        String category = input.next();
        article.setCategory(category);

        System.out.println("Generate a Unique ID for this article:");
        String uniqueID = input.next();
        article.setUniqueID(uniqueID);

        catalogue.addArticle(article);

        System.out.print("added article successfully");
    }

    // MODIFIES: this
    // EFFECTS: removes a journal article from the system
    private void removeRecord() {

        System.out.println("Which article do you want to delete? (Specify via unique ID):");

        for (Article article : catalogue.getArticles()) {
            if (article.getUniqueID().equals(input.next())) {
                catalogue.removeArticle(article);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: changes article read status to true
    private void markArticleRead() {
        System.out.println("Which article do you want to mark as read? (Specify via unique ID):");
        for (Article article : catalogue.getArticles()) {
            if (article.getUniqueID().equals(input.next())) {
                if (article.getReadStatus()) {
                    article.setUnreadStatus();
                } else {
                    article.setReadStatus();
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: returns the list of articles titles currently in the system, and their read status
    private void viewArticleList() {
        for (Article article : catalogue.getArticles()) {
            System.out.println("Title: " + article.getTitle() + " Read Status: " + article.getReadStatus());
        }
    }

    // MODIFIES: this
    // EFFECTS: returns list of unread articles in the system
    private void viewUnreadList() {
        for (Article article : catalogue.getUnreadList()) {
            System.out.println("Title: " + article.getTitle() + "Read Status: " + article.getReadStatus());
        }
    }
}
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
//
//        }
//    }