/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
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
        //System.out.println(nodo.getColumna());
        if (Vacia()) {
            inicio = nodo;
        } else {
            Nodo temporal = inicio;
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();

            }
//            nodo.setColumna(col);

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
    
    
    

    //////////////
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
    
    public void mostrarMedia(){
        
        double suma = 0;
        double suma2 = 0;
        double average = 0;
        double average2 = 0;
        double numero = 0;
        double numero2 = 0;
        
        for (double i = 0; i< partes.length; i++){
            numero += Double.parseDouble(partes[0]);
            numero2 = Double.parseDouble(partes[1]);
            System.out.println(numero);
            suma += numero;
            suma2 = suma2 + numero2;
        }
        /*if (!Vacia2()) {
            Nodo tem = inicio;
            
            int i = 0;
            System.out.println("Columna 1");
            while (tem != null) {
                suma = suma + tem.getColumna();
                
                tem = tem.getSiguiente();

                i++;
            }
            suma /= getCantidad();
            System.out.println(suma);
            //
        }
        
        System.out.println(suma);*/
        
        average = numero / getCantidad();
//        average = suma2 / getCantidad(); 
        System.out.println("El promedio es "+average);
        System.out.println("El promedio es "+average2);

        
    }

}
