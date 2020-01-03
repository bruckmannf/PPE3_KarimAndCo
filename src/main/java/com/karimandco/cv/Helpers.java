/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.cv;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author karim
 */
public class Helpers {

    private Connection connexion = null;

    public Helpers(Connection connexion) {
        this.connexion = connexion;
    }

    /**
     * Convertir le ResultSet en une liste de cartes, où chaque carte représente
     * une ligne avec columnNames et columValues
     *
     * @param res
     * @return
     * @throws SQLException
     */
    private List<Map<String, Object>> resultSetToList(ResultSet res) throws SQLException {
        ResultSetMetaData md = res.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (res.next()) {
            Map<String, Object> row = new HashMap<String, Object>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), res.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }

    /**
     * Permet de récuperer toute les informations d'un cv de puis la base de
     * donnée grace à l'id de l'utilisateur
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<Map<String, Object>> getCV(Integer id) throws SQLException {
        if (this.connexion != null) {
            Statement req = this.connexion.createStatement();
            ResultSet res = req.executeQuery("SELECT * FROM cv WHERE id_utilisateur = " + id);

            if (res.isBeforeFirst()) {
                return resultSetToList(res);
            }
            return null;
        }
        return null;
    }

    /**
     * Permet de récuperer toute les informations d'une formation de puis la
     * base de donnée grace à l'id de l'utilisateur
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<Map<String, Object>> getFormation(Integer id) throws SQLException {
        Statement req = this.connexion.createStatement();
        ResultSet res = req.executeQuery("SELECT * FROM formation WHERE id_cv = " + id);

        if (res.isBeforeFirst()) {
            return resultSetToList(res);
        }
        return null;
    }

    /**
     * Permet de récuperer toute les informations d'une Expérience pro de puis
     * la base de donnée grace à l'id de l'utilisateur
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<Map<String, Object>> getExperiencePro(Integer id) throws SQLException {
        Statement req = this.connexion.createStatement();
        ResultSet res = req.executeQuery("SELECT * FROM experience_pro WHERE id_cv = " + id);

        if (res.isBeforeFirst()) {
            return resultSetToList(res);
        }
        return null;
    }

    public boolean supprimerFormation(Integer idFormation) throws SQLException {
        Statement req;
        Integer res;
        if (idFormation != null) {
            req = this.connexion.createStatement();
            res = req.executeUpdate("DELETE FROM `formation` WHERE id = " + idFormation);
            return res != null ? true : false;
        }
        return false;
    }

    public boolean supprimerExperiencePro(Integer idExperiencePro) throws SQLException {
        Statement req;
        Integer res;
        if (idExperiencePro != null) {
            req = this.connexion.createStatement();
            res = req.executeUpdate("DELETE FROM `experience_pro` WHERE id = " + idExperiencePro);
            return res != null ? true : false;
        }
        return false;
    }

    public boolean supprimerCV(Integer idCV) throws SQLException {
        Statement req;
        Integer res;
        if (idCV != null) {
            req = this.connexion.createStatement();
            res = req.executeUpdate("DELETE FROM `cv` WHERE id = " + idCV);
            return res != null ? true : false;
        }
        return false;
    }
    /**
     * Cette méthode permet de supprimer tout ce qui concerne le CV donc les formations et les expériences pro, 
     * mais à ne pas utiliser dans cette classe parce qu'elle n'est pas fonctionnelle pour pouvoir 
     * utiliser cette fonctionnalité utiliser la class "Helpers"
     * 
     * @param idUtilisateur
     * @return
     * @throws SQLException
     */
    public Boolean supprimeToutCV(Integer idUtilisateur) throws SQLException {
        Boolean ok = true;
        if (this.connexion != null) {
            List<Map<String, Object>> cv = getCV(idUtilisateur);
            for (int i = 0; i < cv.size(); i++) {
                List<Map<String, Object>> experiencePro = this.getExperiencePro((Integer) cv.get(i).get("id"));
                if(experiencePro != null){
                    for (int j = 0; j < experiencePro.size(); j++) {
                        ok = this.supprimerExperiencePro((Integer) experiencePro.get(j).get("id"));
                    }
                }
                
                List<Map<String, Object>> formation = this.getFormation((Integer) cv.get(i).get("id"));
                if(formation != null){
                    for (int k = 0; k < formation.size(); k++) {
                        ok = this.supprimerFormation((Integer) formation.get(k).get("id"));
                    }
                }
                if (cv != null && ok) {
                    ok = this.supprimerCV((Integer) cv.get(i).get("id"));
                }
            }

            return ok;
        }
        return false;
    }

}
