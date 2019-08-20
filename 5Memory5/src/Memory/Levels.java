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
 * @author Mosad
 */
public class Levels extends JFrame{
    
   /* public static void main(String[] args) {
        
        Levels ls = new Levels();
    }*/
    
    JButton l1 ;
    JButton l2 ;
    JPanel jp;
    Actions ac;
    
    public Levels(){
        
        l1 = new JButton("Level1");
        l2 = new JButton("Level2");
        jp = new JPanel();
        ac = new Actions();
        
        this.add(jp);
        jp.setLayout(null);
        
        jp.setSize(500, 300);
        
        this.setVisible(true);
        this.setTitle("Levels");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500, 350);
        
        jp.add(l1);
        jp.add(l2);
        
        l1.setBounds(200, 50, 80, 30);
        l2.setBounds(200, 100, 80, 30);
;
        
        l1.addActionListener(ac);
        l2.addActionListener(ac);
        
    }
    
    
    class Actions implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == l1){
                
               Lvl1 smallGame = new Lvl1();
               smallGame.setVisible(true);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);

               
            }
             else{
                
               Lvl2 mediumGame = new Lvl2();
               mediumGame.setVisible(true);
            }
        }
        
        
    }
    
}
