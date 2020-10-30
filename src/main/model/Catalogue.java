package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// Represents a catalogue system for storing journal articles.
// Contains a list (hashset) of articles.

// NOTE: the IntegetSetInterface code from the CPSC210 project files was consulted quite often when writing this class

public class Catalogue {
    Collection<Article> articleList;
    Collection<Article> unreadList;

    // constructor for the catalogue system for storing all the articles a user adds
    public Catalogue() {
        articleList = new HashSet<>();
        unreadList = new HashSet<>();

    }

    // MODIFIES: this
    // EFFECTS: adds a new article to the articleList
    public void addArticle(Article article) {
        articleList.add(article);
    }

    // REQUIRES: current articleList is not empty
    // MODIFIES: this
    // EFFECTS: removes an article from the articleList
    public void removeArticle(Article article) {
        articleList.remove(article);

    }

    // EFFECTS: returns the current articleList of articles
    public Collection<Article> getArticles() {
        return articleList;
    }

    // EFFECTS: returns the current size of the articleList
    public int size() {
        return articleList.size();
    }

    // EFFECTS: checks whether the article given is present in the article list,
    // returns true if present, false otherwise
    public boolean checkContains(Article article) {
        return articleList.contains(article);
    }

    // gets list of unread article titles
    // MODIFIES: this
    // EFFECTS: for each article in the catalogue, if readStatus = unread, adds to unreadList
    //          returns the title of each article in the unreadList
    public Collection<Article> getUnreadList() {
        for (Article a : articleList) {
            if (!a.getReadStatus()) {
                unreadList.add(a);
            }
        }
        return unreadList;
    }
}