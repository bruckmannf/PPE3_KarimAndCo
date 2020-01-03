/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.importexport;

import com.karimandco.auth.Utilisateur;
import com.karimandco.bdd.DaoSIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c.nadal
 */
public class ImportExportXML extends Export {

    public ImportExportXML(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    @Override
    public void exportFichier() {
        FileWriter objFile = null;

        try {
            //ouverture du fichier en écriture
            Integer a = 0;
            Integer b = 0;
            Integer c = 0;
            Integer d = 0;
            Integer nbUtilisateur = null;
            Integer nbElementCv = null;
            Integer nbElementExpPro = null;
            Integer nbElementFormation = null;
            objFile = new FileWriter(this.nomFichier);
            objFile.write("<?xml version = \"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>\r\n");
            objFile.write("<LesDonnees>\r\n");
            objFile.write("<Utilisateurs>\r\n");
            ResultSet nbElement = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM utilisateurs");
            if (nbElement.next()) {
                nbUtilisateur = nbElement.getInt(1);
            }

            ResultSet lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM utilisateurs");
            while (a != nbUtilisateur) {

                if (lesResultats.next()) {
                    String[] date_split = lesResultats.getString("date_de_naissance").split("-");
                    objFile.write("<utilisateur>\r\n"
                            + "<id>" + lesResultats.getInt("id") + "</id>\r\n"
                            + "<statut>" + lesResultats.getInt("statut") + "</statut>\r\n"
                            + "<identifiant>" + lesResultats.getString("identifiant") + "</identifiant>\r\n"
                            + "<nom>" + lesResultats.getString("nom") + "</nom>\r\n"
                            + "<prenom>" + lesResultats.getString("prenom") + "</prenom>\r\n"
                            + "<num_telephone>" + lesResultats.getString("num_telephone") + "</num_telephone>\r\n"
                            + "<courriel>" + lesResultats.getString("courriel") + "</courriel>\r\n"
                            + "<date_de_naissance>" + date_split[2] + "-" + date_split[1] + "-" + date_split[0] + "</date_de_naissance>\r\n"
                            + "<photo>" + lesResultats.getBlob("photo") + "</photo>\r\n"
                            + "</utilisateur>\r\n");
                }
                a++;
            }

            objFile.write("</Utilisateurs>\r\n");
            objFile.write("<CurriculumVitae>\r\n");
            
            ResultSet nbCv = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM cv");
            if (nbCv.next()) {
                nbElementCv = nbCv.getInt(1);
            }

            lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM cv");
            while (b != nbElementCv) {
                if (lesResultats.next()) {
                    objFile.write("<cv>\r\n"
                            + "<id>" + lesResultats.getInt("id") + "</id>\r\n"
                            + "<titre>" + lesResultats.getString("titre") + "</titre>\r\n"
                            + "<description>" + lesResultats.getString("description") + "</description>\r\n"
                            + "<signature>" + lesResultats.getString("signature") + "</signature>\r\n"
                            + "<nom_maitrise>" + lesResultats.getString("nom_maitrise") + "</nom_maitrise>\r\n"
                            + "<maitrise>" + lesResultats.getString("maitrise") + "</maitrise>\r\n"
                            + "<id_utilisateur>" + lesResultats.getInt("id_utilisateur") + "</id_utilisateur>\r\n"
                            + "</cv>\r\n");
                }
                b++;
            }
            objFile.write("</CurriculumVitae>\r\n");
            objFile.write("<ExperiencePro>\r\n");
            ResultSet nbExpPro = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM experience_pro");
            if (nbExpPro.next()) {
                nbElementExpPro = nbExpPro.getInt(1);
            }
            lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM experience_pro");
            while (c != nbElementExpPro) {
                if (lesResultats.next()) {
                    String[] date_splitAnneeDebut = lesResultats.getString("annee_debut").split("-");
                    String[] date_splitAnneeFIn = lesResultats.getString("annee_fin").split("-");
                    objFile.write("<experience_pro>\r\n"
                            + "<id>" + lesResultats.getInt("id") + "</id>\r\n"
                            + "<entreprise>" + lesResultats.getString("entreprise") + "</entreprise>\r\n"
                            + "<adresse>" + lesResultats.getString("adresse") + "</adresse>\r\n"
                            + "<description>" + lesResultats.getString("description") + "</description>\r\n"
                            + "<annee_debut>" + date_splitAnneeDebut[2] + "-" + date_splitAnneeDebut[1] + "-" + date_splitAnneeDebut[0] + "</annee_debut>\r\n"
                            + "<annee_fin>" + date_splitAnneeFIn[2] + "-" + date_splitAnneeFIn[1] + "-" + date_splitAnneeFIn[0] + "</annee_fin>\r\n"
                            + "<id_cv>" + lesResultats.getInt("id_cv") + "</id_cv>\r\n"
                            + "</experience_pro>\r\n");
                }
                c++;
            }
            objFile.write("</ExperiencePro>\r\n");
            objFile.write("<Formations>\r\n");
            ResultSet nbFormation = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM formation");

            if (nbFormation.next()) {
                nbElementFormation = nbFormation.getInt(1);
            }

            lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM formation");
            while (d != nbElementFormation) {

                if (lesResultats.next()) {
                    String[] date_splitAnneeDebut = lesResultats.getString("annee_debut").split("-");
                    String[] date_splitAnneeFIn = lesResultats.getString("annee_fin").split("-");
                    objFile.write("<formation>\r\n"
                            + "<id>" + lesResultats.getInt("id") + "</id>\r\n"
                            + "<nom>" + lesResultats.getString("nom") + "</nom>\r\n"
                            + "<lieu>" + lesResultats.getString("lieu") + "</lieu>\r\n"
                            + "<description>" + lesResultats.getString("description") + "</description>\r\n"
                            + "<annee_debut>" + date_splitAnneeDebut[2] + "-" + date_splitAnneeDebut[1] + "-" + date_splitAnneeDebut[0] + "</annee_debut>\r\n"
                            + "<annee_fin>" + date_splitAnneeFIn[2] + "-" + date_splitAnneeFIn[1] + "-" + date_splitAnneeFIn[0] + "</annee_fin>\r\n"
                            + "<id_cv>" + lesResultats.getInt("id_cv") + "</id_cv>\r\n"
                            + "</formation>\r\n");
                }
                d++;
            }
            objFile.write("</Formations>\r\n");
            objFile.write("</LesDonnees>\r\n");

            objFile.close();

        } catch (IOException ex) {
            Logger.getLogger(ImportExportXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImportExportXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String importFichier() {
        String resultat = "";

        try {
            FileReader objFile = null;

            //ouverture du fichier en lecture
            objFile = new FileReader(this.nomFichier);
            int c;
            while ((c = objFile.read()) != -1) {
                resultat += (char) c;
            }
            objFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportExportXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportExportXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }

}
