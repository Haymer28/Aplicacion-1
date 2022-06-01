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
    private double columna;
    private double columna2;

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
            temporal.setSiguiente(nodo);
        }
        cantidad++;
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
        cantidad++;
    }

    public void listar() {
        if (!Vacia()) {
            Nodo temp = inicio;
            int i = 0;
            System.out.println("Columna 1");
            while (temp != null) {
                System.out.print(temp.getColumna()+" | ");
                temp = temp.getSiguiente();
                i++;
            }
        }
    }

    public void listar2() {
        if (!Vacia2()) {
            Nodo tempo = inicio2;

            int i = 0;
            System.out.println("Columna 2");
            while (tempo != null) {
                System.out.print(tempo.getColumna2()+" | ");
                tempo = tempo.getSiguiente();

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
                agregarCol2(columna);

                columna2 = (Double.parseDouble(partes[1]));
                agregarCol2(columna2);
            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            System.out.println("No se encontro el archivo");
        }
    }

}
