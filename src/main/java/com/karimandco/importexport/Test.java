/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.importexport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author c.nadal
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ImportExportXML objEXML = new ImportExportXML("src\\com\\karimandco\\importexport\\BddExporterXml.xml");
        objEXML.exportFichier();
        Desktop.getDesktop().open(new File("src\\com\\karimandco\\importexport\\BddExporterXml.xml"));
        System.out.println(objEXML.importFichier());
        ImportExportCSV objECvs = new ImportExportCSV("src\\com\\karimandco\\importexport\\BddExporterCsv.csv");
        objECvs.exportFichier();
        System.out.println(objECvs.importFichier());
        ImportExportJSON objEJson = new ImportExportJSON("src\\com\\karimandco\\importexport\\BddExporterJson.json");
        objEJson.exportFichier();
        System.out.println(objEJson.importFichier());
    }
}
