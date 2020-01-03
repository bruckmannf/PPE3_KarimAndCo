/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.importexport;

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
public class ImportExportCSV extends Export {

    public ImportExportCSV(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    @Override
    public void exportFichier() {
        FileWriter objFile = null;

        try {
            //ouverture du fichier en écriture
            Integer a = 0;
            Integer nbUtilisateur = null;
            objFile = new FileWriter(this.nomFichier);
            ResultSet nbElement = DaoSIO.getInstance().requeteSelection("SELECT count(*) FROM utilisateurs");
            if (nbElement.next()) {
                nbUtilisateur = nbElement.getInt(1);
            }
            objFile.write("id; statut; identifiant; nom; prenom; num_telephone; courriel; date_de_naissance; photo; id; titre; description; signature; nom_maitrise; maitrise; id_utilisateur\r\n");
            ResultSet lesResultats = DaoSIO.getInstance().requeteSelection("SELECT * FROM utilisateurs");
            while (a != nbUtilisateur) {

                if (lesResultats.next()) {
                    String[] date_split = lesResultats.getString("date_de_naissance").split("-");
                    objFile.write(lesResultats.getInt("id") + "; " + lesResultats.getInt("statut") + "; " + lesResultats.getString("identifiant") + "; " + lesResultats.getString("nom") + "; " + lesResultats.getString("prenom") + "; " + lesResultats.getString("num_telephone") + "; " + lesResultats.getString("courriel") + "; " + date_split[2] + "-" + date_split[1] + "-" + date_split[0] + "; " + lesResultats.getBlob("photo") + "\r\n");
                }
                a++;
            }

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
            Logger.getLogger(ImportExportCSV.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ImportExportCSV.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;
    }

}
