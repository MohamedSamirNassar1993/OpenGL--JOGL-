package aaa;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.UIManager;

public class kyboard extends javax.swing.JFrame implements KeyListener {

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea Txt;
    private javax.swing.JButton bt0;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton btA;
    private javax.swing.JButton btB;
    private javax.swing.JButton btC;
    private javax.swing.JButton btD;
    private javax.swing.JButton btE;
    private javax.swing.JButton btEnter;
    private javax.swing.JButton btF;
    private javax.swing.JButton btG;
    private javax.swing.JButton btH;
    private javax.swing.JButton btI;
    private javax.swing.JButton btJ;
    private javax.swing.JButton btK;
    private javax.swing.JButton btL;
    private javax.swing.JButton btM;
    private javax.swing.JButton btN;
    private javax.swing.JButton btO;
    private javax.swing.JButton btP;
    private javax.swing.JButton btQ;
    private javax.swing.JButton btR;
    private javax.swing.JButton btS;
    private javax.swing.JButton btT;
    private javax.swing.JButton btTab;
    private javax.swing.JButton btU;
    private javax.swing.JButton btV;
    private javax.swing.JButton btW;
    private javax.swing.JButton btX;
    private javax.swing.JButton btY;
    private javax.swing.JButton btZ;
    private javax.swing.JButton btbachslash;
    private javax.swing.JButton btbackspace;
    private javax.swing.JButton btcaps;
    private javax.swing.JButton btcoma;
    private javax.swing.JButton btcomma;
    private javax.swing.JButton btdot;
    private javax.swing.JButton btdown;
    private javax.swing.JButton btleft;
    private javax.swing.JButton btleftinterval;
    private javax.swing.JButton btnegative;
    private javax.swing.JButton btpositive;
    private javax.swing.JButton btquestionmark;
    private javax.swing.JButton btright;
    private javax.swing.JButton btrightinterval;
    private javax.swing.JButton btsemicomma;
    private javax.swing.JButton btshift;
    private javax.swing.JButton btspace;
    private javax.swing.JButton btsymbol;
    private javax.swing.JButton btup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration              

    Map<Integer, JButton> map = new HashMap<>();
    JButton myB[] = new JButton[2];
    String strText = "";
    int keycode;
//    myB[1]= bt0 ;

    /**
     * Creates new form keyboard
     */
    public kyboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        btsymbol = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt0 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        btnegative = new javax.swing.JButton();
        btbackspace = new javax.swing.JButton();
        btpositive = new javax.swing.JButton();
        btTab = new javax.swing.JButton();
        btQ = new javax.swing.JButton();
        btW = new javax.swing.JButton();
        btE = new javax.swing.JButton();
        btR = new javax.swing.JButton();
        btT = new javax.swing.JButton();
        btY = new javax.swing.JButton();
        btU = new javax.swing.JButton();
        btI = new javax.swing.JButton();
        btO = new javax.swing.JButton();
        btP = new javax.swing.JButton();
        btleftinterval = new javax.swing.JButton();
        btrightinterval = new javax.swing.JButton();
        btbachslash = new javax.swing.JButton();
        btcaps = new javax.swing.JButton();
        btA = new javax.swing.JButton();
        btS = new javax.swing.JButton();
        btD = new javax.swing.JButton();
        btF = new javax.swing.JButton();
        btG = new javax.swing.JButton();
        btH = new javax.swing.JButton();
        btK = new javax.swing.JButton();
        btJ = new javax.swing.JButton();
        btL = new javax.swing.JButton();
        btsemicomma = new javax.swing.JButton();
        btcomma = new javax.swing.JButton();
        btEnter = new javax.swing.JButton();
        btZ = new javax.swing.JButton();
        btX = new javax.swing.JButton();
        btC = new javax.swing.JButton();
        btV = new javax.swing.JButton();
        btB = new javax.swing.JButton();
        btN = new javax.swing.JButton();
        btM = new javax.swing.JButton();
        btcoma = new javax.swing.JButton();
        btdot = new javax.swing.JButton();
        btquestionmark = new javax.swing.JButton();
        btshift = new javax.swing.JButton();
        btleft = new javax.swing.JButton();
        btup = new javax.swing.JButton();
        btright = new javax.swing.JButton();
        btdown = new javax.swing.JButton();
        btspace = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Txt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Keyboard by Mohamed Samir");
        setBackground(java.awt.Color.black);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("Type some text using your keyboard. The keys you presswill be highlighted and the text will be displayed.");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.red);
        jLabel2.setText("Note : Clicking the buttons with your mouse will not perform any action.");

        bt1.setBackground(java.awt.Color.white);
        bt1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt1.setText("1");

        bt3.setBackground(java.awt.Color.white);
        bt3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt3.setText("3");

        bt4.setBackground(java.awt.Color.white);
        bt4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt4.setText("4");

        btsymbol.setBackground(java.awt.Color.white);
        btsymbol.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btsymbol.setText("~");

        bt5.setBackground(java.awt.Color.white);
        bt5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt5.setText("5");

        bt6.setBackground(java.awt.Color.white);
        bt6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt6.setText("6");

        bt7.setBackground(java.awt.Color.white);
        bt7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt7.setText("7");

        bt9.setBackground(java.awt.Color.white);
        bt9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt9.setText("9");

        bt0.setBackground(java.awt.Color.white);
        bt0.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt0.setText("0");

        bt2.setBackground(java.awt.Color.white);
        bt2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt2.setText("2");

        bt8.setBackground(java.awt.Color.white);
        bt8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bt8.setText("8");

        btnegative.setBackground(java.awt.Color.white);
        btnegative.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnegative.setText("-");

        btbackspace.setBackground(java.awt.Color.white);
        btbackspace.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btbackspace.setText("BackSpace");

        btpositive.setBackground(java.awt.Color.white);
        btpositive.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btpositive.setText("+");

        btTab.setBackground(java.awt.Color.white);
        btTab.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btTab.setText("Tab");

        btQ.setBackground(java.awt.Color.white);
        btQ.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btQ.setText("Q");

        btW.setBackground(java.awt.Color.white);
        btW.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btW.setText("W");

        btE.setBackground(java.awt.Color.white);
        btE.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btE.setText("E");

        btR.setBackground(java.awt.Color.white);
        btR.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btR.setText("R");

        btT.setBackground(java.awt.Color.white);
        btT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btT.setText("T");

        btY.setBackground(java.awt.Color.white);
        btY.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btY.setText("Y");

        btU.setBackground(java.awt.Color.white);
        btU.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btU.setText("U");

        btI.setBackground(java.awt.Color.white);
        btI.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btI.setText("I");

        btO.setBackground(java.awt.Color.white);
        btO.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btO.setText("O");

        btP.setBackground(java.awt.Color.white);
        btP.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btP.setText("P");

        btleftinterval.setBackground(java.awt.Color.white);
        btleftinterval.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btleftinterval.setText("[");

        btrightinterval.setBackground(java.awt.Color.white);
        btrightinterval.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btrightinterval.setText("]");

        btbachslash.setBackground(java.awt.Color.white);
        btbachslash.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btbachslash.setText("\\");

        btcaps.setBackground(java.awt.Color.white);
        btcaps.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btcaps.setText("Caps");

        btA.setBackground(java.awt.Color.white);
        btA.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btA.setText("A");

        btS.setBackground(java.awt.Color.white);
        btS.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btS.setText("S");

        btD.setBackground(java.awt.Color.white);
        btD.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btD.setText("D");

        btF.setBackground(java.awt.Color.white);
        btF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btF.setText("F");

        btG.setBackground(java.awt.Color.white);
        btG.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btG.setText("G");

        btH.setBackground(java.awt.Color.white);
        btH.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btH.setText("H");

        btK.setBackground(java.awt.Color.white);
        btK.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btK.setText("K");

        btJ.setBackground(java.awt.Color.white);
        btJ.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btJ.setText("J");

        btL.setBackground(java.awt.Color.white);
        btL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btL.setText("L");

        btsemicomma.setBackground(java.awt.Color.white);
        btsemicomma.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btsemicomma.setText(":");

        btcomma.setBackground(java.awt.Color.white);
        btcomma.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btcomma.setText("\"");

        btEnter.setBackground(java.awt.Color.white);
        btEnter.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btEnter.setText("Enter");

        btZ.setBackground(java.awt.Color.white);
        btZ.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btZ.setText("Z");

        btX.setBackground(java.awt.Color.white);
        btX.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btX.setText("X");

        btC.setBackground(java.awt.Color.white);
        btC.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btC.setText("C");

        btV.setBackground(java.awt.Color.white);
        btV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btV.setText("V");

        btB.setBackground(java.awt.Color.white);
        btB.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btB.setText("B");

        btN.setBackground(java.awt.Color.white);
        btN.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btN.setText("N");

        btM.setBackground(java.awt.Color.white);
        btM.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btM.setText("M");

        btcoma.setBackground(java.awt.Color.white);
        btcoma.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btcoma.setText(",");

        btdot.setBackground(java.awt.Color.white);
        btdot.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btdot.setText(".");

        btquestionmark.setBackground(java.awt.Color.white);
        btquestionmark.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btquestionmark.setText("?");

        btshift.setBackground(java.awt.Color.white);
        btshift.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btshift.setText("Shift");

        btleft.setBackground(java.awt.Color.white);
        btleft.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btleft.setText("<");

        btup.setBackground(java.awt.Color.white);
        btup.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btup.setText("^");

        btright.setBackground(java.awt.Color.white);
        btright.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btright.setText(">");

        btdown.setBackground(java.awt.Color.white);
        btdown.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btdown.setText("v");

        btspace.setBackground(java.awt.Color.white);
        btspace.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        Txt.setColumns(20);
        Txt.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Txt.setRows(5);
        Txt.addKeyListener(this);
        jScrollPane1.setViewportView(Txt);
        
        for (JButton B : myB) {
            map.put(getKeyCode(B.getText()), B);
        }
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btsymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnegative, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btpositive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btbackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(btTab, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btQ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btU, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btI, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btO, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btleftinterval, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btrightinterval, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(btbachslash, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(btcaps, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btG, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btJ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btsemicomma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btcomma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(btshift, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btZ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(6, 6, 6)
                                                                        .addComponent(btX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(5, 5, 5)
                                                                        .addComponent(btM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btcoma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btdot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(btquestionmark, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addGap(215, 215, 215)
                                                                        .addComponent(btspace, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(btleft, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(btEnter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(btup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(btdown, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(btright, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGap(0, 0, Short.MAX_VALUE))))))
                                .addGap(0, 10, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btsymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnegative, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btbackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btpositive, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btTab, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btQ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btE, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btR, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btY, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btU, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btI, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btO, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btleftinterval, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btrightinterval, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btbachslash, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btcaps, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btG, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btJ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btsemicomma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btcomma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btZ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btcoma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btdot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btquestionmark, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btshift, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btright, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btleft, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btdown, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btspace, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(kyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kyboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kyboard().setVisible(true);
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        strText = String.format("%s", e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keycode = e.getKeyCode();
        strText = String.format("%s", KeyEvent.getKeyText(e.getKeyCode()));
        JButton btn = map.get(keycode);
        if (btn != null) {
            map.get(keycode).setBackground(Color.RED);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keycode = e.getKeyCode();
        strText = String.format("%s", KeyEvent.getKeyText(e.getKeyCode()));
        JButton btn = map.get(keycode);
        if (btn != null) {
            map.get(keycode).setBackground(Color.white);
        }
    }

    private int getKeyCode(String key) {

        switch (key) {
            case "BackSpace":
                return KeyEvent.VK_BACK_SPACE;
            case "Tab":
                return KeyEvent.VK_TAB;
            case "Caps":
                return KeyEvent.VK_CAPS_LOCK;
            case "Enter":
                return KeyEvent.VK_ENTER;
            case "Shift":
                return KeyEvent.VK_SHIFT;
            case "":
                return KeyEvent.VK_SPACE;
            case "+":
                return KeyEvent.VK_EQUALS;
            case ":":
                return KeyEvent.VK_SEMICOLON;
            case "\"":
                return KeyEvent.VK_QUOTE;
            case "?":
                return KeyEvent.VK_SLASH;
            case "~":
                return KeyEvent.VK_BACK_QUOTE;
            case "^":
                return KeyEvent.VK_UP;
            case "v":
                return KeyEvent.VK_DOWN;
            case "<":
                return KeyEvent.VK_LEFT;
            case ">":
                return KeyEvent.VK_RIGHT;
            default:
                return (int) key.charAt(0);
        }// end of switch

    }// end of getKeyCode
}
