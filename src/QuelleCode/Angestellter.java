/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuelleCode;

/**
 *
 * @author quangtinh
 */
public class Angestellter implements Comparable<Angestellter> {
    
    private String name;
    private double gehalt;
    
    public Angestellter(String name, double gehalt) {
        this.name = name;
        this.gehalt = gehalt;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getGehalt() {
        return gehalt;
    }
    
    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }
    
    public double berechneJahresgehalt() {
        return 12 * gehalt;
    }
    
    public int compareTo(Angestellter o) {
        return Double.compare(this.getGehalt(), o.getGehalt());
    }
    
    
}
