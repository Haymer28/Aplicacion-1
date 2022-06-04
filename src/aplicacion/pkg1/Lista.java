/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author SAMSUNG-PC
 */
public class Lista {

    private Nodo inicio;
    private Nodo inicio2;
    private int cantidad;
    private int cantidad2;
    private double columna;
    private double columna2;
    private double var;
    private double var2;

    public double getVar() {
        return var;
    }

    public void setVar(double var) {
        this.var = var;
    }

    public double getVar2() {
        return var2;
    }

    public void setVar2(double var2) {
        this.var2 = var2;
    }
    public int getCantidad2() {
        return cantidad2;
    }

    public void setCantidad2(int cantidad2) {
        this.cantidad2 = cantidad2;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void Lista() {
        inicio = null;
    }

    public void Lista2() {
        inicio2 = null;
    }

    public boolean Vacia() {
        return inicio == null;
    }

    public boolean Vacia2() {
        return inicio2 == null;
    }

    public void agregarCol1(double col) {
        Nodo nodo = new Nodo();
        nodo.setColumna(col);
        if (Vacia()) {
            inicio = nodo;
        } else {
            Nodo temporal = inicio;
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();

            }
            temporal.setSiguiente(nodo);
        }
        cantidad++;
        setCantidad(cantidad);
    }

    public void agregarCol2(double col2) {
        Nodo nodo2 = new Nodo();
        nodo2.setColumna2(col2);
        //System.out.println(nodo2.getColumna2());
        if (Vacia2()) {
            inicio2 = nodo2;
        } else {
            Nodo temporal = inicio2;
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nodo2);
        }
        cantidad2++;
        setCantidad2(cantidad2);
    }

    public void listar() {
        if (!Vacia()) {
            Nodo tem = inicio;
            int i = 0;
            System.out.println("Columna 1");
            while (tem != null) {
                System.out.print(tem.getColumna() + " | ");
                tem = tem.getSiguiente();
                i++;
            }
        }
    }

    public void listar2() {
        if (!Vacia2()) {
            Nodo tem = inicio2;

            int i = 0;
            System.out.println("Columna 2");
            while (tem != null) {
                System.out.print(tem.getColumna2() + " | ");
                tem = tem.getSiguiente();

                i++;
            }
        }
    }
 
    private BufferedReader lector;
    private String linea;
    private String partes[] = null;

    public void leerArchivo(String nombreArchivo) {
        try {
            lector = new BufferedReader(new FileReader(nombreArchivo));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(";");

                columna = (Double.parseDouble(partes[0]));
                agregarCol1(columna);

                columna2 = (Double.parseDouble(partes[1]));
                agregarCol2(columna2);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            System.out.println("No se encontro el archivo");
        }
    }
    
    double suma = 0;
    double suma2 = 0;
        
    public void mostrarMedia(){
        
        
        if (!Vacia()) {
            Nodo tem = inicio;
            int i = 0;
            while (tem != null) {
                suma = suma + tem.getColumna();
                tem = tem.getSiguiente();
                i++;
            }
            suma /= getCantidad();
            System.out.println(suma);
        }
      
    }
    
    public void mostrarMedia2(){
        
        if (!Vacia2()) {
            Nodo tem = inicio2;
            int i = 0;
            while (tem != null) {
                suma2 = suma2 + tem.getColumna2();
                tem = tem.getSiguiente();
                i++;
            } 
            DecimalFormat form = new DecimalFormat("#.##");
            suma2 /= getCantidad2();
            System.out.println(form.format(suma2));
        }
    }
    
    
    public void mostrarVarianza(){
        double cifra = 0;
        
        if (!Vacia()){
            Nodo tem = inicio;
            int i = 0;
            while (tem != null){
                cifra = cifra + (Math.pow((tem.getColumna() - suma), 2));
                tem = tem.getSiguiente();
                i++;
            }
        }
        int totalVar = getCantidad() -1;
        double ult = cifra / totalVar;
        DecimalFormat formato = new DecimalFormat("#.##");
        var = Math.sqrt(ult);
        setVar(var);
        System.out.println(formato.format(getVar()));
    }
    
    public void mostrarVarianza2(){
        double cifra = 0;
        
        if (!Vacia()){
            Nodo tem = inicio2;
            int i = 0;
            while (tem != null){
                cifra = cifra + (Math.pow((tem.getColumna2() - suma2), 2));
                tem = tem.getSiguiente();
                i++;
            }
        }
        int totalVar = getCantidad2()-1;
        double ult = cifra / totalVar;
        DecimalFormat formato2 = new DecimalFormat("#.##");
        var2 = Math.sqrt(ult);
        setVar2(var2);
        System.out.println(formato2.format(getVar2()));
    }
    
   

}
