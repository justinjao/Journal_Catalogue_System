package model;

// A class for a journal article, fields for the article title, the author's first and last name,
// and a category that the article falls under, and whether the article has been read yet by the user
public abstract class Article {
    String title;
    String firstNameAuthor;
    String lastNameAuthor;
    String category;
    Boolean readStatus;

    // general constructor to make an article. User specifies the different fields of the paper
    // when they add it in. By default, readStatus is set to false
    public Article(String title, String firstNameAuthor, String lastNameAuthor, String category) {
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
}