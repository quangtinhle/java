/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum6;

import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author quangtinh
 */
public abstract class Medium implements Comparable<Medium>,Serializable {
    
    private static int anz;
    private final int id ;
    private static final long serialVersionUID = -1234567890L;
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

    public static void setAnz(int anz) {
        Medium.anz = anz;
    }

    public int alter() {
        return LocalDate.now().getYear() - this.jahr;
    }
    public abstract void druckeDaten(); 
    
    public int compareTo(Medium o) {
        return Double.compare(this.getJahr(), o.getJahr()) * -1;
    }
    
    public abstract void druckeDatenStream(OutputStream stream);
    
    
}
