package com.karimandco.pdf;

/**
 *
 * @author Tom, Léo, Lorenzo
 */
import com.adobe.acrobat.Viewer;
import java.awt.BorderLayout;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * www.codeurjava.com
 */
public class LecteurPDF extends JPanel {

    private Viewer viewer;

    Pdf lePdf;

    public LecteurPDF(String nomfichier) throws Exception {
        this.setLayout(new BorderLayout());

        //créer le viewer qui va servir à afficher le contenu du pdf
        viewer = new Viewer();
        this.add(viewer, BorderLayout.CENTER);
        FileInputStream fis = new FileInputStream(nomfichier);
        viewer.setDocumentInputStream(fis);
        viewer.activate();
        this.lePdf = new Pdf("bhqjq", "sqsf", "fqfq", "fqfqfq");
    }

    public static void main(String[] args) throws Exception {

        LecteurPDF lecteur = new LecteurPDF("D:\\NetBeansProjects\\projetKarimAndCo\\src\\main\\java\\com\\karimandco\\pdf\\cv\\cv62778571.pdf");
        //créer le JFrame
        JFrame f = new JFrame("Lecteur PDF");
        f.setSize(1024, 768);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(lecteur);
        f.setVisible(true);

    }

    LecteurPDF() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
