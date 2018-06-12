/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quangtinh
 */
public class NichttypsicherenMedienverwaltung {
    
    private Medium medium;
    private List liste;
    
    public NichttypsicherenMedienverwaltung(){
        liste = new ArrayList();
    }
    public void aufnehmen(Medium medium){
        liste.add(medium);
    }
    public void zeigeMedien(){
        for(Object o: liste) {
            medium =(Medium)o;
            medium.druckeDaten();  
       
        }
    }
    public void sucheNeuesMedium(){
    Medium jungstemedium = (Medium)liste.get(0);
    for(Object o: liste) {
        medium = (Medium)o;
        if(jungstemedium.getJahr()< medium.getJahr()) {
            jungstemedium = medium;
        }
    }
    jungstemedium.druckeDaten();
    }  
    
    public double berechneErscheinungsjahr() {
        double wert=0.0;
        if(!liste.isEmpty()){
            for(Object o:liste){
                medium = (Medium)o;
                wert = wert + medium.getJahr();
            }
            return wert / liste.size();
        }
        return wert;
    }
    
}

