/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum12345;

import java.io.*;
import java.util.*;

/**
 *
 * @author quangtinh
 */
public class TypsicherenMedienverwaltung {
    
    private List<Medium> liste;
    private Medium medium;
    
    public TypsicherenMedienverwaltung() {
        
        liste = new ArrayList();
 }
    public void aufnehmen(Medium medium) {
        liste.add(medium);
    }
    
    public void zeigeMedien() {
        if(liste.isEmpty()) System.out.println("Es gibt kein Medien");
        else {
            Collections.sort(liste);
            Iterator <Medium> it = liste.iterator();
            while(it.hasNext()) {
                it.next().druckeDaten();
            }
        }
    }
    
    public void schreibeMedien(OutputStream stream) {
        Collections.sort(liste);
        Iterator<Medium> it = liste.iterator();
        while(it.hasNext()) {
            it.next().druckeDatenStream(stream);
        }
    }
    
    public void sucheNeuesMedium() {
        Medium jungstemedium = liste.get(0);
        for(Medium m:  liste) {
            if(jungstemedium.getJahr()< m.getJahr())
                jungstemedium = m;
        }
        jungstemedium.druckeDaten();
    }
    
    public double berechneErscheinungsjahr() {
        if (liste.isEmpty()) return 0.0;
        double wert = 0.0;
        Iterator <Medium> it = liste.iterator();
        while(it.hasNext()) {
           wert = wert + it.next().getJahr();
        }
        return wert / liste.size();
        
    }
    public void kopierenMitRandomAccessFile(String von, String nach) throws FileNotFoundException {

        RandomAccessFile input = new RandomAccessFile(new File(von), "r");
        RandomAccessFile ouput = new RandomAccessFile(new File(nach), "rw");

        try {
            int data = input.read();
            while (data != -1) {
                System.out.println(data);
                ouput.write(data);
                data = input.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                input.close();
                ouput.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void leseFile(File file) throws FileNotFoundException {
        FileReader fir = new FileReader(file);
        try{
            int data = fir.read();
            while (data != -1) {
                System.out.print((char)data);
                data = fir.read();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                fir.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
