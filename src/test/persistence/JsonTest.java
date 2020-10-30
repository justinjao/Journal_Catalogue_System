package persistence;

// NOTE: the JsonSerializationDemo project was consulted heavily when designing this class
// the reference project can be found here: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import model.Article;
import model.PrimaryArticle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {


    protected void checkArticle(String title, String firstNameAuthor, String lastNameAuthor,
                                String category, String uniqueID, Article article) {
        assertEquals(title, article.getTitle());
        assertEquals(firstNameAuthor, article.getFirstNameAuthor());
        assertEquals(lastNameAuthor, article.getLastNameAuthor());
        assertEquals(category, article.getCategory());
        assertEquals(uniqueID, article.getUniqueID());
    }

}
