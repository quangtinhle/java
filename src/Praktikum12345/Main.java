/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum12345;

import Praktikum12345.Exception.EmptyFilenameException;

/**
 *
 * @author quangtinh
 */
public class Main {
    
    public static void main(String args[]) throws EmptyFilenameException {
        
        //NichttypsicherenMedienverwaltung medienverwaltung = new NichttypsicherenMedienverwaltung();
        
//        Audio a1 = new Audio("It means Nothing",2007,"Stereophonics",229);
//        Bild b1 = new Bild("Gebaeude FB Informatik",2014,"Dortmund");
//        Bild b2 = new Bild("Das Schreit",2017,"Essen");
//        Audio a2 = new Audio("Davici Code",2018,"Stereophonics",999);
        //medienverwaltung.aufnehmen(a1);
        //medienverwaltung.aufnehmen(b1);
        //medienverwaltung.zeigeMedien();
        //medienverwaltung.sucheNeuesMedium();
        //System.out.println(medienverwaltung.berechneErscheinungsjahr());
//        a1.druckDaten();
//        b1.druckDaten();
        //Medienverwaltung mv = new Medienverwaltung();
        //mv.aufnehmen(b1);
        //mv.aufnehmen(a1);
        //mv.aufnehmen(b1);
        //mv.aufnehmen(b1);
        
        //mv.zeigeMedien();
        //System.out.println(a1.getTitel() + " ist " + a1.alter() + " Jahre alt");
        TypsicherenMedienverwaltung tmv = new TypsicherenMedienverwaltung();
        Menu menu = new Menu(tmv);
        //tmv.aufnehmen(b1);
        //tmv.aufnehmen(a1);
        //tmv.aufnehmen(b2);
        //tmv.aufnehmen(a2);
        //tmv.zeigeMedien();
        //tmv.sucheNeuesMedium();

        
    }
    
}
