package ui;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Vector;

import model.Article;
import model.Catalogue;
import model.PrimaryArticle;
import persistence.*;


// lots of this code is based on the TableDemo example:
// https://docs.oracle.com/javase/tutorial/uiswing/components/table.html

// the GUI class for the program, extending JPanel

public class CatalogueViewer extends JPanel {
    private boolean debug = false;
    private Catalogue catalogue;
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);
    private static final String JSON_STORE = "./data/catalogue.json";
    static final String addString = "Add Article";
    static final String loadString = "Load Database";
    static final String saveString = "Save Database";
    static final String removeString = "Remove Last Row";
    String[] columnNames = {"Title",
            "First Name of Author",
            "Last Name of Author",
            "Category",
            "Article Unique ID",
            "Read Status"};
    JTable table;
    DefaultTableModel model;
    Object[][] data = {};


    // some of the code for creating buttons is based off the ListDemo project on the java docs:
    // https://docs.oracle.com/javase/tutorial/uiswing/components/list.html

    // EFFECTS: constructor for the catalogue viewer, creates the object
    public  CatalogueViewer() {
        super(new BorderLayout());
        JButton addButton = createAddButton();
        JButton removeButton = createRemoveButton();
        JButton loadButton = createLoadButton();
        JButton saveButton = createSaveButton();

        JPanel buttonPane = createButtonPane(addButton, removeButton, loadButton, saveButton);

        add(buttonPane, BorderLayout.PAGE_END);

        model = new DefaultTableModel(data, columnNames);

        table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (debug) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    // MODIFIES: this, buttonPane
    // EFFECTS: takes in the different buttons as parameters and adds it into a JPanel
    private JPanel createButtonPane(JButton addButton, JButton removeButton, JButton loadButton, JButton saveButton) {
        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(addButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(removeButton);
        buttonPane.add(loadButton);
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(saveButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        return buttonPane;
    }


    // MODIFIES: this, saveButton
    // EFFECTS: helper function to create a save button with corresponding action
    private JButton createSaveButton() {
        JButton saveButton = new JButton(saveString);
        saveButton.setActionCommand(saveString);
        saveButton.setEnabled(true);

        // EFFECTS: defines action for when button is pressed
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                model.fireTableDataChanged();

                writeToJson();
                SoundPlayer sp = new SoundPlayer();
                sp.playSound();
            }
        });
        return saveButton;
    }
    // MODIFIES: this
// EFFECTS: writes the data to a JSON file to be read in later

    private void writeToJson() {
        Catalogue cc = new Catalogue();
        Vector dataVector = model.getDataVector();
        //  String title = ((Vector)dataVector.elementAt(1)).elementAt(5).toString();
        for (int j = 0; j < dataVector.size(); j++) {
            cc.addArticle(new PrimaryArticle(((Vector)dataVector.elementAt(j)).elementAt(0).toString(),
                    ((Vector)dataVector.elementAt(j)).elementAt(1).toString(),
                    ((Vector)dataVector.elementAt(j)).elementAt(2).toString(),
                    ((Vector)dataVector.elementAt(j)).elementAt(3).toString(),
                    ((Vector)dataVector.elementAt(j)).elementAt(4).toString(),
                    Boolean.parseBoolean(((Vector)dataVector.elementAt(j)).elementAt(5).toString())));

            try {
                jsonWriter.open();
                jsonWriter.write(cc);
                jsonWriter.close();
                System.out.println("Saved catalogue entries! JSON can be found at " + JSON_STORE);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to JSON file: " + JSON_STORE);
            }
        }
    }

    // MODIFIES: this, removeButton
    // EFFECTS: helper function to create a remove button with corresponding action
    private JButton createRemoveButton() {
        JButton removeButton = new JButton(removeString);
        removeButton.setActionCommand(removeString);
        removeButton.setEnabled(true);
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.removeRow(model.getRowCount() - 1);
            }
        });
        return removeButton;
    }

    // MODIFIES: this, loadButton
    // EFFECTS: helper function to create a load button with corresponding action
    private JButton createLoadButton() {
        JButton loadButton = new JButton(loadString);
        loadButton.setActionCommand(loadString);
        loadButton.setEnabled(true);
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                data = transformSetTo2dArray(catalogueData.getArticles());
                model = new DefaultTableModel(data, columnNames);
                table.setModel(model);
            }
        });
        return loadButton;
    }

    // MODIFIES: this, addButton
    // EFFECTS: helper function to create an add button with corresponding action
    private JButton createAddButton() {
        JButton addButton = new JButton(addString);
        addButton.setActionCommand(addString);
        addButton.setEnabled(true);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                model.addRow(new Object[]{});
            }
        });
        return addButton;
    }


    Catalogue catalogueData = loadPrevCatalogue();

    // MODIFIES: this
    // EFFECTS: reads in the JSON file and writes to a Catalogue Object
    Catalogue loadPrevCatalogue() {
        try {
            catalogue = jsonReader.read();
            return catalogue;
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
        return catalogue;
    }

    // this next part on how to convert a set to a 2d array, I referenced from this stack overflow post
    // https://stackoverflow.com/questions/41208940/how-do-i-convert-a-set-into-2d-array-in-java
    // Object[][] data = transformSetTo2dArray(catalogueData.getArticles());

    // MODIFIES: this
    // EFFECTS: takes in the Hashset from Catalogue and converts it to 2d array for JTable
    Object[][] transformSetTo2dArray(Collection<Article> articles) {

        if (articles == null) {
            return null;
        }
        Object[][] result = new Object[articles.size()][6];
        int j = 0;
        // iterate the set:
        for (Article article: articles) {
            result[j][0] = article.getTitle();
            result[j][1] = article.getFirstNameAuthor();
            result[j][2] = article.getLastNameAuthor();
            result[j][3] = article.getCategory();
            result[j][4] = article.getUniqueID();
            result[j][5] = article.getReadStatus();
            j++;
        }
        return result;
    }


    // EFFECTS: prints out info for debugging if needed
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }


    // MODIFIES: this
    // effects: instantiates the entire GUI
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CatalogueViewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CatalogueViewer newContentPane = new CatalogueViewer();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    // EFFECTS: main function, runs the program
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

