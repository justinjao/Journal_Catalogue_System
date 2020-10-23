package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ArticleTest {

    Article testArticle;
    Article testArticle2;

    @Test
    public void testGetters(){
        assertEquals(testArticle.getTitle(), testArticle.title);
        assertEquals(testArticle.getFirstNameAuthor(), testArticle.firstNameAuthor);
        assertEquals(testArticle.getLastNameAuthor(), testArticle.lastNameAuthor);
        assertEquals(testArticle.getCategory(), testArticle.category);
        assertEquals(testArticle.getReadStatus(), testArticle.readStatus);
        assertEquals(testArticle.getUniqueID(), testArticle.uniqueID);

    }

    @Test
    public void testSetReadStatus(){
        testArticle.setReadStatus();
        assertTrue(testArticle.readStatus);
    }

    @Test
    public void testSetUnreadStatus(){
        testArticle.setUnreadStatus();
        assertFalse(testArticle.readStatus);
    }

    @Test
    public void testSetTitle(){
        testArticle2.setTitle("trialTitle");
        assertEquals(testArticle2.title, "trialTitle");
    }

    @Test
    public void testSetFirstNameAuthor(){
        testArticle2.setFirstNameAuthor("James");
        assertEquals(testArticle2.firstNameAuthor, "James");
    }

    @Test
    public void testSetLastNameAuthor(){
        testArticle2.setLastNameAuthor("Jackson");
        assertEquals(testArticle2.lastNameAuthor, "Jackson");
    }

    @Test
    public void testSetCategory(){
        testArticle2.setCategory("Math");
        assertEquals(testArticle2.category, "Math");
    }

    @Test
    public void setUniqueID(){
        testArticle2.setUniqueID("MG11");
        assertEquals(testArticle2.uniqueID, "MG11");
    }
}