/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.cv;

import com.alee.laf.WebLookAndFeel;
import javax.swing.SwingUtilities;

/**
 *
 * @author karim
 */
public class Main {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater ( new Runnable ()
        {
            public void run ()
            {
                // Installation de l'interaface WebLaF
                WebLookAndFeel.install ();
                
                JFramePrincipalCV gui = new JFramePrincipalCV();
                gui.setTitle("Création Curriculum Vitae - Graphique User Interface");
                gui.setVisible(true);
            }
        } );
        
    }
}
