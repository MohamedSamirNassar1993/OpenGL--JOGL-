package MohameSamirCalculator;

import static calculator3.CalculatorFrame.textfield;
import calculator3.Expression;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Calculator extends javax.swing.JFrame {

    public Calculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Txt = new javax.swing.JTextField();
        bton = new javax.swing.JButton();
        btpi = new javax.swing.JButton();
        bte = new javax.swing.JButton();
        btsqrt = new javax.swing.JButton();
        btanswer = new javax.swing.JButton();
        btdelete = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt0 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        btclear = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        btdot = new javax.swing.JButton();
        btleftbracket = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        btequal = new javax.swing.JButton();
        btrightbracket = new javax.swing.JButton();
        btdivide = new javax.swing.JButton();
        btmultiply = new javax.swing.JButton();
        btsubtract = new javax.swing.JButton();
        btadd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator By Mohamed Samir");
        setBackground(new java.awt.Color(255, 255, 240));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        Txt.setEditable(false);
        Txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Txt.setForeground(new java.awt.Color(50, 205, 50));
        Txt.setCaretColor(new java.awt.Color(50, 205, 50));
        Txt.setSelectionColor(new java.awt.Color(152, 251, 152));
        Txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtMouseClicked(evt);
            }
        });
        Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtActionPerformed(evt);
            }
        });
        Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtKeyTyped(evt);
            }
        });

        bton.setBackground(java.awt.Color.black);
        bton.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bton.setForeground(new java.awt.Color(50, 205, 50));
        bton.setText("off");
        bton.setToolTipText("On");
        bton.setActionCommand("on");
        bton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btonMouseExited(evt);
            }
        });
        bton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonActionPerformed(evt);
            }
        });

        btpi.setBackground(java.awt.Color.black);
        btpi.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btpi.setForeground(new java.awt.Color(50, 205, 50));
        btpi.setText("pi");
        btpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpiActionPerformed(evt);
            }
        });

        bte.setBackground(java.awt.Color.black);
        bte.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bte.setForeground(new java.awt.Color(50, 205, 50));
        bte.setText("e");
        bte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteActionPerformed(evt);
            }
        });

        btsqrt.setBackground(java.awt.Color.black);
        btsqrt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btsqrt.setForeground(new java.awt.Color(50, 205, 50));
        btsqrt.setText("√");
        btsqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsqrtActionPerformed(evt);
            }
        });

        btanswer.setBackground(java.awt.Color.black);
        btanswer.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btanswer.setForeground(new java.awt.Color(50, 205, 50));
        btanswer.setText("Ans");
        btanswer.setToolTipText("Answer");
        btanswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btanswerActionPerformed(evt);
            }
        });

        btdelete.setBackground(java.awt.Color.black);
        btdelete.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btdelete.setForeground(new java.awt.Color(50, 205, 50));
        btdelete.setText("delete");

        bt7.setBackground(java.awt.Color.black);
        bt7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt7.setForeground(new java.awt.Color(50, 205, 50));
        bt7.setText("7");
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });

        bt4.setBackground(java.awt.Color.black);
        bt4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt4.setForeground(new java.awt.Color(50, 205, 50));
        bt4.setText("4");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });

        bt0.setBackground(java.awt.Color.black);
        bt0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt0.setForeground(new java.awt.Color(50, 205, 50));
        bt0.setText("0");
        bt0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt0ActionPerformed(evt);
            }
        });

        bt1.setBackground(java.awt.Color.black);
        bt1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt1.setForeground(new java.awt.Color(50, 205, 50));
        bt1.setText("1");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        btclear.setBackground(java.awt.Color.black);
        btclear.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btclear.setForeground(new java.awt.Color(50, 205, 50));
        btclear.setText("Clear");
        btclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btclearMouseExited(evt);
            }
        });
        btclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btclearActionPerformed(evt);
            }
        });

        bt8.setBackground(java.awt.Color.black);
        bt8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt8.setForeground(new java.awt.Color(50, 205, 50));
        bt8.setText("8");
        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });

        bt5.setBackground(java.awt.Color.black);
        bt5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt5.setForeground(new java.awt.Color(50, 205, 50));
        bt5.setText("5");
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });

        bt2.setBackground(java.awt.Color.black);
        bt2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt2.setForeground(new java.awt.Color(50, 205, 50));
        bt2.setText("2");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        btdot.setBackground(java.awt.Color.black);
        btdot.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        btdot.setForeground(new java.awt.Color(50, 205, 50));
        btdot.setText(".");
        btdot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdotActionPerformed(evt);
            }
        });

        btleftbracket.setBackground(java.awt.Color.black);
        btleftbracket.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btleftbracket.setForeground(new java.awt.Color(50, 205, 50));
        btleftbracket.setText("(");
        btleftbracket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btleftbracketActionPerformed(evt);
            }
        });

        bt9.setBackground(java.awt.Color.black);
        bt9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt9.setForeground(new java.awt.Color(50, 205, 50));
        bt9.setText("9");
        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });

        bt6.setBackground(java.awt.Color.black);
        bt6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt6.setForeground(new java.awt.Color(50, 205, 50));
        bt6.setText("6");
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });

        bt3.setBackground(java.awt.Color.black);
        bt3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bt3.setForeground(new java.awt.Color(50, 205, 50));
        bt3.setText("3");
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        btequal.setBackground(java.awt.Color.black);
        btequal.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        btequal.setForeground(new java.awt.Color(50, 205, 50));
        btequal.setText("=");
        btequal.setToolTipText("Equals");
        btequal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btequalActionPerformed(evt);
            }
        });

        btrightbracket.setBackground(java.awt.Color.black);
        btrightbracket.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btrightbracket.setForeground(new java.awt.Color(50, 205, 50));
        btrightbracket.setText(")");
        btrightbracket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrightbracketActionPerformed(evt);
            }
        });

        btdivide.setBackground(java.awt.Color.black);
        btdivide.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btdivide.setForeground(new java.awt.Color(50, 205, 50));
        btdivide.setText("/");
        btdivide.setToolTipText("Divide");
        btdivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdivideActionPerformed(evt);
            }
        });

        btmultiply.setBackground(java.awt.Color.black);
        btmultiply.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btmultiply.setForeground(new java.awt.Color(50, 205, 50));
        btmultiply.setText("X");
        btmultiply.setToolTipText("Multiply");
        btmultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmultiplyActionPerformed(evt);
            }
        });

        btsubtract.setBackground(java.awt.Color.black);
        btsubtract.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        btsubtract.setForeground(new java.awt.Color(50, 205, 50));
        btsubtract.setText("-");
        btsubtract.setToolTipText("Subtract");
        btsubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsubtractActionPerformed(evt);
            }
        });

        btadd.setBackground(java.awt.Color.black);
        btadd.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btadd.setForeground(new java.awt.Color(50, 205, 50));
        btadd.setText("+");
        btadd.setToolTipText("Add");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btpi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btsqrt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btanswer, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btdelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btclear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(btdot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bt3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btleftbracket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btequal, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btsubtract, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btmultiply, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(btdivide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btrightbracket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bton, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(btrightbracket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btleftbracket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btdivide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btpi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt7, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btmultiply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(bte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btsubtract, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(bt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btsqrt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btanswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btdot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(btequal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btadd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btpi.getAccessibleContext().setAccessibleName("btpi");
        bte.getAccessibleContext().setAccessibleName("bte");
        btsqrt.getAccessibleContext().setAccessibleName("btsqrt");
        btanswer.getAccessibleContext().setAccessibleName("btanswer");
        btdelete.getAccessibleContext().setAccessibleName("btdelete");
        bt7.getAccessibleContext().setAccessibleName("bt7");
        bt4.getAccessibleContext().setAccessibleName("bt4");
        bt0.getAccessibleContext().setAccessibleName("bt0");
        bt1.getAccessibleContext().setAccessibleName("bt1");
        btclear.getAccessibleContext().setAccessibleName("btclear");
        bt8.getAccessibleContext().setAccessibleName("bt8");
        bt5.getAccessibleContext().setAccessibleName("bt5");
        bt2.getAccessibleContext().setAccessibleName("bt2");
        bt2.getAccessibleContext().setAccessibleDescription("");
        btdot.getAccessibleContext().setAccessibleName("btdot");
        btleftbracket.getAccessibleContext().setAccessibleName("btleftbracket");
        bt9.getAccessibleContext().setAccessibleName("bt9");
        bt6.getAccessibleContext().setAccessibleName("bt6");
        bt3.getAccessibleContext().setAccessibleName("bt3");
        btequal.getAccessibleContext().setAccessibleName("btequal");
        btrightbracket.getAccessibleContext().setAccessibleName("btrightbracket");
        btdivide.getAccessibleContext().setAccessibleName("btdivide");
        btmultiply.getAccessibleContext().setAccessibleName("btmultiply");
        btsubtract.getAccessibleContext().setAccessibleName("btsubtract");
        btadd.getAccessibleContext().setAccessibleName("btadd");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "4");
        }
    }//GEN-LAST:event_bt4ActionPerformed

    private void btsqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsqrtActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "√");
        }
    }//GEN-LAST:event_btsqrtActionPerformed

    private void btleftbracketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btleftbracketActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "(");
        }
    }//GEN-LAST:event_btleftbracketActionPerformed

    private void TxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isOn) {

                calculateExpression(Txt.getText());

            }
        }
    }//GEN-LAST:event_TxtKeyPressed

    private void TxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtKeyReleased

    private void TxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtKeyTyped

    private void TxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMouseClicked

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            Txt.setText(Txt.getText() + " + ");
        }
    }//GEN-LAST:event_btaddActionPerformed

    private void btsubtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsubtractActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            Txt.setText(Txt.getText() + " - ");
        }
    }//GEN-LAST:event_btsubtractActionPerformed

    private void btmultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmultiplyActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            Txt.setText(Txt.getText() + " * ");
        }
    }//GEN-LAST:event_btmultiplyActionPerformed

    private void btdivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdivideActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            Txt.setText(Txt.getText() + " / ");
        }
    }//GEN-LAST:event_btdivideActionPerformed

    private void btequalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btequalActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            calculateExpression(Txt.getText());
        }
    }//GEN-LAST:event_btequalActionPerformed

    private void btanswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btanswerActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "Ans");
        }
    }//GEN-LAST:event_btanswerActionPerformed

    private void btonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btonMouseEntered
        // TODO add your handling code here:
        bton.setForeground(Color.BLACK);
        if (isOn) {
            bton.setBackground(Color.GREEN);
            bton.setText("Off");
        } else {
            bton.setBackground(Color.RED);
            bton.setText("On");
        }
    }//GEN-LAST:event_btonMouseEntered

    private void btonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btonMouseExited
        // TODO add your handling code here:
        bton.setForeground(new Color(50, 205, 50));
        bton.setText("Off");
        if (onPressed > 0) {
            bton.setForeground(Color.BLACK);
            if (isOn) {
                bton.setBackground(Color.RED);
                bton.setText("On");
            } else {
                bton.setBackground(Color.GREEN);
                bton.setText("Off");
            }
        } else {
            bton.setBorder(BorderFactory
                    .createLineBorder(new Color(50, 205, 50)));
        }


    }//GEN-LAST:event_btonMouseExited

    private void btonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonActionPerformed
        // TODO add your handling code here:
        onPressed++;
        if (isOn == false) {
            isOn = true;
            Txt.setEditable(true);
            Txt.setText("0");
            bton.setToolTipText("Off");
            bton.setText("Off");
            bton.setBackground(Color.GREEN);
            bton.setForeground(Color.BLACK);
            bton.setBorder(BorderFactory
                    .createLineBorder(Color.BLACK));
            Txt.setBackground(Color.BLACK);
        } else {
            isOn = false;
            Txt.setEditable(false);
            Txt.setBackground(Color.BLACK);
            Txt.setText("Off");
            bton.setToolTipText("On");
            bton.setForeground(Color.BLACK);
            bton.setBackground(Color.RED);
            bton.setBorder(BorderFactory
                    .createLineBorder(Color.BLACK));
            bton.setText("On");
        }
    }//GEN-LAST:event_btonActionPerformed

    private void btclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btclearActionPerformed
        // TODO add your handling code here:
        btclear.setForeground(new Color(50, 205, 50));
        if (isOn) {
            Txt.setText("");
        }
    }//GEN-LAST:event_btclearActionPerformed

    private void btclearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btclearMouseExited
        // TODO add your handling code here:
        btclear.setForeground(new Color(50, 205, 50));
        btclear.setBorder(BorderFactory.createLineBorder(new Color(50, 205, 50)));
    }//GEN-LAST:event_btclearMouseExited

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "5");
        }
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "6");
        }
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "1");
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "2");
        }
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "3");
        }
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "7");
        }
    }//GEN-LAST:event_bt7ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "8");
        }
    }//GEN-LAST:event_bt8ActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "9");
        }
    }//GEN-LAST:event_bt9ActionPerformed

    private void bt0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt0ActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "0");
        }
    }//GEN-LAST:event_bt0ActionPerformed

    private void btdotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdotActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + ".");
        }
    }//GEN-LAST:event_btdotActionPerformed

    private void btrightbracketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrightbracketActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + ")");
        }
    }//GEN-LAST:event_btrightbracketActionPerformed

    private void btpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpiActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "p");
        }
    }//GEN-LAST:event_btpiActionPerformed

    private void bteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteActionPerformed
        // TODO add your handling code here:
        if (isOn) {
            if (Txt.getText().equals("0")) {
                Txt.setText("");
            }
            Txt.setText(Txt.getText() + "e");
        }
    }//GEN-LAST:event_bteActionPerformed

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
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
    private boolean isOn = false;
    private int onPressed = 0;
    private double answer = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Txt;
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
    private javax.swing.JButton btadd;
    private javax.swing.JButton btanswer;
    private javax.swing.JButton btclear;
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btdivide;
    private javax.swing.JButton btdot;
    private javax.swing.JButton bte;
    private javax.swing.JButton btequal;
    private javax.swing.JButton btleftbracket;
    private javax.swing.JButton btmultiply;
    private javax.swing.JButton bton;
    private javax.swing.JButton btpi;
    private javax.swing.JButton btrightbracket;
    private javax.swing.JButton btsqrt;
    private javax.swing.JButton btsubtract;
    // End of variables declaration//GEN-END:variables

    private void calculateExpression(String text) {
        String newExpression1 = "";
        String[] values = Txt.getText().split("\\s");
        for (int i = 0; i < values.length; i++) {
            if (values[i].trim().equals("Ans")) {
                newExpression1 += answer;
            } else {
                newExpression1 += values[i];
            }
        }

        String newExpression2 = "";
        for (int j = 0; j < newExpression1.length(); j++) {
            if (newExpression1.charAt(j) == 'p') {
                newExpression2 += Math.PI;
            } else if (newExpression1.charAt(j) == 'e') {
                newExpression2 += Math.E;
            } /*else if (newExpression1.charAt(j) == '√') {
                int i = j + 1;
                for (i; i < newExpression1.length() &&; i++) {
                    if (newExpression1.charAt(i + 1) == '+') {
                        newExpression2 += Math.sqrt();
                        newExpression1.charAt(i).
                    }
                    }

                }*/else {
                newExpression2 += newExpression1.charAt(j);
            }
            }

            try {
                Expression e = new Expression(newExpression2);
                double ans = e.evaluate();
                answer = ans;
                Txt.setText(Double.toString(ans));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a valid number! You have entered: " + "\""
                        + Txt.getText() + "\"");
                Txt.setText("");
            }
        }

        boolean isDouble
        (Object str
        
            ) {
        try {
                Double.toString((Double) str);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        boolean isInteger
        (Object str
        
            ) {
        try {
                Integer.toString((Integer) str);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
