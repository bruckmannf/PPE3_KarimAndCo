package com.karimandco.pdf;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author Tom, Léo, Lorenzo
 */
public class choisirDossier extends JFileChooser {

    Integer result;
    
    public choisirDossier() {
        super();
        setMultiSelectionEnabled(false);
        setFileSelectionMode(DIRECTORIES_ONLY);
        
    }
    
    
    
}
