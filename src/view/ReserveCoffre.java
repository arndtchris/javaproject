package view;

import javacesi.*;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Amanite on 06/10/2016.
 */
public class ReserveCoffre extends JPanel{

    public ReserveCoffre(GridLayout gridLayout) {

    }

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

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Réserver un Coffre");
        ReserveCoffre view = new ReserveCoffre(new GridLayout(4,4,4,4));
        frame.add(view);

        Parse parser = new Parse();
        ArrayList<OperationXML> ops = parser.parseOperation();

        ArrayList<String> coffres = new ArrayList<String>();

        for (OperationXML op : ops) {
            coffres.add(op.TypeCoffre);
        }

        String[] stockArr = new String[coffres.size()];
        stockArr = coffres.toArray(stockArr);

        JComboBox<String> petList = new JComboBox<String>(stockArr);
        view.add(petList,BorderLayout.NORTH);

        JButton OKButton = new JButton("OK");
        view.add(OKButton,BorderLayout.CENTER);

        JLabel label1 = new JLabel("Test");

        label1.setText("Frais de garde : ");

        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
