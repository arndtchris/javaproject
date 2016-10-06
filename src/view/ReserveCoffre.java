package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Amanite on 06/10/2016.
 */
public class ReserveCoffre extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

}
