/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.admin;

import com.karimandco.bdd.DaoSIO;
import com.karimandco.auth.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author t.normand
 */
public class PanneauFormConnexionAdmin extends javax.swing.JPanel {
    
    Connexion panneauPereConnexionAdmin = null;
    private Boolean estConnecte = false;
    private Boolean identifiantOK = false;
    private Boolean mdpOK = false;

    public JButton getjButtonConnexion() {
        return jButtonConnexion;
    }

    public void setjButtonConnexion(JButton jButtonConnexion) {
        this.jButtonConnexion = jButtonConnexion;
    }

    public boolean getEstConnecte() {
        return estConnecte;
    }

    public void setEstConnecte(Boolean estConnecte) {
        this.estConnecte = estConnecte;
    }

    public void setIdentifiantOK(Boolean identifiantOK) {
        this.identifiantOK = identifiantOK;
    }

    public void setMdpOK(Boolean mdpOK) {
        this.mdpOK = mdpOK;
    }

    public void setFenParentConnexionAdmin(Connexion i) {
        this.panneauPereConnexionAdmin = i;
    }

    /**
     * Creates new form PanneauFormConnexionAdmin
     */
    public PanneauFormConnexionAdmin() {
        initComponents();

        panneauIdentifiant.setjLabelNomChamp("Identifiant");
        panneauMdp.setjLabelNomChampSecret("Mot de passe");

        panneauIdentifiant.getChamp2().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                if (!panneauIdentifiant.getChamp2().getText().equals("")) {
                    if (panneauIdentifiant.getChamp2().verifIdentifiant()) {
                        panneauIdentifiant.setjLabelEtatChamp(Color.blue);
                        panneauIdentifiant.setjLabelEtatChamp("Format correct");
                        setIdentifiantOK(true);
                    } else {
                        panneauIdentifiant.setjLabelEtatChamp(Color.red);
                        panneauIdentifiant.setjLabelEtatChamp("Format incorrect");
                        setIdentifiantOK(false);
                    }
                } else {
                    panneauIdentifiant.setjLabelEtatChamp(Color.black);
                    panneauIdentifiant.setjLabelEtatChamp("");
                    setIdentifiantOK(false);
                }
            }
        });

        panneauMdp.getChampSecret1().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                if (!String.valueOf(panneauMdp.getChampSecret1().getPassword()).equals("")) {
                    if (panneauMdp.getChampSecret1().verifPassword()) {
                        panneauMdp.setjLabelEtatChampSecret(Color.blue);
                        panneauMdp.setjLabelEtatChampSecret("Format correct");
                        setMdpOK(true);
                    } else {
                        panneauMdp.setjLabelEtatChampSecret(Color.red);
                        panneauMdp.setjLabelEtatChampSecret("Format incorrect");
                        setMdpOK(false);
                    }
                } else {
                    panneauMdp.setjLabelEtatChampSecret(Color.black);
                    panneauMdp.setjLabelEtatChampSecret("");
                    setMdpOK(false);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneauIdentifiant = new com.karimandco.auth.PanneauChamp();
        jButtonConnexion = new javax.swing.JButton();
        jLabelEtatConnexion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panneauMdp = new com.karimandco.auth.PanneauChampSecret();

        jButtonConnexion.setText("Se connecter");
        jButtonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnexionActionPerformed(evt);
            }
        });

        jLabelEtatConnexion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Connexion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panneauIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panneauMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEtatConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panneauIdentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panneauMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConnexion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEtatConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnexionActionPerformed
        if (identifiantOK && mdpOK) {
            ResultSet lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM utilisateurs WHERE statut = 1 AND identifiant='" + this.panneauIdentifiant.getChamp2().getText() + "' AND mot_de_passe='" + String.valueOf(this.panneauMdp.getChampSecret1().getPassword()) + "'");
            try {
                if (lesResultats.next()) {
                    jLabelEtatConnexion.setForeground(Color.blue);
                    jLabelEtatConnexion.setText("Connexion réussie");
                    this.setEstConnecte(true);
                    System.out.println(this.getEstConnecte());
                } else {
                    jLabelEtatConnexion.setForeground(Color.red);
                    jLabelEtatConnexion.setText("Identifiant et/ou mot de passe incorrect(s)");
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButtonConnexionActionPerformed

    public JLabel getjLabelEtatConnexion() {
        return jLabelEtatConnexion;
    }

    public void setjLabelEtatConnexion(JLabel jLabelEtatConnexion) {
        this.jLabelEtatConnexion = jLabelEtatConnexion;
    }

    public void setjLabelEtatConnexion(String reponse) {
        this.jLabelEtatConnexion.setText(reponse);
    }

    public Connexion getPanneauPereConnexionAdmin() {
        return panneauPereConnexionAdmin;
    }

    public void setPanneauPereConnexionAdmin(Connexion panneauPereConnexionAdmin) {
        this.panneauPereConnexionAdmin = panneauPereConnexionAdmin;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public PanneauChamp getPanneauIdentifiant() {
        return panneauIdentifiant;
    }

    public void setPanneauIdentifiant(PanneauChamp panneauIdentifiant) {
        this.panneauIdentifiant = panneauIdentifiant;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEtatConnexion;
    private com.karimandco.auth.PanneauChamp panneauIdentifiant;
    private com.karimandco.auth.PanneauChampSecret panneauMdp;
    // End of variables declaration//GEN-END:variables

}
