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
public class ImportExportJSON extends Export {

    public ImportExportJSON(String nomFichier) {
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
            Integer nbUtilisateur = 0;
            Integer nbElementCv = 0;
            Integer nbElementExpPro = 0;
            Integer nbElementFormation = 0;
            objFile = new FileWriter(this.nomFichier);
            objFile.write("{\r\n");
            objFile.write("\"utilisateurs\": [");
            ResultSet nbElement = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM utilisateurs");
            if (nbElement.next()) {
                nbUtilisateur = nbElement.getInt(1) - 1;
            }

            ResultSet lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM utilisateurs");
            while (a != nbUtilisateur) {

                if (lesResultats.next()) {
                    String[] date_split = lesResultats.getString("date_de_naissance").split("-");
                    objFile.write("{\r\n"
                            + "\"id\": \"" + lesResultats.getInt("id") + "\",\r\n"
                            + "\"statut\": \"" + lesResultats.getInt("statut") + "\",\r\n"
                            + "\"identifiant\": \"" + lesResultats.getString("identifiant") + "\",\r\n"
                            + "\"nom\": \"" + lesResultats.getString("nom") + "\",\r\n"
                            + "\"prenom\": \"" + lesResultats.getString("prenom") + "\",\r\n"
                            + "\"num_telephone\": \"" + lesResultats.getString("num_telephone") + "\",\r\n"
                            + "\"courriel\": \"" + lesResultats.getString("courriel") + "\",\r\n"
                            + "\"date_de_naissance\": \"" + date_split[2] + "-" + date_split[1] + "-" + date_split[0] + "\",\r\n"
                            + "\"photo\": \"" + lesResultats.getBlob("photo") + "\"\r\n"
                            + "},\r\n");
                }
                a++;
            }
            ResultSet dernierResultatUser = DaoSIO.getInstance().requeteSelection("SELECT * FROM utilisateurs ORDER BY id DESC LIMIT 1");
            if (dernierResultatUser.next()) {
                String[] date_split = dernierResultatUser.getString("date_de_naissance").split("-");
                objFile.write("{\r\n"
                        + "\"id\": \"" + dernierResultatUser.getInt("id") + "\",\r\n"
                        + "\"statut\": \"" + dernierResultatUser.getInt("statut") + "\",\r\n"
                        + "\"identifiant\": \"" + dernierResultatUser.getString("identifiant") + "\",\r\n"
                        + "\"nom\": \"" + dernierResultatUser.getString("nom") + "\",\r\n"
                        + "\"prenom\": \"" + dernierResultatUser.getString("prenom") + "\",\r\n"
                        + "\"num_telephone\": \"" + dernierResultatUser.getString("num_telephone") + "\",\r\n"
                        + "\"courriel\": \"" + dernierResultatUser.getString("courriel") + "\",\r\n"
                        + "\"date_de_naissance\": \"" + date_split[2] + "-" + date_split[1] + "-" + date_split[0] + "\",\r\n"
                        + "\"photo\": \"" + dernierResultatUser.getBlob("photo") + "\"\r\n"
                        + "}\r\n");
            }
            objFile.write("],");
            objFile.write("\"cv\": [");

            ResultSet nbCv = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM cv");
            if (nbCv.next()) {
                nbElementCv = nbCv.getInt(1) - 1;
            }

            lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM cv");
            while (b != nbElementCv) {
                if (lesResultats.next()) {
                    objFile.write("{\r\n"
                            + "\"id\": \"" + lesResultats.getInt("id") + "\",\r\n"
                            + "\"titre\": \"" + lesResultats.getString("titre") + "\",\r\n"
                            + "\"description\": \"" + lesResultats.getString("description") + "\",\r\n"
                            + "\"signature\": \"" + lesResultats.getString("signature") + "\",\r\n"
                            + "\"nom_maitrise\": \"" + lesResultats.getString("nom_maitrise") + "\",\r\n"
                            + "\"maitrise\": \"" + lesResultats.getString("maitrise") + "\",\r\n"
                            + "\"id_utilisateur\": \"" + lesResultats.getInt("id_utilisateur") + "\"\r\n"
                            + "},\r\n");
                }
                b++;
            }
            ResultSet dernierResultatCv = DaoSIO.getInstance().requeteSelection("SELECT * FROM cv ORDER BY id DESC LIMIT 1");
            if (dernierResultatCv.next()) {
                objFile.write("{\r\n"
                        + "\"id\": \"" + dernierResultatCv.getInt("id") + "\",\r\n"
                        + "\"titre\": \"" + dernierResultatCv.getString("titre") + "\",\r\n"
                        + "\"description\": \"" + dernierResultatCv.getString("description") + "\",\r\n"
                        + "\"signature\": \"" + dernierResultatCv.getString("signature") + "\",\r\n"
                        + "\"nom_maitrise\": \"" + dernierResultatCv.getString("nom_maitrise") + "\",\r\n"
                        + "\"maitrise\": \"" + dernierResultatCv.getString("maitrise") + "\",\r\n"
                        + "\"id_utilisateur\": \"" + dernierResultatCv.getInt("id_utilisateur") + "\"\r\n"
                        + "}\r\n");
            }
            objFile.write("],");
            objFile.write("\"experience_pro\": [");
            ResultSet nbExpPro = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM experience_pro");
            if (nbExpPro.next()) {
                nbElementExpPro = nbExpPro.getInt(1) -1;
            }
            lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM experience_pro");
            while (c != nbElementExpPro) {
                if (lesResultats.next()) {
                    String[] date_splitAnneeDebut = lesResultats.getString("annee_debut").split("-");
                    String[] date_splitAnneeFIn = lesResultats.getString("annee_fin").split("-");
                    objFile.write("{\r\n"
                            + "\"id\": \"" + lesResultats.getInt("id") + "\",\r\n"
                            + "\"entreprise\": \"" + lesResultats.getString("entreprise") + "\",\r\n"
                            + "\"adresse\": \"" + lesResultats.getString("adresse") + "\",\r\n"
                            + "\"description\": \"" + lesResultats.getString("description") + "\",\r\n"
                            + "\"annee_debut\": \"" + date_splitAnneeDebut[2] + "-" + date_splitAnneeDebut[1] + "-" + date_splitAnneeDebut[0] + "\",\r\n"
                            + "\"annee_fin\": \"" + date_splitAnneeFIn[2] + "-" + date_splitAnneeFIn[1] + "-" + date_splitAnneeFIn[0] + "\",\r\n"
                            + "\"id_cv\": \"" + lesResultats.getInt("id_cv") + "\"\r\n"
                            + "},\r\n");
                }
                c++;
            }
            ResultSet dernierResultatExpPro = DaoSIO.getInstance().requeteSelection("SELECT * FROM experience_pro ORDER BY id DESC LIMIT 1");
            if (dernierResultatExpPro.next()) {
                String[] date_splitAnneeDebut = dernierResultatExpPro.getString("annee_debut").split("-");
                String[] date_splitAnneeFIn = dernierResultatExpPro.getString("annee_fin").split("-");
                objFile.write("{\r\n"
                        + "\"id\": \"" + dernierResultatExpPro.getInt("id") + "\",\r\n"
                        + "\"entreprise\": \"" + dernierResultatExpPro.getString("entreprise") + "\",\r\n"
                        + "\"adresse\": \"" + dernierResultatExpPro.getString("adresse") + "\",\r\n"
                        + "\"description\": \"" + dernierResultatExpPro.getString("description") + "\",\r\n"
                        + "\"annee_debut\": \"" + date_splitAnneeDebut[2] + "-" + date_splitAnneeDebut[1] + "-" + date_splitAnneeDebut[0] + "\",\r\n"
                        + "\"annee_fin\": \"" + date_splitAnneeFIn[2] + "-" + date_splitAnneeFIn[1] + "-" + date_splitAnneeFIn[0] + "\",\r\n"
                        + "\"id_cv\": \"" + dernierResultatExpPro.getInt("id_cv") + "\"\r\n"
                        + "}\r\n");
            }
            objFile.write("],");
            objFile.write("\"formation\": [");
            ResultSet nbFormation = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM formation");

            if (nbFormation.next()) {
                nbElementFormation = nbFormation.getInt(1) -1;
            }

            lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM formation");
            while (d != nbElementFormation) {

                if (lesResultats.next()) {
                    String[] date_splitAnneeDebut = lesResultats.getString("annee_debut").split("-");
                    String[] date_splitAnneeFIn = lesResultats.getString("annee_fin").split("-");
                    objFile.write("{\r\n"
                            + "\"id\": \"" + lesResultats.getInt("id") + "\",\r\n"
                            + "\"nom\": \"" + lesResultats.getString("nom") + "\",\r\n"
                            + "\"lieu\": \"" + lesResultats.getString("lieu") + "\",\r\n"
                            + "\"description\": \"" + lesResultats.getString("description") + "\",\r\n"
                            + "\"annee_debut\": \"" + date_splitAnneeDebut[2] + "-" + date_splitAnneeDebut[1] + "-" + date_splitAnneeDebut[0] + "\",\r\n"
                            + "\"annee_fin\": \"" + date_splitAnneeFIn[2] + "-" + date_splitAnneeFIn[1] + "-" + date_splitAnneeFIn[0] + "\",\r\n"
                            + "\"id_cv\": \"" + lesResultats.getInt("id_cv") + "\"\r\n"
                            + "},\r\n");
                }
                d++;
            }
            ResultSet dernierResultatFromation = DaoSIO.getInstance().requeteSelection("SELECT * FROM formation ORDER BY id DESC LIMIT 1");
            if (dernierResultatFromation.next()) {
                String[] date_splitAnneeDebut = dernierResultatFromation.getString("annee_debut").split("-");
                String[] date_splitAnneeFIn = dernierResultatFromation.getString("annee_fin").split("-");
                objFile.write("{\r\n"
                        + "\"id\": \"" + dernierResultatFromation.getInt("id") + "\",\r\n"
                        + "\"nom\": \"" + dernierResultatFromation.getString("nom") + "\",\r\n"
                        + "\"lieu\": \"" + dernierResultatFromation.getString("lieu") + "\",\r\n"
                        + "\"description\": \"" + dernierResultatFromation.getString("description") + "\",\r\n"
                        + "\"annee_debut\": \"" + date_splitAnneeDebut[2] + "-" + date_splitAnneeDebut[1] + "-" + date_splitAnneeDebut[0] + "\",\r\n"
                        + "\"annee_fin\": \"" + date_splitAnneeFIn[2] + "-" + date_splitAnneeFIn[1] + "-" + date_splitAnneeFIn[0] + "\",\r\n"
                        + "\"id_cv\": \"" + dernierResultatFromation.getInt("id_cv") + "\"\r\n"
                        + "}\r\n");
            }
            objFile.write("]");
            objFile.write("}\r\n");
            objFile.close();

        } catch (IOException ex) {
            Logger.getLogger(ImportExportJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImportExportJSON.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ImportExportJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportExportJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }

}
