package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class ArticleTest {

    Article testArticle;

    @Test
    public void testGetters(){
        assertEquals(testArticle.getTitle(), testArticle.title);
        assertEquals(testArticle.getFirstNameAuthor(), testArticle.firstNameAuthor);
        assertEquals(testArticle.getLastNameAuthor(), testArticle.lastNameAuthor);
        assertEquals(testArticle.getCategory(), testArticle.category);

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
}