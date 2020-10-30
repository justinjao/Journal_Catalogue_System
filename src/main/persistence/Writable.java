package persistence;

import org.json.JSONObject;

// represents an interface for objects that can be written out to a JSON file
public interface Writable {
    // EFFECTS: return this as a JSON object
    JSONObject toJson();
}
