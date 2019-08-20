package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener , KeyListener, MouseListener {

    private JButton bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btdot, btequal, btanswer, btdel, btclear, btadd, btdivid, btmultiply, btsubtract,
	bton, btpi, bte, btsqrt , btrightbracket, btleftbracket;
    private JTextField Txt;
    private boolean isOn = false;
	private int onPressed = 0 , modeChosen = 0;
	private double answer = 0;

    public Calculator() {
        setLayout(null);
        Txt = new JTextField();
        Txt.setBounds(5, 5, 480, 95);
        
        bton = new JButton("on");
        bton.setBounds(5, 105, 90, 75);
      
        btdel = new JButton("<=");
        btdel.setBounds(5, 105, 90, 75);
        btclear = new JButton("clear");
        btrightbracket = new JButton("(");
        btleftbracket = new JButton(")");
        add(Txt);add(bton);add(btdel);add(btclear);add(btrightbracket);add(btleftbracket);
        
        btpi = new JButton("pi");
        bt7 = new JButton("7");
        bt8 = new JButton("8");
        bt9 = new JButton("9");
        btdivid = new JButton("/");
        add(btpi);add(bt7);add(bt8);add(bt9);add(btdivid);
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        bte = new JButton("e");
        bt4 = new JButton("4");
        bt5 = new JButton("5");
        bt6 = new JButton("6");
        btmultiply = new JButton("X");
        add(bte);add(bt4);add(bt5);add(bt6);add(btmultiply);
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        btsqrt = new JButton("√");
        bt1 = new JButton("1");
        bt2 = new JButton("2");
        bt3 = new JButton("3");
        btsubtract = new JButton("-");
        add(btsqrt);add(bt1);add(bt2);add(bt3);add(btsubtract);
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        btanswer = new JButton("Ans");
        bt0 = new JButton("0");
        btdot = new JButton(".");
        btequal = new JButton("=");
        btadd = new JButton("+");
        add(btanswer);add(bt0);add(btdot);add(btequal);add(btadd);
//        
//        btdot.setSize(90, 90);
//        bt0.setSize(90, 90);
//        btdel.setSize(90, 90);
//        btequal.setSize(90, 90);
//        bt1.setSize(90, 90);
//        bt2.setSize(90, 90);
//        bt3.setSize(90, 90);
//        bt4.setSize(90, 90);
//        bt5.setSize(90, 90);
//        bt6.setSize(90, 90);
//        btadd.setSize(50, 50);
//        bt7.setSize(50, 50);
//        bt8.setSize(50, 50);
//        bt9.setSize(50, 50);
//        btclear.setSize(50, 50);
//        btdivid.setSize(50, 50);
//        btmultiply.setSize(50, 50);
//        btsubtract.setSize(50, 50);

        add(btdot);
        add(bt0);
        add(btdel);
        add(btequal);
        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(btadd);
        add(bt7);
        add(bt8);
        add(bt9);
        add(btclear);
        add(btdivid);
        add(btmultiply);
        add(btsubtract);

        btdot.addActionListener(this);
        bt0.addActionListener(this);
        btdel.addActionListener(this);
        btequal.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);
        btadd.addActionListener(this);
        bt7.addActionListener(this);
        bt8.addActionListener(this);
        bt9.addActionListener(this);
        btclear.addActionListener(this);
        btdivid.addActionListener(this);
        btmultiply.addActionListener(this);
        btsubtract.addActionListener(this);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Calculator a = new Calculator();  // Create a frame
        a.setSize(500, 500); // Set the frame size
        a.setResizable(false);
        a.setTitle("Calculator by Mohamed Samir");
        a.setBackground(Color.white);
        a.setLocationRelativeTo(null);  // Center a frame
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exite running on close
        a.setVisible(true);  // Display the frame
        a.Txt.setEditable(false);
        a.Txt.setAlignmentX(0.9F);
        a.Txt.setAlignmentY(0.9F);
        a.Txt.setAutoscrolls(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btdot) {   //Button .
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + ".");
            } else {
                Txt.setText("0.");
            }
        } else if (e.getSource() == bt0) {  //Button 0
            String m = Txt.getText();
            if (Txt != null && m != "0") {
                Txt.setText(m + "0");
            }
            if (m.equals("0")) {
                Txt.setText(null);
            }
        } else if (e.getSource() == btdel) {  //Button negative
            String numbers = Txt.getText();
            Txt.setText(numbers.substring(0, (numbers.length()-1)));
        } else if (e.getSource() == btequal) {  //Button =
            double result = 0;
            String letters = "";
            String zazo = Txt.getText();
            String[] tokens = Txt.getText().split("[/*+-]");
            for (int i = 0; i < zazo.length(); i++) {
                if (zazo.charAt(i) == '+' || zazo.charAt(i) == '-' || zazo.charAt(i) == '*' || zazo.charAt(i) == '/' || zazo.charAt(i) == 'n') {
                    letters += zazo.charAt(i);
                }
            }
            for (int i = 0; i < letters.length(); i++) {
                switch (letters.charAt(0)) {
                    case '*':
                        result += Double.parseDouble(tokens[i]) * Double.parseDouble(tokens[i + 1]);
                        break;
                    case '/':
                        result += Double.parseDouble(tokens[i]) / Double.parseDouble(tokens[i + 1]);
                        break;
                    case '-':
                        result += Double.parseDouble(tokens[i]) - Double.parseDouble(tokens[i + 1]);
                        break;
                    case '+':
                        result += Double.parseDouble(tokens[i]) + Double.parseDouble(tokens[i + 1]);
                        break;
                }
                Txt.setText(String.valueOf(result));
            }
        } else if (e.getSource() == bt1) {  //Button 1
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "1");
            } else {
                Txt.setText("1");
            }
        } else if (e.getSource() == bt2) {  //Button 2
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "2");
            } else {
                Txt.setText("2");
            }
        } else if (e.getSource() == bt3) {  //Button 3
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "3");
            } else {
                Txt.setText("3");
            }
        } else if (e.getSource() == bt4) {  //Button 4
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "4");
            } else {
                Txt.setText("4");
            }
        } else if (e.getSource() == bt5) {   //Button 5
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "5");
            } else {
                Txt.setText("5");
            }
        } else if (e.getSource() == bt6) {  //Button 6
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "6");
            } else {
                Txt.setText("6");
            }
        } else if (e.getSource() == btadd) {  //Button +
            String m = Txt.getText();
            if (Txt != null && m != "0") {
                Txt.setText(m + "+");
            }
        } else if (e.getSource() == bt7) {  //Button 7
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "7");
            } else {
                Txt.setText("7");
            }
        } else if (e.getSource() == bt8) {  //Button 8
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "8");
            } else {
                Txt.setText("8");
            }
        } else if (e.getSource() == bt9) {  //Button 9
            if (Txt != null) {
                String m = Txt.getText();
                Txt.setText(m + "9");
            } else {
                Txt.setText("9");
            }
        } else if (e.getSource() == btclear) {  //Button clear
            Txt.setText(null);
        } else if (e.getSource() == btdivid) {  //Button -
            String m = Txt.getText();
            if (Txt != null && m != "0") {
                Txt.setText(m + "/");
            }
        } else if (e.getSource() == btmultiply) {  //Button *
            String m = Txt.getText();
            if (Txt != null && m != "0") {
                Txt.setText(m + "*");
            }
        } else if (e.getSource() == btsubtract) {  //Button -
            String m = Txt.getText();
            if (Txt != null && m != "0") {
                Txt.setText(m + "-");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
