package PizzaShop.View;

import javax.swing.*;
import java.awt.*;

/**
 * Object presents the main frame.
 * Main frame is defined with:
 * center panel, status panel and menubar.
 */
public class MyPizzaShop extends JFrame {

    private JPanel centerPanel;
    private LanguagePanel languagePanel;
    private StatusPanel statusPanel;
    private MyMenuBar myMenuBar;
    private String myPath;

    /**
     * Creates the main frame.
     */
    public MyPizzaShop() {
        super("Pizza Shop");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myMenuBar = new MyMenuBar();
        this.setJMenuBar(myMenuBar);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        this.languagePanel = new LanguagePanel();
        this.centerPanel = new JPanel();
        this.statusPanel = new StatusPanel();
        setStatusLabel("Willkommen!");

        container.add(languagePanel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(statusPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        this.setVisible(true);

    }

    /**
     * Sets a given panel in the center.
     * @param newCenter
     */
    public void setCenterPanel(JPanel newCenter){
        centerPanel.removeAll();
        centerPanel.add(newCenter);
        this.repaint();
        this.revalidate();
    }

    /**
     * sets the text of the status panel.
     * @param message
     */
    public void setStatusLabel(String message){
        statusPanel.setMessage(message);
    }

    /**
     * @return menubar
     */
    public MyMenuBar getMyMenuBar(){
        return myMenuBar;
    }

    /**
     * @return myPath
     */
    public String getMyPath() {
        return myPath;
    }

    /**
     * Sets the path for files.
     * @param path
     */
    public void setMyPath(String path) {
        this.myPath = path;
    }

    /**
     * @return languagePanel
     */
    public LanguagePanel getLanguagePanel(){
        return languagePanel;
    }
}
