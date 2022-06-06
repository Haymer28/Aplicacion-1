/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.pkg1;

/**
 *
 * @author SAMSUNG-PC
 */
public class Nodo {
    
    //Con estos atributos se trabaja en la clase Lista
    private double columna2;
    private double columna;
    public Nodo siguiente;
   
    //Este constructor es para hacer instancias en otras clases
    public Nodo(double columna, double columna2) {
        this.columna = columna;
        this.columna2 = columna2;
    }

    public Nodo() {
    }
    
    //Metodos get y set necesarios para poder manipular 
    //los atributos que esten encapsulados como privados
    public double getColumna() {
        return columna;
    }

    public void setColumna(double columna) {
        this.columna = columna;
    }

    public double getColumna2() {
        return columna2;
    }

    public void setColumna2(double columna2) {
        this.columna2 = columna2;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
