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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    Article testArticle1 = new PrimaryArticle("Phenotype-driven precision oncology as a " +
            "guide for clinical decisions", "Shumei", "Chia",
            "Oncology", "SCPhen");

    Article testArticle2 = new PrimaryArticle("Neuroscience Needs Behavior: " +
            "Correcting a Reductionist Bias", "Krakauer",
            "John", "Neuroscience", "JKNN");

    @Test
    void testWriterInvalidFile() {
        try {
            Catalogue catalogue = new Catalogue();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException wasn't thrown!");
        } catch (IOException e) {
            //expected, so do nothing
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Catalogue catalogue = new Catalogue();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCatalogue.json");
            writer.open();
            writer.write(catalogue);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCatalogue.json");
            catalogue = reader.read();
            assertEquals(0, catalogue.size());
        }
        catch (IOException e) {
            fail("IOException should not have been thrown for empty catalogue");
        }
    }

    @Test
    void testWriterGeneralCatalogue() {
        try {
            Catalogue catalogue = new Catalogue();
            catalogue.addArticle(testArticle1);
           // testArticle2.setReadStatus(); //set read status to true to have a different value than testArticle1
            //catalogue.addArticle(testArticle2);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCatalogue.json");
            writer.open();
            writer.write(catalogue);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCatalogue.json");
            catalogue = reader.read();
            List<Article> articleList = new ArrayList<>(catalogue.getArticles());
            assertEquals(1, articleList.size());
            checkArticle("Phenotype-driven precision oncology as a " +
                            "guide for clinical decisions", "Shumei", "Chia",
                    "Oncology", "SCPhen", articleList.get(0));
         //   checkArticle("Neuroscience Needs Behavior: Correcting a Reductionist Bias", "Krakauer",
           //         "John", "Neuroscience", "JKNN", articleList.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
