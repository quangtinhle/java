/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum6;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 *
 * @author quangtinh
 */
public class Audio extends Medium implements Serializable {
    
    private String interpret;
    private int dauer;
    
    public Audio(String titel, int jahr, String interpret, int dauer) {
        super(titel,jahr);
        this.interpret = interpret;
        this.dauer = dauer;
    }
    
    
    public void druckeDaten() {
        System.out.println("ID = " + this.getId()+ " " + this.getTitel() + " von " + this.interpret + " aus " + this.getJahr()+ "  Spielerdauer : " + this.dauer + " sek");
    }
    
    @Override
    public void druckeDatenStream(OutputStream stream){
        String eingabe = "ID = " + this.getId()+ " " + this.getTitel() + " von " + this.interpret + " aus " + this.getJahr()+ "  Spielerdauer : " + this.dauer + " sek/n";
        try {
            OutputStreamWriter osw = new OutputStreamWriter(stream);
            PrintWriter pw = new PrintWriter(osw);
            pw.printf(eingabe);
            pw.flush();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
