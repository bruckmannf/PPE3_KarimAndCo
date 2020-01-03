/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karimandco.cv;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author l.desmalades
 */
public class ClassDate extends JTextField {

    public ClassDate() {
        super();
        this.setText("2019-01-01");
        if (this.verifDate()) {
            setForeground(Color.green);
        } else {
            setForeground(Color.red);

        }
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {

                if (verifDate()) {
                    setForeground(Color.green);

                } else {
                    setForeground(Color.red);

                }
// JOptionPane.showMessageDialog(null, getText());
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    Boolean verifDate() {
        Pattern p = Pattern.compile("\\d{1,4}[-]\\d{1,2}[-]\\d{1,2}");
        Matcher m = p.matcher(getText());
        String ip = this.getText();
        String[] tabDate = ip.split("[-]");
        Boolean dateOK = m.matches();
        if (Integer.parseInt(tabDate[1]) < 1 || Integer.parseInt(tabDate[1]) > 12) {
            dateOK = false;
        } else if (Integer.parseInt(tabDate[0]) < 1 || Integer.parseInt(tabDate[0]) > 9999) {
            dateOK = false;
        } else if (Integer.parseInt(tabDate[2]) < 1 || Integer.parseInt(tabDate[2]) > 31) {
            dateOK = false;
        } else if (Integer.parseInt(tabDate[1]) == 2 || Integer.parseInt(tabDate[1]) == 4 || Integer.parseInt(tabDate[1]) == 6 || Integer.parseInt(tabDate[1]) == 9 || Integer.parseInt(tabDate[1]) == 11) {
            if (Integer.parseInt(tabDate[2]) > 30) {
                dateOK = false;
            }else if(Integer.parseInt(tabDate[1]) == 2){
            Integer an = Integer.parseInt(tabDate[0]);
            if( verifAnBisextile(an)== true){
                if(Integer.parseInt(tabDate[2])>29){
                    dateOK = false;
                }
            }else{
               if(Integer.parseInt(tabDate[2])>28){
                    dateOK = false;
                } 
            }
        }
        }
        return dateOK;
    }

    Boolean verifAnBisextile(Integer an) {
        if ((an % 4 == 0 && an % 100 != 0) || an % 400 == 0) {
            return true;
        }
        return false;
    }

    public String[] GetDate() {
        String date = this.getText();
        String[] tabDate = date.split("[-]");
        return tabDate;
    }
}
