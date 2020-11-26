package model;

// A subclass of Article. Primary Articles usually contain original research work
// and focus on highlighting new results/insights researchers have found.
// The bread and butter of journal articles.
public class PrimaryArticle extends Article {

    // constructs a primary article
    public PrimaryArticle(String title, String firstNameAuthor,
                          String lastNameAuthor, String category, String uniqueID, Boolean readStatus) {
        super(title, firstNameAuthor, lastNameAuthor, category, uniqueID, readStatus);
    }

    //constructs a primary article without initializing fields
    public PrimaryArticle() {
        super();
    }
}
