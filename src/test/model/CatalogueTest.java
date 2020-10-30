package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

// NOTE: the IntegetSetInterface code from the CPSC210 project files was consulted quite often when writing these tests

// test class of the catalogue system
public class CatalogueTest {
    Article testPrimaryArticle;
    Article testMethodsArticle;
    Catalogue testCatalogue;

    @BeforeEach
    public void setup() {
        testCatalogue = new Catalogue();

        testPrimaryArticle = new PrimaryArticle("Phenotype-driven precision oncology as a guide for clinical decisions " +
                "one patient at a time", "Shumei", "Chia", "Oncology");

        testMethodsArticle = new MethodsArticle("RGB marking with lentiviral vectors for multicolor clonal cell tracking",
                "Kristoffer", "Weber", "Cell Staining");
    }




    @Test
    public void testAddArticleOnce() {

        testCatalogue.addArticle(testPrimaryArticle);

        assertTrue(testCatalogue.checkContains(testPrimaryArticle));

    }


    @Test
    public void testAddArticleMultiple() {
        assertEquals(testCatalogue.size(), 0);

        testCatalogue.addArticle(testPrimaryArticle);
        testCatalogue.addArticle(testMethodsArticle);

        assertEquals(testCatalogue.size(), 2);

    }


    @Test
    public void testAddArticleDuplicate() {
        assertEquals(testCatalogue.size(), 0);
        testCatalogue.addArticle(testPrimaryArticle);
        assertEquals(testCatalogue.size(), 1);
        testCatalogue.addArticle(testPrimaryArticle);
        assertEquals(testCatalogue.size(), 1);
    }


    @Test
    public void testRemoveArticleOnce() {
        assertEquals(testCatalogue.size(), 0);
        testCatalogue.addArticle(testPrimaryArticle);
        assertEquals(testCatalogue.size(), 1);

        testCatalogue.removeArticle(testPrimaryArticle);
        assertEquals(testCatalogue.size(), 0);

    }

    @Test
    // tests whether it removes the right article
    public void testRemoveArticleCorrectOne() {
        assertEquals(testCatalogue.size(), 0);
        testCatalogue.addArticle(testPrimaryArticle);
        testCatalogue.addArticle(testMethodsArticle);

        testCatalogue.removeArticle(testPrimaryArticle);

        assertTrue(testCatalogue.checkContains(testMethodsArticle));
        assertFalse(testCatalogue.checkContains(testPrimaryArticle));

    }

    @Test
    public void testRemoveArticleMultiple() {
        assertEquals(testCatalogue.size(), 0);
        testCatalogue.addArticle(testPrimaryArticle);
        testCatalogue.addArticle(testMethodsArticle);
        assertEquals(testCatalogue.size(), 2);
        testCatalogue.removeArticle(testMethodsArticle);
        testCatalogue.removeArticle(testPrimaryArticle);
        assertEquals(testCatalogue.size(), 0);
    }

    @Test
    public void testRemoveArticleNotThere() {

        testCatalogue.addArticle(testPrimaryArticle);
        testCatalogue.removeArticle(testMethodsArticle);

        assertTrue(testCatalogue.checkContains(testPrimaryArticle));

    }

    @Test
    public void testGetArticles() {

        testCatalogue.addArticle(testMethodsArticle);
        testCatalogue.addArticle(testPrimaryArticle);

        assertEquals(testCatalogue.getArticles(), testCatalogue.articleList);
    }

    @Test
    public void testGetUnreadListEmptyList() {
        testCatalogue.removeArticle(testPrimaryArticle);
        testCatalogue.removeArticle(testMethodsArticle);
        assertTrue(testCatalogue.getUnreadList().isEmpty());
    }

    @Test
    public void testGetUnreadListNoUnread() {
        testMethodsArticle.setReadStatus();
        testCatalogue.addArticle(testMethodsArticle);
        assertEquals(0, testCatalogue.getUnreadList().size());

    }

    @Test
    public void testGetUnreadListOneUnread() {
        testCatalogue.addArticle(testMethodsArticle);
        assertEquals(1, testCatalogue.getUnreadList().size());
    }

    @Test
    public void testGetUnreadListManyUnread() {
        testCatalogue.addArticle(testMethodsArticle);
        testCatalogue.addArticle(testPrimaryArticle);
        assertEquals(2, testCatalogue.getUnreadList().size());
    }
}

