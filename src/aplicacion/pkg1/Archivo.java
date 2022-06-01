/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SAMSUNG-PC
 */
public class Archivo  {
    
    private BufferedReader lector;
    private String linea;
    private String partes[]= null;
    int columna;
    double columna2;

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public double getColumna2() {
        return columna2;
    }

    public void setColumna2(double columna2) {
        this.columna2 = columna2;
    }
 
    
    public void leerArchivo(String nombreArchivo){
        try {
        lector = new BufferedReader(new FileReader(nombreArchivo));
        while ((linea = lector.readLine()) != null){
            partes = linea.split(",");
            
            
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void leerArchivo2(String nombreArchivo){
        try {
        lector = new BufferedReader(new FileReader(nombreArchivo));
        while ((linea = lector.readLine()) != null){
            partes = linea.split(",");
          
           
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void mostrarLinea(){
        for (int i=0; i< partes.length; i++){   
            setColumna(Integer.parseInt(partes[0]));
        }
        
    }
    
     public void mostrar(){
        for (int i=0; i< partes.length; i++){
            setColumna2(Double.parseDouble(partes[1]));
        }
        
    }
    
    
    
    
    
    
    
    
}
