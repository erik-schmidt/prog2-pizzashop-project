package PizzaShop.View;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Object represents Status panel.
 * Statuspanel is defined with:
 * Status label.
 */
public class StatusPanel extends JPanel {

    private JLabel statusLabel;

    /**
     * Creates Status panel.
     */
    public StatusPanel() {
        statusLabel = new JLabel();
//        this.setMessage(message);
        this.setBorder(new TitledBorder("Status"));
        this.setVisible(true);
    }

    /**
     * Sets the message of the status panel
     * @param message
     */
    public void setMessage(String message){
        if(message == null){
            message = " ";
        }
        this.statusLabel.setText(message);
        this.add(statusLabel);
        this.repaint();
    }
}
