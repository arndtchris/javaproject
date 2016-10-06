package view;

import javacesi.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Amanite on 06/10/2016.
 */
public class ReserveCoffre extends JPanel{

    public ReserveCoffre() {

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

    public void reserver(ClientBanque client, Coffre coffre)
    {
        Parse parser = new Parse();
        Coffre c = new Coffre();
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Réserver un Coffre");
        ReserveCoffre view = new ReserveCoffre();
        view.setLayout(new GridLayout(0, 1, 20, 20));
        frame.add(view);

        Parse parser = new Parse();
        ArrayList<OperationXML> ops = parser.parseOperation();

        ArrayList<String> coffres = new ArrayList<String>();
        coffres.add("Sélectionnez un coffre");
        for (OperationXML op : ops) {
            coffres.add(op.TypeCoffre);
        }
        final JLabel field = new JLabel();
        field.setSize(200, 50);
        field.setText("              ");

        String[] stockArr = new String[coffres.size()];
        stockArr = coffres.toArray(stockArr);

        JComboBox<String> combo = new JComboBox<String>(stockArr);
        view.add(combo);

        combo.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (OperationXML o : ops){
                    if(Objects.equals(o.TypeCoffre, combo.getSelectedItem().toString()))
                    {
                        System.out.print("test");
                        JLabel label1 = new JLabel("Test");
                        field.setText("Periode de location : " + o.PrixPeriode + "\n Prix par période : " + o.PrixPeriode);
                    }
                }
            }
        });

        JButton OKButton = new JButton("OK");

        OKButton.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OperationXML o = new OperationXML();

            }
        });

        view.add(OKButton);
        view.add(field);

        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
