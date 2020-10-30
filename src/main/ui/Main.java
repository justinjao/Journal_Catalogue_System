package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        try {
            new CatalogueSystem();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to load catalogue - file wasn't found!");
        }
    }
}

