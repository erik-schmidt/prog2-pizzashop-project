package PizzaShop.View;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * This Object represents a File chooser dialog.
 */
public class OpenDialog extends JFileChooser {

    /**
     * Calls the open file dialog to open a specific file.
     * @return path of selected file.
     */
    public String callOpenFileDialog(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setDialogTitle("Wählen Sie eine Textdatei aus:");
        String rootDir = System.getProperty("user.dir");
        chooser.setSelectedFile(new File(rootDir));
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return (f.getName().toLowerCase().endsWith(".txt"));
            }

            @Override
            public String getDescription() {
                return "txt";
            }
        });
        int ret = chooser.showOpenDialog(this);
        File curFile = null;
        if(ret == JFileChooser.APPROVE_OPTION){
            curFile = chooser.getSelectedFile();
            return curFile.getPath();
        } else {
            return null;
        }
    }

    /**
     * Calls save file dialog to save a file to a specific dictionary.
     * @return path
     */
    public String saveFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return false;
            }

            @Override
            public String getDescription() {
                return "txt";
            }
        });
        chooser.setDialogTitle("Wählen Sie ein Pfad aus:");
        String rootDir = System.getProperty("user.dir");
        chooser.setSelectedFile(new File(rootDir));
        int ret = chooser.showSaveDialog(this);
        File curFile = null;
        if(ret == JFileChooser.APPROVE_OPTION){
            curFile = chooser.getSelectedFile();
            return curFile.getPath();
        } else {
            return null;
        }
    }
}
