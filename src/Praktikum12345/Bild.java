/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum12345;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author quangtinh
 */
public class Bild extends Medium {
    
    private String ort;
    
    public Bild(String titel, int jahr, String ort) {
        super(titel,jahr);
        this.ort = ort;
    }
    
    @Override
    public void druckeDaten() {
        System.out.println("ID = " + this.getId()+ " " + this.getTitel() + " aufgenommen im Jahr " + this.getJahr()+ " in " + this.ort );
    }
    
    @Override
    public void druckeDatenStream(OutputStream stream){
        String eingabe = "ID = " + this.getId()+ " " + this.getTitel() + " aufgenommen im Jahr " + this.getJahr()+ " in " + this.ort +"/n";
        try {
            OutputStreamWriter osw = new OutputStreamWriter(stream);
            PrintWriter pw = new PrintWriter(osw);
            pw.printf(eingabe);
            pw.flush();
        }catch (Exception e){
          e.printStackTrace();
        }
    }
}
