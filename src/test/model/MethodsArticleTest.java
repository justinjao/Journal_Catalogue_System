package model;

import org.junit.jupiter.api.BeforeEach;

public class MethodsArticleTest extends ArticleTest {

    @BeforeEach
    public void setup() {
        testArticle = new MethodsArticle("RGB marking with lentiviral vectors for multicolor clonal cell tracking",
                "Kristoffer", "Weber", "Cell Staining");
    }
}
