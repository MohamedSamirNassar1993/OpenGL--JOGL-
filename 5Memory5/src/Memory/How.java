/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memory;

import javax.swing.*;

/**
 *
 * @author Mosatafa Mosad
 */
public class How extends JFrame{
    
    JLabel how;
    JPanel jp;
    
    public How(){
        
        how = new JLabel();
        jp = new JPanel();
        
        //properties
        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("How To Play");
        this.setVisible(true);
        this.add(jp);
        
        jp.setSize(500, 300);
        jp.setLayout(null);
        jp.add(how);
        
        how.setBounds(0, 100, 300, 30);
        how.setText("    Your goal to find all same photos in Limited time   ");
    }
    
}
