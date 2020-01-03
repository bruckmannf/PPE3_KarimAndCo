/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.admin;

import com.karimandco.bdd.DaoSIO;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author karim
 */
public final class Helpers {
    

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
        if (DaoSIO.getInstance().connexionActive()) {
            ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT * FROM cv WHERE id_utilisateur = '" + id + "'");
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
       
        ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT * FROM formation WHERE id_cv = " + id);

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
   
        ResultSet res = DaoSIO.getInstance().requeteSelection("SELECT * FROM experience_pro WHERE id_cv = " + id);

        if (res.isBeforeFirst()) {
            return resultSetToList(res);
        }
        return null;
    }

    public boolean supprimerFormation(Integer idFormation) throws SQLException {
        
        Integer res;
        if (idFormation != null) {
            
             res = DaoSIO.getInstance().requeteAction("DELETE FROM `formation` WHERE id = " + idFormation);
            return res != null ? true : false;
        }
        return false;
    }

    public boolean supprimerExperiencePro(Integer idExperiencePro) throws SQLException {
        Integer res;
        if (idExperiencePro != null) {
            res = DaoSIO.getInstance().requeteAction("DELETE FROM `experience_pro` WHERE id = " + idExperiencePro);
            return res != null ? true : false;
        }
        return false;
    }

    public boolean supprimerCV(Integer idCV) throws SQLException {
        Integer res;
        if (idCV != null) {
            res = DaoSIO.getInstance().requeteAction("DELETE FROM `cv` WHERE id = " + idCV);
            return res != null ? true : false;
        }
        return false;
    }

    public Boolean supprimeToutCV(Integer idUtilisateur) throws SQLException {
        Boolean ok = true;
        if (DaoSIO.getInstance().connexionActive() != null) {
            List<Map<String, Object>> cv = getCV(idUtilisateur);
            if(cv != null){
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
            }
            return ok;
        }
        return false;
    }
}
