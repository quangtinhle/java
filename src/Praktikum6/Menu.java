/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum6;

import Praktikum6.Exception.EmptyFilenameException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author quangtinh
 */
public class Menu {

    int i;
    TypsicherenMedienverwaltung tmv;
    
    public Menu(TypsicherenMedienverwaltung tmv) throws EmptyFilenameException
    {
        this.tmv = tmv;
        menuVerwaltung();
    }

    public void menuVerwaltung() throws EmptyFilenameException {
        boolean isOK = true;
        do {
        System.out.println("\nMediemverwaltung\n");
        System.out.println("1. Audio aufnehmen");
        System.out.println("2. Bild aufnehmen");
        System.out.println("3. Zeige alle Medien");
        System.out.println("4. Zeige neues Medium");
        System.out.println("5. Medienliste in Datei schreiben");
        System.out.println("6. Berechne durchschnittliches Erscheinungsjahr");
        System.out.println("7. File kopieren");
        System.out.println("8. File lesen");
        System.out.println("9. Speichern");
        System.out.println("10. Laden");
        System.out.println("11. Beenden\n");
        System.out.println("Bitte Menupunkt wählen:");

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

            switch (i) {
                case 1: {
                    medienaufnehmen(1);
                    break;
                }
                case 2: {
                    medienaufnehmen(2);
                    break;
                }
                case 3: {
                    tmv.zeigeMedien();
                    break;
                }
                case 4: {
                    tmv.sucheNeuesMedium();
                    break;
                }
                case 5: {
                    String eingabe;
                    boolean isOk;
                    do {
                        eingabe = JOptionPane.showInputDialog(null, "Geben Sie der Dateiname ein");
                        if (eingabe == null) {
                            break;
                        }
                        try {
                            if (eingabe.isEmpty()) {
                                throw new EmptyFilenameException();
                            } else {
                                isOk = true;
                            }
                        } catch (EmptyFilenameException e) {
                            if (JOptionPane.showConfirmDialog(null, "Dateinamen ist lerr!. Neuen Dateiname wählen", "Hinweis", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                isOk = false;
                            } else {
                                break;
                            }
                        }
                    }
                    while (!isOk);
                    try (FileOutputStream fos = new FileOutputStream(new File("/home/quangtinh/Dropbox/Fh Dortmund/Studium/NetBeans/KI/Fh-PK1/" + eingabe + ".txt"))) {
                        tmv.schreibeMedien(fos);
                        System.out.println("File " + eingabe + " wurde geschrieben.");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.println(tmv.berechneErscheinungsjahr());
                    break;
                }
                case 7: {
                    String verzeichnis="/home/quangtinh/Dropbox/Fh Dortmund/Studium/NetBeans/KI/Fh-PK1/";
                    String von = JOptionPane.showInputDialog(null,"Geben Sie Dateiname ein ");
                    String nach = JOptionPane.showInputDialog(null,"Geben Sie neu Dateiname ein");

                    try {
                        tmv.kopierenMitRandomAccessFile(verzeichnis+von+".txt",verzeichnis+nach+".txt");
                    }catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 8: {
                    String eingabe = JOptionPane.showInputDialog(null, "Geben Sie die Dateiname ein");
                    try {
                        tmv.leseFile(new File("/home/quangtinh/Dropbox/Fh Dortmund/Studium/NetBeans/KI/Fh-PK1/" + eingabe + ".txt"));
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 9: {
                    tmv.serialisieren(new File("/home/quangtinh/Dropbox/Fh Dortmund/Studium/NetBeans/KI/Fh-PK1/serial.ser"));
                    break;
                }
                case 10: {
                    tmv.setListe(tmv.deserialisieren(new File("/home/quangtinh/Dropbox/Fh Dortmund/Studium/NetBeans/KI/Fh-PK1/serial.ser")));
                    break;
                }
                case 11: {
                    isOK = false;
                    System.out.println("Das Programm ist beendet.");
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "Eingabe ist ungültig, bitte versuchen Sie nochmal");
                }
            }
        }while (isOK) ;
    }

    public void medienaufnehmen(int i) throws EmptyFilenameException {
        int jahr = 0;
        boolean isOk;
        String eingabe = JOptionPane.showInputDialog(null, "Geben bitte das Titel ein");
        String titel = eingabe;
        int dauer = 0;
        do{
            try {
                eingabe = JOptionPane.showInputDialog(null,"Geben bitte das Erscheinungsjahr ein");
                jahr = Integer.parseInt(eingabe);
                isOk = true;
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Bitte gültiges Erscheinungsjahr eingeben");
                isOk = false;
            }
        }while(!isOk);
        if(i==1) {
            eingabe = JOptionPane.showInputDialog(null, "Geben bitte der Interpret ein");
            String interpret = eingabe;
            do {
                try {
                    eingabe = JOptionPane.showInputDialog(null, "Geben bitte das Dauer ein");
                    dauer = Integer.parseInt(eingabe);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Bitte gültiges Dauer eintragen");
                    isOk = false;
                }
            } while (!isOk);
            Audio a = new Audio(titel, jahr, interpret, dauer);
            tmv.aufnehmen(a);
            tmv.zeigeMedien();
        }
        else {
            eingabe = JOptionPane.showInputDialog(null, "Geben bitte das Ort ein");
            String ort = eingabe;
            Bild b = new Bild(titel, jahr, ort);
            tmv.aufnehmen(b);
            tmv.zeigeMedien();

        }
    }
    
}
