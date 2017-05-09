package TugasKeduaJava;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Created by Raja T on 5/9/2017.
 */

public class kalkulator2 extends JFrame {
    TextFieldHandler handler = new TextFieldHandler();
    private JTextField display;
    private double arg = 0;
    private String op = "=";
    private boolean start = true;


    public kalkulator2() {
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        add(display, "North");

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4));
        String buttons = "789/456*123-0.=+";
        for (int i = 0; i < buttons.length(); i++)
            addButton(p, buttons.substring(i, i + 1));
        add(p, "Center");
    }

    public static void main(String[] args) {
        kalkulator2 calc = new kalkulator2();
        calc.setTitle("kalkulator2");
        calc.setSize(200, 200);
        calc.setVisible(true);
    }

    private void addButton(Container c, String s) {
        JButton b = new JButton(s);
        c.add(b);
        b.addActionListener(handler);
    }

    public void kalkulator2(double x) {
        if (op.equals("+"))
            arg += x;
        else if (op.equals("-"))
            arg -= x;
        else if (op.equals("*"))
            arg *= x;
        else if (op.equals("/"))
            arg /= x;
        else if (op.equals("="))
            arg = x;
        //hasil ditampilkan
        display.setText("" + arg);
    }

    private class TextFieldHandler implements ActionListener {
        public void actionPerformed( ActionEvent event ) {
            String s = event.getActionCommand();
            if ('0' <= s.charAt(0) && s.charAt(0) <= '9' || s.equals(" ")) {
                if (start)  //pertama kali user menekan button
                    display.setText(s);
                else
                    display.setText(display.getText() + s);
                start = false;
            } else {
                if (start) {
                    if (s.equals("-")) {
                        display.setText(s);
                        start = false;
                    } else
                        op = s;
                } else {         //text pada display diubah menjadi double
                    kalkulator2(Double.parseDouble(display.getText()));
                    op = s;
                    start = true;
                }
            }
        } }
}
