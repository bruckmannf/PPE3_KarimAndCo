package com.karimandco.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import static com.itextpdf.text.html.WebColors.getRGBColor;
import com.itextpdf.text.pdf.FontSelector;
import static com.itextpdf.text.pdf.PdfName.DEST;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.karimandco.auth.Utilisateur;
import com.karimandco.bdd.DaoSIO;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom, Léo, Lorenzo
 */
public class Pdf {

    
    String nom;
    String prenom;
    String numero;
    String lienPDF;
    Integer code = new Random().nextInt(100000000);
    Integer idUtilisateur;
    String test = code.toString();
    private DaoSIO connexionDb = new DaoSIO();
    private Connection connexion;


    public Pdf(String nom, String prenom, String numero, String lienPDF) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
        this.lienPDF = lienPDF;
        
        connexion = (Connection) connexionDb.getConnnexion();
        idUtilisateur = Utilisateur.getInstance().getId();
    }

    public boolean verifPDF() {
        if (nom != "" && prenom != "" && numero != "" && lienPDF != "") {
            return true;
        } else {
            return false;
        }
    }

    public String corrigeLeLien(String lien) {
        char[] ancielLien = lien.toCharArray();

        String lienResult = "";
        for (int i = 0; i < ancielLien.length; i++) {
            if (ancielLien[i] == '\\') {
                lienResult = lienResult + "\\\\";
            } else {
                lienResult = lienResult + ancielLien[i];
            }
        }

        lienResult = new File("src\\main\\java\\com\\karimandco\\pdf\\cv\\cv" + test + ".pdf").getAbsolutePath();

        String nomCv = "cv" + test + ".pdf";
        String resultat = nomCv + "|" + lienResult;

        return resultat;
    }

    public String getNomCv() {
        String nomCvAvantSplit = corrigeLeLien("cv");
        String[] nomCvSplit = nomCvAvantSplit.split("[|]");
        String nomCv = nomCvSplit[0];

        return nomCv;
    }

    public String getUrlCv() {
        String urlCvAvantSplit = corrigeLeLien("cv");
        String[] urlCvSplit = urlCvAvantSplit.split("[|]");
        String urlCv = urlCvSplit[1];

        return urlCv;
    }

    public void genererPDF() throws FileNotFoundException, BadElementException, IOException {
        try {

            lienPDF = this.getUrlCv();
            System.out.println(lienPDF);

            Document document = new Document(PageSize.A4, 0, 0, 0, 0);
            /**
             * Creation de different style de police
             */
            FontSelector selector = new FontSelector();
            Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            selector.addFont(f1);
            Font f2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 41);
            selector.addFont(f2);
            Font f3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            f3.setColor(getRGBColor("#318CE7"));
            selector.addFont(f3);
            Font f4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            selector.addFont(f4);
            Font f5 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            f5.setColor(getRGBColor("#318CE7"));
            selector.addFont(f5);
            Font f6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 1);
            f6.setColor(getRGBColor("#318CE7"));
            selector.addFont(f6);
            Image image;
            String url = "https://kodejava.org/wp-content/uploads/2017/01/kodejava.png";
            image = Image.getInstance(url);

            PdfWriter.getInstance(document, new FileOutputStream(lienPDF));
            System.out.println("OK");
            document.open();
            float[] columnWidths = {10f, 10f, 10f, 10f, 800f};
            PdfPTable Table = new PdfPTable(columnWidths);
            PdfPCell Plein = new PdfPCell(new Phrase(""));
            Plein.setBorderColor(BaseColor.WHITE);
            Table.setWidthPercentage(100);
            Table.setSpacingBefore(0f);
            Table.setSpacingAfter(0f);

            /**
             * Travail dans la Premier Cellulue de la table
             */
            PdfPTable Bleu = new PdfPTable(1);
            Bleu.setWidthPercentage(100);
            Bleu.setSpacingBefore(0f);
            Bleu.setSpacingAfter(0f);
            PdfPCell Bleu1 = new PdfPCell(new Phrase(""));
            Bleu1.setBackgroundColor(WebColors.getRGBColor("#318CE7"));
            Bleu1.setBorderColor(BaseColor.WHITE);
            Bleu1.setFixedHeight(842);
            Table.addCell(Bleu1);

            PdfPTable White = new PdfPTable(1);
            White.setWidthPercentage(100);
            White.setSpacingBefore(0f);
            White.setSpacingAfter(0f);
            PdfPCell White1 = new PdfPCell(new Phrase(""));
            White1.setBackgroundColor(BaseColor.WHITE);
            White1.setBorderColor(BaseColor.WHITE);
            White1.setFixedHeight(840);
            Table.addCell(White1);

            PdfPTable Blue = new PdfPTable(1);
            Blue.setWidthPercentage(100);
            Blue.setSpacingBefore(0f);
            Blue.setSpacingAfter(0f);
            PdfPCell Blue1 = new PdfPCell(new Phrase(""));
            Blue1.setBackgroundColor(WebColors.getRGBColor("#318CE7"));
            Blue1.setBorderColor(BaseColor.WHITE);
            Blue1.setFixedHeight(840);
            Table.addCell(Blue1);

            PdfPTable White2 = new PdfPTable(1);
            White2.setWidthPercentage(100);
            White2.setSpacingBefore(0f);
            White2.setSpacingAfter(0f);
            PdfPCell White21 = new PdfPCell(new Phrase(""));
            White21.setBackgroundColor(BaseColor.WHITE);
            White21.setBorderColor(BaseColor.WHITE);
            White21.setFixedHeight(840);
            Table.addCell(White21);


            PdfPCell C1 = new PdfPCell(new Phrase("Gris"));
            C1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            C1.setFixedHeight(840);

            /**
             * Travail dans la Seconde Cellulue de la table
             */
            // <editor-fold>
            /**
             * Création de la table Principale
             */
            PdfPTable Table2 = new PdfPTable(1);
            Table2.setWidthPercentage(100);
            Table2.setSpacingBefore(0f);
            Table2.setSpacingAfter(0f);
            Table2.setHorizontalAlignment(Element.ALIGN_RIGHT);
            // </editor-fold>
            /**
             * Création de la tables avec les info et la photo
             */
            float[] columnWidths3 = {500f, 200f};
            PdfPTable Table3 = new PdfPTable(columnWidths3);
            Table3.setWidthPercentage(100);
            Table3.setSpacingBefore(0f);
            Table3.setSpacingAfter(0f);
            /**
             * Création de la Cellule contenant les cellules d'information perso
             */
            PdfPCell PresentationPhoto = new PdfPCell(new Phrase(""));
            PresentationPhoto.addElement(Table3);
            PresentationPhoto.setBorderColor(BaseColor.WHITE);
            /**
             * Création des cellules d'information perso
             */
            PdfPCell Para = new PdfPCell(new Phrase(""));
            Para.setBorderColor(BaseColor.WHITE);
            Paragraph para1 = new Paragraph("");
            para1.add(new Paragraph( getUtilisateur(idUtilisateur,"nom") +" "+ getUtilisateur(idUtilisateur,"prenom"), f2));
            para1.add(new Paragraph(getUtilisateur(idUtilisateur,"courriel"), f3));
            para1.add(new Paragraph(getUtilisateur(idUtilisateur,"num_telephone"), f1));
            para1.add(new Paragraph("Date de Naissance"+ getUtilisateur(idUtilisateur,"date_de_naissance"),f1));
            Para.addElement(para1);
            /**
             * Creation de la Cellule Image
             */
            PdfPCell Image = new PdfPCell(new Phrase(""));
            Image.setBorderColor(BaseColor.WHITE);
            Image.addElement(image);
            /**
             * Création de la Cellule
             */
            PdfPCell FormationC = new PdfPCell(new Phrase(""));
            Paragraph FormationCV = new Paragraph("Formation : "+getFormation("nom"), f3);
            FormationCV.add(new Paragraph("Lieu : "+getFormation("lieu"), f1));
            FormationCV.add(new Paragraph("Date :", f1));
            FormationCV.add(new Paragraph("Date : du "+getFormation("annee_debut")+" au "+getFormation("annee_fin"), f1));
            FormationCV.add(new Paragraph(getFormation("description"), f1));
            FormationC.addElement(FormationCV);

            FormationC.setBorderColor(BaseColor.WHITE);
            /**
             * Création de la categorie Experience Pro
             */
            PdfPCell ExpePro = new PdfPCell(new Phrase(""));
            Paragraph Expe = new Paragraph("EXPERIENCE PROFESSIONNELLE", f5);
            Expe.add(new Paragraph(" ", f6));
            ExpePro.setBorderColor(BaseColor.WHITE);
            ExpePro.addElement(Expe);
            
            PdfPCell Experience = new PdfPCell(new Phrase(""));
            Paragraph ExperienceP = new Paragraph("Entreprise : "+getExperience("entreprise"), f3);
            ExperienceP.add(new Paragraph("Adresse : "+getExperience("adresse"), f1));
            ExperienceP.add(new Paragraph("Date : du "+getFormation("annee_debut")+" au "+getFormation("annee_fin"), f1));
            ExperienceP.add(new Paragraph(getFormation("description"), f1));
            Experience.addElement(ExperienceP);


            Experience.setBorderColor(BaseColor.WHITE);
            /**
             * Création de la categorie Formation
             */
            PdfPCell Formation = new PdfPCell(new Phrase(""));
            Paragraph Forma = new Paragraph("FORMATION", f5);
            Forma.add(new Paragraph(" ", f6));
            Formation.setBorderColor(BaseColor.WHITE);
            Formation.addElement(Forma);
            /**
             * Création de la categorie Informatique
             */
            PdfPCell Competence = new PdfPCell(new Phrase(""));
            Paragraph Compete = new Paragraph("COMPETENCE", f5);
            Compete.add(new Paragraph(" ", f6));
            Competence.setBorderColor(BaseColor.WHITE);
            Competence.addElement(Compete);
            /**
             * Création de la categorie Langues
             */
            PdfPCell Langues = new PdfPCell(new Phrase(""));
            Paragraph Lange = new Paragraph("LANGUES", f5);
            Lange.add(new Paragraph(" ", f6));
            Langues.setBorderColor(BaseColor.WHITE);
            Langues.addElement(Lange);
            /**
             * Création de la categorie Centres D'Interet
             */
            PdfPCell Centres = new PdfPCell(new Phrase(""));
            Paragraph Centr = new Paragraph("CENTRES D'INTERET", f5);
            Centr.add(new Paragraph(" ", f6));
            Centres.setBorderColor(BaseColor.WHITE);
            Centres.addElement(Centr);
            /**
             * Création de la barre bleu qui sépare chaque Categorie
             */
            PdfPCell TraitBleu = new PdfPCell(new Phrase(""));
            TraitBleu.setBorderColor(BaseColor.WHITE);
            TraitBleu.setBackgroundColor(WebColors.getRGBColor("#318CE7"));
            TraitBleu.setFixedHeight(1f);
            /**
             * Rajout de Toute les Cellule et Table dans la Table Principale
             */
            Table3.addCell(Para);
            Table3.addCell(Image);
            Table2.addCell(PresentationPhoto);
            Table2.addCell(ExpePro);
            Table2.addCell(TraitBleu);
            Table2.addCell(Experience);
            Table2.addCell(Formation);
            Table2.addCell(TraitBleu);
            Table2.addCell(FormationC);
            Table2.addCell(Competence);
            Table2.addCell(TraitBleu);
            //Table2.addCell(espaces);
            Table2.addCell(Langues);
            Table2.addCell(TraitBleu);
           // Table2.addCell(espaces);
            Table2.addCell(Centres);
            Table2.addCell(TraitBleu);
           // Table2.addCell(espaces);
            Plein.addElement(Table2);
            Table.addCell(Plein);

            document.add(Table);

            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public String getUtilisateur(Integer id,String cat) throws SQLException {
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT * FROM utilisateurs WHERE id = " + id);

            if (res.next()) {
                return res.getString(cat);
            }
        }
        return nom;
    }
    public String getIDCV(Integer id) throws SQLException {
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            ResultSet idcv = DaoSIO.getInstance().requeteSelection("SELECT * FROM cv WHERE id_utilisateur = " + id);
            if (idcv.next()) {
            return idcv.getString("id");
            }
        }
        return nom;
    }
    public String getFormation(String cat) throws SQLException {
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT * FROM formation WHERE id_cv = " + getIDCV(idUtilisateur) );

            if (res.next()) {
                return res.getString(cat);
            }
        }
        return nom;
    }
    public String getExperience(String cat) throws SQLException {
        if (DaoSIO.getInstance().connexionActive()) {
            System.out.println(DaoSIO.getInstance().connexionActive());
            ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT * FROM experience_pro WHERE id_cv = " + getIDCV(idUtilisateur) );

            if (res.next()) {
                return res.getString(cat);
            }
        }
        return nom;
    }
    

}
