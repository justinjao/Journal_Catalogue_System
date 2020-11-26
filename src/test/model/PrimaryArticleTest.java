package model;

import org.junit.jupiter.api.BeforeEach;

public class PrimaryArticleTest extends ArticleTest {

    @BeforeEach
    public void setup() {
        testArticle = new PrimaryArticle("Phenotype-driven precision oncology as a guide for clinical decisions " +
                "one patient at a time", "Shumei", "Chia", "Oncology", "SCPhen", false);

        testArticle2 = new PrimaryArticle();
    }

}
