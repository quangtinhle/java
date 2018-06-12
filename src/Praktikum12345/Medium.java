/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum12345;

import java.time.LocalDate;
import java.io.OutputStream;

/**
 *
 * @author quangtinh
 */
public abstract class Medium implements Comparable<Medium> {
    
    private static int anz;
    private final int id ;
    private String titel;
    private int jahr;
    
    public Medium(String titel, int jahr) {
        this.id = anz ++;
        this.titel = titel;
        this.jahr = jahr;
    }
    
    public String getTitel() {
        return this.titel;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getJahr() {
        return this.jahr;
    }
    
    public int alter() {
        return LocalDate.now().getYear() - this.jahr;
    }
    public abstract void druckeDaten(); 
    
//    @Override
//    public int compareTo(Medium o) {
//        if(this.getJahr() > o.getJahr()) return 1;
//        else
//                if(this.getJahr() == o.getJahr()) return 0;
//        return -1;
//    }
    public int compareTo(Medium o) {
        return Double.compare(this.getJahr(), o.getJahr()) * -1;
    }
    
    public abstract void druckeDatenStream(OutputStream stream);
    
    
}
