/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.jamk.Elokuvarekisteri;

/**
 *
 * @author Mikko2
 */
public class MuokkaaHenkiloJFrame extends javax.swing.JFrame {
    private Henkilomalli henkilomalli = new Henkilomalli();
    private int muokattavaId;
    //private Henkilo henkilo = new Henkilo();
    /**
     * Creates new form LisaaHenkiloJFrame
     */
    public MuokkaaHenkiloJFrame() {
        
    }
    public MuokkaaHenkiloJFrame(int id) {
        muokattavaId = id;
        initComponents();
       
        
        Henkilo henkilo = this.henkilomalli.getHenkiloAt(id);
        
        EtunimiTextField.setText(henkilo.getEtunimi());
        SukunimiTextField.setText(henkilo.getSukunimi());
        SyntymavuosiTextField.setText(Integer.toString(henkilo.getSyntymavuosi()));
        KotimaaTextField.setText(henkilo.getMaa());
        int rooli;
        if(henkilo.getRooli().equals("nayttelija")){
            rooli = 0;
        } else {
            rooli = 1;
        }
        RooliComboBox.setSelectedIndex(rooli);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        EtunimiTextField = new javax.swing.JTextField();
        SukunimiTextField = new javax.swing.JTextField();
        SyntymavuosiTextField = new javax.swing.JTextField();
        KotimaaTextField = new javax.swing.JTextField();
        RooliComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        valmisBtn = new javax.swing.JButton();
        peruutaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Etunimi:");

        jLabel2.setText("Sukunimi:");

        jLabel3.setText("Syntymävuosi:");

        jLabel4.setText("Kotimaa:");

        jLabel5.setText("Rooli:");

        EtunimiTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtunimiTextFieldActionPerformed(evt);
            }
        });

        SukunimiTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SukunimiTextFieldActionPerformed(evt);
            }
        });

        RooliComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "nayttelija", "ohjaaja" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Lisää/Muokkaa henkilö");

        valmisBtn.setText("Valmis");
        valmisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valmisBtnActionPerformed(evt);
            }
        });

        peruutaBtn.setText("Peruuta");
        peruutaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peruutaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EtunimiTextField)
                            .addComponent(SukunimiTextField)
                            .addComponent(SyntymavuosiTextField)
                            .addComponent(KotimaaTextField)
                            .addComponent(RooliComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(valmisBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(peruutaBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(EtunimiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SukunimiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SyntymavuosiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(KotimaaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(RooliComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valmisBtn)
                    .addComponent(peruutaBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EtunimiTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtunimiTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EtunimiTextFieldActionPerformed

    private void SukunimiTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SukunimiTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SukunimiTextFieldActionPerformed

    private void peruutaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peruutaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peruutaBtnActionPerformed

    private void valmisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valmisBtnActionPerformed
        Henkilo henkilo = this.henkilomalli.getHenkiloAt(muokattavaId);
        henkilomalli.setValueAt(EtunimiTextField.getText(), henkilo.getId(), 1);
        henkilomalli.setValueAt(SukunimiTextField.getText(), henkilo.getId(), 2);
        henkilomalli.setValueAt(Integer.parseInt(SyntymavuosiTextField.getText()), henkilo.getId(), 3);
        henkilomalli.setValueAt(KotimaaTextField.getText(), henkilo.getId(), 4);
        henkilomalli.setValueAt(RooliComboBox.getSelectedItem().toString(), henkilo.getId(), 5);
    }//GEN-LAST:event_valmisBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuokkaaHenkiloJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuokkaaHenkiloJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EtunimiTextField;
    private javax.swing.JTextField KotimaaTextField;
    private javax.swing.JComboBox RooliComboBox;
    private javax.swing.JTextField SukunimiTextField;
    private javax.swing.JTextField SyntymavuosiTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton peruutaBtn;
    private javax.swing.JButton valmisBtn;
    // End of variables declaration//GEN-END:variables
}
