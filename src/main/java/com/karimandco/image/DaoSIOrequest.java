/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.image;

import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author metac
 */
public class DaoSIOrequest {

    /**
     *
     * @param sql, comportera un ordre selec
     * @return
     */
    public ResultSet requeteSelection(String sql) {
        DaoSIO co = DaoSIO.getInstance();
        return co.requeteSelection(sql);
    }

    /**
     *
     * @param sql, comportera un ordre insert, update, select, alter, etc.
     * @return le nombre de lignes impactées par la requête action
     *
     */
    public Integer requeteAction(String sql) {
        DaoSIO co = DaoSIO.getInstance();
        return co.requeteAction(sql);

    }

    /**
     *
     * @param statut le statut de l'utilisateur
     * @param identifiant l'identifiant
     * @param mdp le mot de passe
     * @param nom le nom
     * @param prenom le prenom
     * @param numtel le numéro de téléphone
     * @param mail l'adresse mail
     * @param date la date de naissance de l'utilisateur sous format dd/mm/yyyy
     * @param stream le code binaire de la photo de profil
     * @param fichier le chemin d'accès à l'image
     * @return 1) Si l'image a bien été insérée. 0) Si l'insertion a échouée.
     */
    

    /**
     *
     * @param stream, le code binaire de la photo de profil
     * @param fichier, le chemin d'accès à l'image
     * @return 1) Si l'image a bien été insérée. 0) Si l'insertion a échouée.
     */
    public Integer updateImage(InputStream stream, File fichier) {
        DaoSIO co = DaoSIO.getInstance();
        return co.updateImage(stream, fichier);
    }
}
