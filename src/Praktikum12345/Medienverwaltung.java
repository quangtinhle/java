/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum12345;

/**
 *
 * @author quangtinh
 */
public class Medienverwaltung {

    private Medium[] liste;
    private Medium medium;
    private final int maxanz = 2;
    private static int anz = 0;

    public Medienverwaltung() {
        liste = new Medium[maxanz];
    }

    public void aufnehmen(Medium medium) {
        if (anz < maxanz) {
            liste[anz++] = medium;
            System.out.println("Das Medium wurde hinzugefügt");
        } else {
            System.out.println("Medienverwaltung gibt es kein Platz mehr. Das Medium wurde nicht hinzugefügt");
        }
    }

    public void zeigeMedien() {
        for (Object o : liste) {
            medium = (Medium) o;
            medium.druckeDaten();
        }
    }

    public void sucheNeuesMedium() {
        Medium jungstemedien = liste[0];
        for (int i = 1; i < liste.length; i++) {
            if (jungstemedien.getJahr() < liste[i].getJahr()) {
                jungstemedien = liste[i];
            }
        }
        jungstemedien.druckeDaten();
    }

    public double berechneErscheinungsjahr() {
        double wert = 0.0;
        if (liste!=null) {
            for (int i = 0; i < liste.length; i++) {
                wert = liste[i].getJahr() + wert;
            }
            return wert / liste.length;
        }
        return wert;
    }

}
