package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import java.util.Collection;
import java.util.HashSet;

// Represents a catalogue system for storing journal articles.
// Contains a list (hashset) of articles.

// NOTE: the IntegerSetInterface code from the CPSC210 project files was consulted quite often when writing this class
// link: https://github.com/UBCx-Software-Construction/TPD-lecture-starters/tree/master/IntegerSetInterface3

public class Catalogue implements Writable {
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

    /*
    // EFFECTS: returns the article specified by uniqueID input
    //TODO: need to fix this method
    public Article getArticle(String uniqueID) {
        Article desiredArticle = null;
        for (Article a : articleList) {
            if (a.getUniqueID().equals(uniqueID)) {
                desiredArticle = a;
            }
            return desiredArticle;
        }
    }

     */

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

    @Override
    // see Writable interface for specification
    public JSONObject toJson() {
        //TODO: implement this method
        JSONObject json = new JSONObject();
        json.put("articleList", articleListToJson());
       // json.put("unreadList", unreadListToJson());
        return json;
    }

    // EFFECTS: converts articleList to Json Array
    private JSONArray articleListToJson() {
        JSONArray articleListJsonArray = new JSONArray();

        for (Article a : articleList) {
            articleListJsonArray.put(a.toJson());
        }
        return articleListJsonArray;
    }
/* --> this probably isn't needed, since unreadList auto repopulates every time catalogue is instantiated
       but keeping it here for now just in case

    private JSONArray unreadListToJson() {
        JSONArray unreadListJsonArray = new JSONArray();

        for (Article a : unreadList) {
            unreadListJsonArray.put(a.toJson());
        }
        return unreadListJsonArray;
    }
 */
}