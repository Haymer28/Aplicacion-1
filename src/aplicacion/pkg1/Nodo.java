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
public class Nodo{
    
    private double columna2;
    private double columna;
    public Nodo siguiente;
    
    public Nodo(double columna, double columna2){
        this.columna = columna;
        this.columna2 = columna2;
    }
    
    public Nodo(){
    }

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
