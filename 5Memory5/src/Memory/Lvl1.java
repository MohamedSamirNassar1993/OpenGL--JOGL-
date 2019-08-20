package Memory;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Abdu
 */
public class Lvl1 extends javax.swing.JFrame {


    public Lvl1() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")

    private void initComponents() {

        Tile11 = new javax.swing.JButton();
        Tile14 = new javax.swing.JButton();
        Tile12 = new javax.swing.JButton();
        Tile13 = new javax.swing.JButton();
        Tile22 = new javax.swing.JButton();
        Tile23 = new javax.swing.JButton();
        Tile21 = new javax.swing.JButton();
        Tile24 = new javax.swing.JButton();
        Tile31 = new javax.swing.JButton();
        Tile32 = new javax.swing.JButton();
        Tile41 = new javax.swing.JButton();
        Tile42 = new javax.swing.JButton();
        Tile43 = new javax.swing.JButton();
        Tile44 = new javax.swing.JButton();
        Tile33 = new javax.swing.JButton();
        Tile34 = new javax.swing.JButton();
        ScoreScreen = new javax.swing.JTextField();
        ScoreScreenLabel = new javax.swing.JLabel();
        startGameButton = new javax.swing.JButton();
        QuitButton = new javax.swing.JButton();
        DebugCheck = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        QuitMenuItem = new javax.swing.JMenuItem();
        GameMenu = new javax.swing.JMenu();
        resetBoardMenuItem = new javax.swing.JMenuItem();
        enableDebug = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Level 1");
        setResizable(false);

        Tile11.setEnabled(false);
        Tile11.setFocusable(false);
        Tile11.setMaximumSize(new java.awt.Dimension(32, 10));
        Tile11.setMinimumSize(new java.awt.Dimension(32, 10));
        Tile11.setPreferredSize(new java.awt.Dimension(30, 10));
        Tile11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile11ActionPerformed(evt);
            }
        });

        Tile14.setEnabled(false);
        Tile14.setFocusable(false);
        Tile14.setName("");
        Tile14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile14ActionPerformed(evt);
            }
        });

        Tile12.setEnabled(false);
        Tile12.setFocusable(false);
        Tile12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile12ActionPerformed(evt);
            }
        });

        Tile13.setEnabled(false);
        Tile13.setFocusable(false);
        Tile13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile13ActionPerformed(evt);
            }
        });

        Tile22.setEnabled(false);
        Tile22.setFocusable(false);
        Tile22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile22ActionPerformed(evt);
            }
        });

        Tile23.setEnabled(false);
        Tile23.setFocusable(false);
        Tile23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile23ActionPerformed(evt);
            }
        });

        Tile21.setEnabled(false);
        Tile21.setFocusable(false);
        Tile21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile21ActionPerformed(evt);
            }
        });

        Tile24.setEnabled(false);
        Tile24.setFocusable(false);
        Tile24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile24ActionPerformed(evt);
            }
        });

        Tile31.setEnabled(false);
        Tile31.setFocusable(false);
        Tile31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile31ActionPerformed(evt);
            }
        });

        Tile32.setEnabled(false);
        Tile32.setFocusable(false);
        Tile32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile32ActionPerformed(evt);
            }
        });

        Tile41.setEnabled(false);
        Tile41.setFocusable(false);
        Tile41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile41ActionPerformed(evt);
            }
        });

        Tile42.setEnabled(false);
        Tile42.setFocusable(false);
        Tile42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile42ActionPerformed(evt);
            }
        });

        Tile43.setEnabled(false);
        Tile43.setFocusable(false);
        Tile43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile43ActionPerformed(evt);
            }
        });

        Tile44.setEnabled(false);
        Tile44.setFocusable(false);
        Tile44.setVerifyInputWhenFocusTarget(false);
        Tile44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile44ActionPerformed(evt);
            }
        });

        Tile33.setEnabled(false);
        Tile33.setFocusable(false);
        Tile33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile33ActionPerformed(evt);
            }
        });

        Tile34.setEnabled(false);
        Tile34.setFocusable(false);
        Tile34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tile34ActionPerformed(evt);
            }
        });

        ScoreScreen.setEditable(false);
        ScoreScreen.setBackground(new java.awt.Color(204, 204, 255));
        ScoreScreen.setFont(new java.awt.Font("Dialog", 0, 24));
        ScoreScreen.setText("0");
        ScoreScreen.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ScoreScreen.setEnabled(false);
        ScoreScreen.setFocusable(false);

        ScoreScreenLabel.setFont(new java.awt.Font("FreeSerif", 1, 14));
        ScoreScreenLabel.setText("SCORE:");

        startGameButton.setText("START");
        startGameButton.setToolTipText("");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        QuitButton.setText("QUIT");
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });

        DebugCheck.setText("Debug");
        DebugCheck.setToolTipText("");
        DebugCheck.setEnabled(false);

        FileMenu.setText("File");

        QuitMenuItem.setText("Quit");
        QuitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(QuitMenuItem);

        jMenuBar1.add(FileMenu);

        GameMenu.setText("Game");

        resetBoardMenuItem.setText("Reset Board");
        resetBoardMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBoardMenuItemActionPerformed(evt);
            }
        });
        GameMenu.add(resetBoardMenuItem);

        enableDebug.setText("Enable debugging");
        enableDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enableDebugActionPerformed(evt);
            }
        });
        GameMenu.add(enableDebug);

        jMenuBar1.add(GameMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DebugCheck)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Tile21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tile22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tile23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tile24, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Tile11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tile12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tile13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tile14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Tile41, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(Tile31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Tile42, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Tile43, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Tile44, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Tile32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Tile33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Tile34, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ScoreScreenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ScoreScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(startGameButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(QuitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScoreScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(ScoreScreenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(startGameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QuitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tile13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tile22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tile33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile31, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tile41, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile42, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile43, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tile44, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(DebugCheck)
                .addContainerGap())
        );

        pack();
    }
    
    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        PrevID_Guess1 = 100;
        PrevID_Guess2 = 100;
        ID_Guess1 = 100;
        ID_Guess2 = 100;
        match = false;
        count = 0;
        score = 0;

        
        ScoreScreen.setText(Integer.toString(score));
        
        Tile11.setEnabled(true);
        Tile12.setEnabled(true);
        Tile13.setEnabled(true);
        Tile14.setEnabled(true);
        Tile21.setEnabled(true);
        Tile22.setEnabled(true);
        Tile23.setEnabled(true);
        Tile24.setEnabled(true);
        Tile31.setEnabled(true);
        Tile32.setEnabled(true);
        Tile33.setEnabled(true);
        Tile34.setEnabled(true);
        Tile41.setEnabled(true);
        Tile42.setEnabled(true);
        Tile43.setEnabled(true);
        Tile44.setEnabled(true);
        
        wipeBoard();
        
        tileControl.initShuffle4x4Tiles();
        for (int i = 0; i<= 15; i++){
            int type = tileControl.get4x4TileType(i);

            if (DebugCheck.isSelected()){
                showTileShape(i, type);
            }
        }
        
        flashShapes();
    }

    private void Tile11ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 0;
        int type;
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }

    private void Tile12ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 1;
        int type;
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }

   
    private void Tile13ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 2;
        int type;
         
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }

    private void Tile14ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 3;
        int type;
         
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }
    
    private void Tile21ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 4;
        int type;
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }

    private void Tile22ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 5;
        int type;
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }

    private void Tile23ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 6;
        int type;
       
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }
    private void Tile24ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 7;
        int type;
             
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }
    
    private void Tile31ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 8;
        int type;
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }
    private void Tile32ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 9;
        int type;   
       
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }
    
    private void Tile33ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 10;
        int type;
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }

    private void Tile34ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 11;
        int type;
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }
    
    private void Tile41ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 12;
        int type;      
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }
    
    private void Tile42ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 13;
        int type;
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }
    
    private void Tile43ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 14;
        int type;
          
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }


    private void Tile44ActionPerformed(java.awt.event.ActionEvent evt) {
        int ID = 15;
        int type;   
        
        type = tileControl.get4x4TileType(ID);
        buttonPress(ID, type);
    }

    private void QuitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        resetBoardMenuItemActionPerformed(evt);
        this.dispose();
    }
    
    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        QuitMenuItemActionPerformed(evt);
    }

    private void resetBoardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        wipeBoard();
        PrevID_Guess1 = 100;
        PrevID_Guess2 = 100;
        ID_Guess1 = 100;
        ID_Guess2 = 100;
        match = false;
        count = 0;
        score = 0;
        sScore = "0";
        ScoreScreen.setText(sScore);

        
        buttonEnabledSwitch(false, 0);
        buttonEnabledSwitch(false, 1);
        buttonEnabledSwitch(false, 2);
        buttonEnabledSwitch(false, 3);
        buttonEnabledSwitch(false, 4);
        buttonEnabledSwitch(false, 5);
        buttonEnabledSwitch(false, 6);
        buttonEnabledSwitch(false, 7);
        buttonEnabledSwitch(false, 8);
        buttonEnabledSwitch(false, 9);
        buttonEnabledSwitch(false, 10);
        buttonEnabledSwitch(false, 11);
        buttonEnabledSwitch(false, 12);
        buttonEnabledSwitch(false, 13);
        buttonEnabledSwitch(false, 14);
        buttonEnabledSwitch(false, 15);
        
        DebugCheck.setEnabled(false);
    }


    private void enableDebugActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            String passphrase = JOptionPane.showInputDialog(rootPane, null, "enter passphrase");
            if (passphrase.equals("rzqxx5gv")){
                DebugCheck.setEnabled(true);
            }
        }
        catch(NullPointerException e){
            System.out.println("error: " + e);
        }
    }
    private void showTileShape(int ID, int type){

        ArrayList<ImageIcon> shapes = new ArrayList();
        shapes.add(Circle);
        shapes.add(Cross);
        shapes.add(Diamond);
        shapes.add(Donut);
        shapes.add(Eclipse);
        shapes.add(Square);
        shapes.add(Star);
        shapes.add(X);

        switch(ID){
            case 0: 
                Tile11.setIcon(shapes.get(type));
                break;
            case 1:
                Tile12.setIcon(shapes.get(type));
                break;
            case 2:
                Tile13.setIcon(shapes.get(type));
                break;
            case 3:
                Tile14.setIcon(shapes.get(type));
                break;
            case 4:
                Tile21.setIcon(shapes.get(type));
                break;
            case 5:
                Tile22.setIcon(shapes.get(type));
                break;
            case 6:
                Tile23.setIcon(shapes.get(type));
                break;
            case 7:
                Tile24.setIcon(shapes.get(type));
                break;
            case 8:
                Tile31.setIcon(shapes.get(type));
                break;
            case 9:
                Tile32.setIcon(shapes.get(type));
                break;
            case 10:
                Tile33.setIcon(shapes.get(type));
                break;
            case 11:
                Tile34.setIcon(shapes.get(type));
                break;
            case 12:
                Tile41.setIcon(shapes.get(type));
                break;
            case 13:
                Tile42.setIcon(shapes.get(type));
                break;
            case 14:
                Tile43.setIcon(shapes.get(type));
                break;
            case 15:
                Tile44.setIcon(shapes.get(type));
                break;
        }
    }
    
    private void wipeBoard(){
        Tile11.setIcon(Blank);
        Tile12.setIcon(Blank);
        Tile13.setIcon(Blank);
        Tile14.setIcon(Blank);
        Tile21.setIcon(Blank);
        Tile22.setIcon(Blank);
        Tile23.setIcon(Blank);
        Tile24.setIcon(Blank);
        Tile31.setIcon(Blank);
        Tile32.setIcon(Blank);
        Tile33.setIcon(Blank);
        Tile34.setIcon(Blank);
        Tile41.setIcon(Blank);
        Tile42.setIcon(Blank);
        Tile43.setIcon(Blank);
        Tile44.setIcon(Blank);
    }
    

    private boolean testMatch(int type1, int type2){
        boolean match = false;
        
        if (type1 == type2){
            match = true;
        }
        
        return match;
    }

    private void hideSelectedTile(int ID){
        switch(ID){
            case 0:
                Tile11.setIcon(Blank);
                break;
            case 1:
                Tile12.setIcon(Blank);
                break;
            case 2:
                Tile13.setIcon(Blank);
                break;
            case 3: 
                Tile14.setIcon(Blank);
                break;
            case 4:
                Tile21.setIcon(Blank);
                break;
            case 5:
                Tile22.setIcon(Blank);
                break;
            case 6:
                Tile23.setIcon(Blank);
                break;
            case 7:
                Tile24.setIcon(Blank);
                break;
            case 8:
                Tile31.setIcon(Blank);
                break;
            case 9:
                Tile32.setIcon(Blank);
                break;
            case 10:
                Tile33.setIcon(Blank);
                break;
            case 11:
                Tile34.setIcon(Blank);
                break;
            case 12:
                Tile41.setIcon(Blank);
                break;
            case 13:
                Tile42.setIcon(Blank);
                break;
            case 14:
                Tile43.setIcon(Blank);
                break;
            case 15:
                Tile44.setIcon(Blank);
                break;       
        }
    }
    
    private void buttonEnabledSwitch(boolean state, int ID){
        switch(ID){
            case 0:
                Tile11.setEnabled(state);
                break;
            case 1:
                Tile12.setEnabled(state);
                break;
            case 2:
                Tile13.setEnabled(state);
                break;
            case 3:
                Tile14.setEnabled(state);
                break;
            case 4:
                Tile21.setEnabled(state);
                break;
            case 5:
                Tile22.setEnabled(state);
                break;
            case 6:
                Tile23.setEnabled(state);
                break;
            case 7:
                Tile24.setEnabled(state);
                break;
            case 8:
                Tile31.setEnabled(state);
                break;
            case 9:
                Tile32.setEnabled(state);
                break;
            case 10:
                Tile33.setEnabled(state);
                break;
            case 11:
                Tile34.setEnabled(state);
                break;
            case 12:
                Tile41.setEnabled(state);
                break;
            case 13:
                Tile42.setEnabled(state);
                break;
            case 14:
                Tile43.setEnabled(state);
                break;
            case 15:
                Tile44.setEnabled(state);
                break;    
        }                
    }
    
    private void checkEndGame(){
        if (!Tile11.isEnabled() && !Tile12.isEnabled() && !Tile13.isEnabled() && !Tile14.isEnabled() && 
                !Tile21.isEnabled() && !Tile22.isEnabled() && !Tile23.isEnabled() && !Tile24.isEnabled() &&
                !Tile31.isEnabled() && !Tile32.isEnabled() && !Tile33.isEnabled() && !Tile34.isEnabled() &&
                !Tile41.isEnabled() && !Tile42.isEnabled() && !Tile43.isEnabled() && !Tile44.isEnabled()){
        
            
          
               if (score > 0){
                JOptionPane.showMessageDialog(rootPane,
                "                        Congratulations!        \n"
                + "You Win! with score : " + score + " Go to Level2");
               

                
                Lvl2 level2 = new Lvl2();
                level2.setVisible(true);
                Lvl1 level1 = new Lvl1();
                level1.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(rootPane,
                "                               Nice Try!\n"
                + "You need a score greater than 0 to win.  Try again!", 
                "You Lose!", 
                WIDTH, LOSS);
            }
        }
    }
    
    private void buttonPress(int ID, int type){
        if (count == 0){
            showTileShape(ID, type);
            ID_Guess1 = ID;
            type_Guess1 = type;
            count++;
            

            if (!match){
                hideSelectedTile(PrevID_Guess1);
                hideSelectedTile(PrevID_Guess2);
            }
        }
        else if (count == 1){
            showTileShape(ID, type);
            ID_Guess2 = ID;
            type_Guess2 = type;
            PrevID_Guess1 = ID_Guess1;
            PrevID_Guess2 = ID_Guess2;
            
            
            if (ID_Guess1 == ID_Guess2){
                JOptionPane.showMessageDialog(
                    rootPane,
                    "You cannot pick the same tile twice.\n" + 
                    "That's considered cheating. Pick 2 distinct tiles.", 
                    "Invalid Move", WIDTH, null
                );
                hideSelectedTile(ID_Guess1);
                ID_Guess1 = 100;
                ID_Guess2 = 100;
                PrevID_Guess1 = 100;
                PrevID_Guess2 = 100;
                buttonEnabledSwitch(true,ID_Guess1);
            }
            else {
                match = testMatch(type_Guess1, type_Guess2);

                if (!match){
                    score = score - 2;
                    sScore = Integer.toString(score);
                    ScoreScreen.setText(sScore);
                }
                else{
                    score = score + 5;
                    sScore = Integer.toString(score);
                    ScoreScreen.setText(sScore);

                    buttonEnabledSwitch(false, ID_Guess1);
                    buttonEnabledSwitch(false, ID_Guess2);
                    
                    checkEndGame();
                }
            }
            count = 0;
        }  
    }

    private void flashShapes(){
        Thread thread = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i<= 15; i++){
                        int type = tileControl.get4x4TileType(i);
                        showTileShape(i, type);
                    }
                    Thread.sleep(800);
                    if (!DebugCheck.isSelected()){
                        wipeBoard();
                    }
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(Lvl1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start(); 
    }

    private javax.swing.JCheckBox DebugCheck;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu GameMenu;
    private javax.swing.JButton QuitButton;
    private javax.swing.JMenuItem QuitMenuItem;
    private javax.swing.JTextField ScoreScreen;
    private javax.swing.JLabel ScoreScreenLabel;
    private javax.swing.JButton Tile11;
    private javax.swing.JButton Tile12;
    private javax.swing.JButton Tile13;
    private javax.swing.JButton Tile14;
    private javax.swing.JButton Tile21;
    private javax.swing.JButton Tile22;
    private javax.swing.JButton Tile23;
    private javax.swing.JButton Tile24;
    private javax.swing.JButton Tile31;
    private javax.swing.JButton Tile32;
    private javax.swing.JButton Tile33;
    private javax.swing.JButton Tile34;
    private javax.swing.JButton Tile41;
    private javax.swing.JButton Tile42;
    private javax.swing.JButton Tile43;
    private javax.swing.JButton Tile44;
    private javax.swing.JMenuItem enableDebug;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem resetBoardMenuItem;
    private javax.swing.JButton startGameButton;


    Control tileControl = new Control();
   
    ImageIcon Circle    = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/Circle.png"));
    ImageIcon Cross     = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/Cross.png"));
    ImageIcon Diamond   = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/Diamond.png"));
    ImageIcon Donut     = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/Donut.png"));
    ImageIcon Eclipse   = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/Eclipse.png"));
    ImageIcon Square    = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/Square.png"));
    ImageIcon Star      = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/Star.png"));
    ImageIcon X         = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/X.png"));
    ImageIcon Blank     = new javax.swing.ImageIcon(getClass().getResource("/Memory/MGshapes/blankTile.png"));
    ImageIcon WIN       = new javax.swing.ImageIcon(getClass().getResource("/Memory/win-loss/WIN.png"));
    ImageIcon LOSS      = new javax.swing.ImageIcon(getClass().getResource("/Memory/win-loss/LOSS.png"));
    
    int count = 0;                              
    int ID_Guess1 = 100, ID_Guess2 = 100;       
    int type_Guess1, type_Guess2;               
    boolean match;                             
    int score;                                  
    String sScore;                              
    int PrevID_Guess1;                         
    int PrevID_Guess2;                          

}
