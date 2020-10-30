package persistence;

import model.PrimaryArticle;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Article;
import model.Catalogue;

// NOTE: the JsonSerializationDemo project was consulted heavily when designing this class
// the reference project can be found here: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonReader {
    private String source;

    // EFFECTS: constructor for the JsonReader class. Constructs a reader to  read file from source
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads catalogue from file and returns it;
    // throws an IOException if an error occurs reading data from file
    public Catalogue read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCatalogue(jsonObject);
    }

    // EFFECTS: reads source param as string, then returns the string
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses Catalogue from JSON object param, then returns it as Catalogue
    private Catalogue parseCatalogue(JSONObject jsonObject) {

        // String title = jsonObject.getString(); ---> I don't think this is needed
        Catalogue catalogue = new Catalogue();
        addArticlesToArticleList(catalogue, jsonObject);
        //addArticlesToUnreadList(catalogue, jsonObject);
        return catalogue;
    }

    // MODIFIES: catalogue
    // EFFECTS: parses the articles from the JSON object, then adds them to the catalogue articleList
    private void addArticlesToArticleList(Catalogue catalogue, JSONObject jsonObject) {
        JSONArray articleListJsonArray = jsonObject.getJSONArray("articleList");

        for (Object json : articleListJsonArray) {
            JSONObject nextArticle = (JSONObject) json;
            addArticle(catalogue, nextArticle);
        }
    }

    /* actually, we might not need this, since unreadList will auto repopulate every time getUnreadList is called
    // MODIFIES: catalogue
    // EFFECTS: parses unread articles from JSON object, then adds them to catalogue unreadList
    private void addArticlesToUnreadList(Catalogue catalogue, JSONObject jsonObject) {
        JSONArray unreadListJsonArray = jsonObject.getJSONArray("unreadList");

        for (Object json : unreadListJsonArray) {
            JSONObject nextArticle = (JSONObject) json;
            addUnreadArticle(catalogue, nextArticle);
        }
    }

     */

    // MODIFIES: catalogue
    // EFFECTS: parses articles from JSON object and adds it to catalogue

    private void addArticle(Catalogue catalogue, JSONObject jsonObject) {

        String title = jsonObject.getString("title");
        String firstNameAuthor = jsonObject.getString("firstNameAuthor");
        String lastNameAuthor = jsonObject.getString("lastNameAuthor");
        String category = jsonObject.getString("category");
        boolean readStatus = jsonObject.getBoolean("readStatus");
        String uniqueID = jsonObject.getString("uniqueID");
        Article article = new PrimaryArticle(title, firstNameAuthor, lastNameAuthor, category, uniqueID);

        // if current readStatus is true, then it sets the read status to true. Otherwise, by default it is false
        if (readStatus) {
            article.setReadStatus();
        }
        catalogue.addArticle(article);
    }
}
    /*
    // MODIFIES: catalogue
    // EFFECTS: parses unread articles from JSON object and adds it to catalogue

    private void addUnreadArticle(Catalogue catalogue, JSONObject jsonObject) {

        String title = jsonObject.getString("title");
        String  author first name;
        String author last name;
        String readStatus;
        String article = new Article(title, )
    }

     */


