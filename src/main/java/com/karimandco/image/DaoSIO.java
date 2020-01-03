/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.image;

/**
 *
 * @author c.nadal
 */
import com.karimandco.auth.Utilisateur;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données contenant des membres statiques afin de manipuler
 * la BDD ON implémente ici le Design Pattern Singleton
 *
 * @author nc
 */
public class DaoSIO {

    /**
     * Membres static (de classe)
     *
     */
    private static String nomServeur = "www.cnadal.fr";
    private static String port = "3306";
    private static String nomBdd = "sio1_Bruckmann_PPE3";
    private static String nomUtilisateur = "sio1_BruckmannF";
    private static String motDePasse = "knZ9YWtE";

    private static String chaineConnexion;
    //propriété non statique
    private Connection connexion;

    private static DaoSIO monDao = null;

    /**
     * Constructeur privé ! pour construire un objet, il faut utiliser la
     * méthode publique statique getDaoSIO
     *
     */
    private DaoSIO() {
        try {
            //Définition de l'emplacement de la BDD
            DaoSIO.chaineConnexion = "jdbc:mysql://" + DaoSIO.nomServeur + "/" + DaoSIO.nomBdd;

            //Création de la connexion à la BDD
            this.connexion = (Connection) DriverManager.getConnection(DaoSIO.chaineConnexion, DaoSIO.nomUtilisateur, DaoSIO.motDePasse);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Permet d'obtenir l'objet instancié
     *
     * @return un Objet DaoSIO avec connexion active ... pour une certaine durée
     */
    public static DaoSIO getInstance() {

        if (DaoSIO.monDao == null) {
            DaoSIO.monDao = new DaoSIO();
        } else {
            if (!DaoSIO.monDao.connexionActive()) {
                DaoSIO.monDao = new DaoSIO();
            }
        }
        return DaoSIO.monDao;
    }

    public Boolean connexionActive() {
        Boolean connexionActive = true;
        try {
            if (this.connexion.isClosed()) {
                connexionActive = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connexionActive;
    }

    // Requêtes générales
    /**
     *
     * @param sql, comportera un ordre selec
     * @return
     */
    public ResultSet requeteSelection(String sql) {
        try {
            Statement requete = connexion.createStatement();
            return requete.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     *
     * @param sql, comportera un ordre insert, update, select, alter, etc.
     * @return le nombre de lignes impactées par la requête action
     *
     */
    public Integer requeteAction(String sql) {
        try {
            Statement requete = connexion.createStatement();
            return requete.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return 0;

    }

    // Requêtes complexes
    /* public Integer insertImage(Integer statut, String identifiant, String mdp, String nom, String prenom, String numtel, String mail, Date date, InputStream stream, File fichier) {
        Integer create = 0;
        try {
            PreparedStatement maRequete = new DaoSIO().connexion.prepareStatement("insert into utilisateurs values (?,?,?,?,?,?,?,?,?,?)");
            //                    Échantillons test
            maRequete.setString(1, null);
            maRequete.setInt(2, statut);
            maRequete.setString(3, identifiant);
            maRequete.setString(4, mdp);
            maRequete.setString(5, nom);
            maRequete.setString(6, prenom);
            maRequete.setString(7, numtel);
            maRequete.setString(8, mail);
            maRequete.setDate(9, date);
            maRequete.setBinaryStream(10, (InputStream) stream, (int) (fichier.length()));

            create = maRequete.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return create;
    }
     */
    public Integer updateImage(InputStream stream, File fichier) {
        Integer update = 0;
        try {
            // Pour l'adapter à votre code, remplacer "identifiant" par "id" et récupérez l'id de l'utilisateur que vous souhaitez altétrer.
            PreparedStatement maRequete = this.connexion.prepareStatement("update utilisateurs set photo=? where id=" + Utilisateur.getInstance().getId());
            maRequete.setBinaryStream(1, (InputStream) stream, fichier.length());

            update = maRequete.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return update;
    }
}
