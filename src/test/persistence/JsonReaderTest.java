package persistence;

// NOTE: the JsonSerializationDemo project was consulted heavily when designing this class
// the reference project can be found here: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import model.Article;
import model.Catalogue;
import model.PrimaryArticle;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    Article testArticle1 = new PrimaryArticle("Phenotype-driven precision oncology as a " +
            "guide for clinical decisions", "Shumei", "Chia",
            "Oncology", "SCPhen", false);

    Article testArticle2 = new PrimaryArticle("Neuroscience Needs Behavior: " +
            "Correcting a Reductionist Bias", "Krakauer",
            "John", "Neuroscience", "JKNN", false);

    @Test
    void testReaderFileDoesNotExist() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Catalogue catalogue = reader.read();
            fail("IOException wasn't thrown!");
        } catch (IOException e) {
            // expected, so do nothing
        }
    }

    @Test
    void testReaderEmptyCatalogue() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCatalogue.json");
        try {
            Catalogue catalogue = reader.read();
            assertEquals(0, catalogue.size());
        } catch (IOException e) {
            fail("File couldn't be read!");
        }
    }

    @Test
    void testReaderGeneralCatalogue() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCatalogue.json");
        try {
            Catalogue catalogue = reader.read();
            List<Article> articleList = new ArrayList<>(catalogue.getArticles());
            assertEquals(1, catalogue.size());
            checkArticle("Phenotype-driven precision oncology as a " +
                            "guide for clinical decisions", "Shumei", "Chia",
                    "Oncology", "SCPhen", articleList.get(0));
         //   checkArticle("Neuroscience Needs Behavior: Correcting a Reductionist Bias", "Krakauer",
           //         "John", "Neuroscience", "JKNN", articleList.get(0));
        } catch (IOException e) {
            fail("File couldn't be read!");
        }
    }
}
