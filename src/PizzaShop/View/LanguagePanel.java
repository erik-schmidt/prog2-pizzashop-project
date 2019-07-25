package PizzaShop.View;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * This Object represents a panel to change the language.
 */
public class LanguagePanel extends JPanel {

    private JComboBox<Locale> languageBox;

    /**
     * Sets the Combobox to change the language
     */
    public LanguagePanel() {
        setLayout(new BorderLayout());

        languageBox = new JComboBox<>();
        languageBox.addItem(Locale.GERMAN);
        languageBox.addItem(Locale.ENGLISH);

        this.add(languageBox, BorderLayout.EAST);
    }

    /**
     * @return languageBox
     */
    public JComboBox<Locale> getLanguageBox() {
        return languageBox;
    }
}
