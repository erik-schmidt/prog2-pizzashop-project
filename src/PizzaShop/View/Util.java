package PizzaShop.View;

import java.awt.*;

public class Util {

    public static GridBagConstraints makegbc(int x, int y, int width, int height){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = new Insets(1,1,1,1);
        gbc.weightx = 1;
        gbc.weighty = 1;
        return gbc;
    }
}
