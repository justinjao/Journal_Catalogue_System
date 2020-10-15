package model;

// a subclass of Article. Methods articles usually focus on highlighting experimental methods/protocols
public class MethodsArticle extends Article {

    //constructs a methods article
    public MethodsArticle(String title, String firstNameAuthor, String lastNameAuthor, String category) {
        super(title, firstNameAuthor, lastNameAuthor, category);

    }

    //constructs a methods article without initializing fields
    public MethodsArticle() {
        super();
    }
}
