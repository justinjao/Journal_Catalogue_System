package model;

// A class for a journal article, fields for the article title, the author's first and last name,
// and a category that the article falls under, and whether the article has been read yet by the user
public abstract class Article {
    String title;
    String firstNameAuthor;
    String lastNameAuthor;
    String category;
    Boolean readStatus;
    String uniqueID;

    // general constructor to make an article. User specifies the different fields of the paper
    // when they add it in. By default, readStatus is set to false and uniqueID is null
    public Article(String title, String firstNameAuthor, String lastNameAuthor, String category) {

        readStatus = false;
        uniqueID = null;
    }

    //overloading constructor. Creating a constructor that initializes all fields null, so they can be set later
    public Article() {
        readStatus = false;

    }

    // EFFECTS: returns the title of the article
    public String getTitle() {
        return title;
    }

    // EFFECTS: get first name of author
    public String getFirstNameAuthor() {
        return firstNameAuthor;
    }

    // EFFECTS: get last name of first author
    public String getLastNameAuthor() {
        return lastNameAuthor;
    }

    // EFFECTS: get category of the article
    public String getCategory() {
        return category;
    }

    // EFFECTS: get category of the article
    public Boolean getReadStatus() {
        return readStatus;
    }

    // EFFECTS: get uniqueID of the article
    public String getUniqueID() {
        return uniqueID;
    }

    // MODIFIES: this
    // EFFECTS: set the title of the article
    public void setTitle(String title) {
        this.title = title;
    }

    // MODIFIES: this
    // EFFECTS: set first name of author
    public void setFirstNameAuthor(String firstName) {
        this.firstNameAuthor = firstName;
    }

    // MODIFIES: this
    // EFFECTS: set last name of first author
    public void setLastNameAuthor(String lastName) {
        this.lastNameAuthor = lastName;
    }

    // MODIFIES: this
    // EFFECTS: set category of the article
    public void setCategory(String category) {
        this.category = category;
    }

    // MODIFIES: this
    // EFFECTS: changes read status of article to true (i.e. read)
    public void setReadStatus() {
        readStatus = true;
    }

    // MODIFIES: this
    // EFFECTS: changes read status of article to false (i.e. unread)
    public void setUnreadStatus() {
        readStatus = false;
    }

    // MODIFIES: this
    // EFFECTS: changes uniqueID of article to user specified input
    public void setUniqueID(String userInputID) {
        uniqueID = userInputID;
    }
}