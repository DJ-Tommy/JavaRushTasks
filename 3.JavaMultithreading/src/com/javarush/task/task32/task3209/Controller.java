package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;


    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view1 = new View();
        Controller controller = new Controller(view1);
        view1.setController(controller);
        view1.init();
        controller.init();
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) (new HTMLEditorKit()).createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();
        try {
            (new HTMLEditorKit()).write(stringWriter, document, 0, document.getLength());

        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void setPlainText(String text) {
        try {
            resetDocument();
            StringReader stringReader = new StringReader(text);
            (new HTMLEditorKit()).read(stringReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }


    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("QASWDEFR");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        try {
            view.selectHtmlTab();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new HTMLFileFilter());
            int value = fileChooser.showOpenDialog(view);
            if (value == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                resetDocument();
                view.setTitle(currentFile.getName());
                FileReader fileReader = new FileReader(currentFile);
                (new HTMLEditorKit()).read(fileReader,document,0);
                fileReader.close();
                view.resetUndo();
            }
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void saveDocument() {
        try {
            view.selectHtmlTab();
            if (currentFile == null) {
                saveDocumentAs();
            }
            view.setTitle(currentFile.getName());
            FileWriter fileWriter = new FileWriter(currentFile);
            (new HTMLEditorKit()).write(fileWriter, document, 0, document.getLength());
            fileWriter.close();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void saveDocumentAs() {
        try {
            view.selectHtmlTab();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new HTMLFileFilter());
            int value = fileChooser.showSaveDialog(view);
            if (value == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                saveDocument();
            }
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
}
