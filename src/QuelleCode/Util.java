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
public class Util {
    
    public static void swap(Comparable[] liste, int i, int j) {
        Comparable temp = liste[i];
        liste[i] = liste[j];
        liste[j] = temp;
    }
    
    public static void bubbleSort(Comparable[] liste) {
        for(int i = 0; i < liste.length; i++)
            for(int j = 0; j < liste.length -1 -i;j++) {
                if(liste[j].compareTo(liste[j+1]) > 0) {
                    swap(liste,j,j+1);
                }
            }
    }
    
    public static void main(String[] args) {
        
        Angestellter [] liste = { new Angestellter("Obermeier", 1000.00),new Angestellter("Meier",500.00)};
        Util.bubbleSort(liste);
        for(Angestellter a : liste) {
            System.out.println(a.getName() + " bekommt " + a.getGehalt() );
        }
    }
    
}
