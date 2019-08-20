/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mosatafa Mosad
 */
public class Play extends JFrame{
    
    //dataFields
    JLabel name ;
    JTextField tname;
    JPanel jp;
    JButton go;
    Actions ac;
    public Play(){
        
        name = new JLabel("Name");
        tname = new JTextField();
        jp = new JPanel();
        go = new JButton("Go");
        ac = new Actions();
        //properties 
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(jp);
        this.setVisible(true);
        
        jp.setSize(500, 350);
        jp.setLayout(null);
        jp.add(name);
        jp.add(tname);
        jp.add(go);
        
        name.setBounds(100, 50, 80, 30);
        tname.setBounds(150, 50, 100, 40);
        go.setBounds(150, 110, 50, 25);
        go.addActionListener(ac);
    }
    
    class Actions implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Levels lvs;
            if(e.getSource() == go){
               if(tname.getText() == null)
                   JOptionPane.showMessageDialog(rootPane,"Should enter your name");
               else
                 lvs = new Levels();
            }
        }
        
        
    }
    
    
    
    
    
}
