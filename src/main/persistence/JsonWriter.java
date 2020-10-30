package persistence;

import java.io.*;

import model.Catalogue;
import org.json.JSONObject;
import ui.CatalogueSystem;

// NOTE: the JsonSerializationDemo project was consulted heavily when designing this class
// the reference project can be found here: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// a writer class for writing JSON representation of the CatalogueSystem to a file
public class JsonWriter {
    private static final int TAB = 4; //note to self: tab is for spacing only
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructor for the JsonWriter (writes file to destination)
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens the writer object for writing to JSON (reads from the specified destination)
    // throws FileNotFoundException if destination file can't be opened

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

   // MODIFIES: this
   // EFFECTS: writes the catalogue object to a JSON file
    public void write(Catalogue c) {
        JSONObject json = c.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes the writer object
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes json string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
