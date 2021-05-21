
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Partiel2021 extends javax.swing.JFrame {

    private LesFigurines lf;
    
    public Partiel2021() {
        initComponents();
        this.lf=new LesFigurines();
        lf.initFigurines();
        initPanBoutons();
        initListeCategories();
        initListeLibelles();
        BPhoto.setIcon(new ImageIcon(getClass().getResource("/ImageDefaut.jpg")));
    }
    
    private void initListeCategories()
    { ArrayList<String> ll = new ArrayList<String> ();
     ll= this.lf.getListeCategories();
     for (int i=0; i<ll.size();i++)
        ListeCategories.addItem(ll.get(i));    
    }
     
  
    private void initListeLibelles(){
        DefaultListModel mod = new DefaultListModel();
        ListeLibelles.setModel(mod);
        for (int i=0; i<lf.getNbFigurines(); i++)
          mod.addElement(this.lf.getFigurine(i).getLibelle());
    }

    
    private void initPanBoutons()
    { PanBoutons.setLayout(new GridLayout(1,lf.getNbFigurines()));
    for (int i=0; i<lf.getNbFigurines(); i++)
    { JButton bouton=new JButton();
       //bouton.setPreferredSize(new Dimension(100,100));
       bouton.setName(""+i);
       bouton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonActionPerformed(evt);
            }
        }); 
      Figurine f= lf.getFigurine(i);
      bouton.setIcon(f.getPhoto());
      PanBoutons.add(bouton);
    }
    }
 
     private void boutonActionPerformed(java.awt.event.ActionEvent evt)
    { JButton bt=(JButton) evt.getSource();
      int i = Integer.parseInt(bt.getName());
      Figurine f = this.lf.getFigurine(i);
      Edition.setText(f.toString());
      BPhoto.setIcon(f.getPhoto());
      BRTTES.setSelected(false);
      BRINF.setSelected(false);
      BRSUPE.setSelected(false);
      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LTitre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BRTTES = new javax.swing.JRadioButton();
        LSeuil = new javax.swing.JLabel();
        Seuil = new javax.swing.JTextField();
        BRINF = new javax.swing.JRadioButton();
        BRSUPE = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        BPhoto = new javax.swing.JButton();
        LLibelle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeLibelles = new javax.swing.JList<>();
        LCategorie = new javax.swing.JLabel();
        ListeCategories = new javax.swing.JComboBox<>();
        PanBoutons = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        MBar = new javax.swing.JMenuBar();
        MGerer = new javax.swing.JMenu();
        MAjouter = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LTitre.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        LTitre.setText("Figurines FUNKO POP");
        jPanel1.add(LTitre);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(5, 1));

        BRTTES.setText("Toutes");
        BRTTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRTTESActionPerformed(evt);
            }
        });
        jPanel2.add(BRTTES);

        LSeuil.setText("Seuil ?");
        jPanel2.add(LSeuil);
        jPanel2.add(Seuil);

        BRINF.setText("Prix < seuil");
        BRINF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRINFActionPerformed(evt);
            }
        });
        jPanel2.add(BRINF);

        BRSUPE.setText("Prix >= seuil");
        BRSUPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRSUPEActionPerformed(evt);
            }
        });
        jPanel2.add(BRSUPE);

        getContentPane().add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel3.setLayout(new java.awt.GridLayout(5, 1));

        BPhoto.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel3.add(BPhoto);

        LLibelle.setText("Libellé ?");
        jPanel3.add(LLibelle);

        ListeLibelles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListeLibelles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeLibellesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListeLibelles);

        jPanel3.add(jScrollPane1);

        LCategorie.setText("Catégorie ?");
        jPanel3.add(LCategorie);

        ListeCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeCategoriesActionPerformed(evt);
            }
        });
        jPanel3.add(ListeCategories);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        PanBoutons.setLayout(new java.awt.GridLayout(1, 4));
        getContentPane().add(PanBoutons, java.awt.BorderLayout.SOUTH);

        Edition.setColumns(20);
        Edition.setLineWrap(true);
        Edition.setRows(5);
        jScrollPane2.setViewportView(Edition);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        MGerer.setText("Gérer");

        MAjouter.setText("Ajouter");
        MGerer.add(MAjouter);

        MBar.add(MGerer);

        setJMenuBar(MBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BRINFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRINFActionPerformed
        // TODO add your handling code here:
        float seuil = Float.parseFloat(Seuil.getText());
        LesFigurines l= this.lf.getFigurinesInf(seuil);
        Edition.setText(l.toString());
        BPhoto.setIcon(new ImageIcon(getClass().getResource("/ImageDefaut.jpg")));
    }//GEN-LAST:event_BRINFActionPerformed

    private void BRSUPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRSUPEActionPerformed
        // TODO add your handling code here:
        LesFigurines l= this.lf.getFigurinesSupe(10);
        Edition.setText(l.toString());
        BPhoto.setIcon(new ImageIcon(getClass().getResource("/ImageDefaut.jpg")));
    }//GEN-LAST:event_BRSUPEActionPerformed

    private void BRTTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRTTESActionPerformed
        Edition.setText(this.lf.toString());
    }//GEN-LAST:event_BRTTESActionPerformed

    private void ListeCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeCategoriesActionPerformed
        int ind =ListeCategories.getSelectedIndex();
        String cat = ListeCategories.getSelectedItem().toString();
        LesFigurines l= this.lf.getFigurinesCategorie(cat);
        Edition.setText(l.toString());
        BPhoto.setIcon(new ImageIcon(getClass().getResource("/ImageDefaut.jpg")));
        BRTTES.setSelected(false);
        BRINF.setSelected(false);
        BRSUPE.setSelected(false);
    }//GEN-LAST:event_ListeCategoriesActionPerformed

    private void ListeLibellesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeLibellesMouseClicked
        int ind =ListeLibelles.getSelectedIndex();
        String lib= ListeLibelles.getSelectedValue().toString();
        Figurine f= this.lf.getFigurineLibelle(lib);
        if (f!= null)   
            {
                Edition.setText(f.toString());
                BPhoto.setIcon(f.getPhoto());
                BRTTES.setSelected(false);
                BRINF.setSelected(false);
                BRSUPE.setSelected(false);
            }
    }//GEN-LAST:event_ListeLibellesMouseClicked


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
            java.util.logging.Logger.getLogger(Partiel2021.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partiel2021.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partiel2021.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partiel2021.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Partiel2021().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BPhoto;
    private javax.swing.JRadioButton BRINF;
    private javax.swing.JRadioButton BRSUPE;
    private javax.swing.JRadioButton BRTTES;
    private javax.swing.JTextArea Edition;
    private javax.swing.JLabel LCategorie;
    private javax.swing.JLabel LLibelle;
    private javax.swing.JLabel LSeuil;
    private javax.swing.JLabel LTitre;
    private javax.swing.JComboBox<String> ListeCategories;
    private javax.swing.JList<String> ListeLibelles;
    private javax.swing.JMenu MAjouter;
    private javax.swing.JMenuBar MBar;
    private javax.swing.JMenu MGerer;
    private javax.swing.JPanel PanBoutons;
    private javax.swing.JTextField Seuil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
