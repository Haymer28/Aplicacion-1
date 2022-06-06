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

    //Se instancian dos atributos nodos que representan
    //la cabecera de la lista
    private Nodo inicio;
    private Nodo inicio2;

    //Nos representa los datos que hay almacenados en cada
    //lista, y con estos atributos se podrá encontrar la media
    private int cantidad;
    private int cantidad2;

    //En estas variables se almacenan los datos, tanto de la 
    //columna 1 como de la columna 2
    private double columna;
    private double columna2;

    //Y con estos atributos almacenamos la varianza
    private double var;
    private double var2;

    //Metodos get y set
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

    //Estos metodos son necesarios para saber si ambas listas
    //estan vacias o por lo contrario tengan datos
    public boolean Vacia() {
        return inicio == null;
    }

    public boolean Vacia2() {
        return inicio2 == null;
    }

    //La función de este metodo es agregar los datos almacenados 
    //a la lista, estos datos son almacenados en la variable "columna"
    public void agregarCol1(double col) {
        Nodo nodo = new Nodo(); //Se crea un objeto tipo Nodo
        nodo.setColumna(col);   //Al nodo se le asigna el metodo set, que recibe como parametro un double
        //Si la lista esta vacia, la cabecera es igual a nodo
        if (Vacia()) {
            inicio = nodo;
        } else {
            //Si no, creamos un nodo temporal que es igual a la cabecera
            Nodo temporal = inicio;
            //Mientras el nodo y su puntero sean diferentes de nulo
            //o sea almacenen un dato en cada nodo, avanza de posición
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();
            }
            //temporal toma el valor de nodo
            temporal.setSiguiente(nodo);
        }
        //Y el metodo set recibe la cantidad incrementada
        cantidad++;
        setCantidad(cantidad);
    }

    public void agregarCol2(double col2) {
        Nodo nodo2 = new Nodo();
        nodo2.setColumna2(col2);
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
            System.out.println("No se encontro el archivo");
        }
    }

    double suma = 0;
    double suma2 = 0;

    public void mostrarMedia() {

        //Si la lista no se encuentra vacia 
        if (!Vacia()) {
            //Crea un nodo temporal que es igualado a la 
            //primera cabecera 
            Nodo tem = inicio;
            int i = 0;
            //El while es para definir que mientras el nodo no sea 
            //diferente de nulo haga la operacion que se encuentra dentro
            while (tem != null) {
                suma = suma + tem.getColumna();
                tem = tem.getSiguiente();
                i++;
            }
            //Se obtiene la variable suma y esta se divide por la cantidad
            //que es los nodos que se encuentran almacenados en la lista
            suma /= getCantidad();
            System.out.println(suma);
        }

    }

    public void mostrarMedia2() {

        if (!Vacia2()) {
            Nodo tem = inicio2;
            int i = 0;
            while (tem != null) {
                suma2 = suma2 + tem.getColumna2();
                tem = tem.getSiguiente();
                i++;
            }
            //En este es practicamente lo mismo solo que quitamos los decimales
            //con un DecimalFormat
            DecimalFormat form = new DecimalFormat("#.##");
            suma2 /= getCantidad2();
            System.out.println(form.format(suma2));
        }
    }

    public void mostrarVarianza() {
        double cifra = 0;
        //La variable de cifra tiene un papel importante en este metodo
        //cifra se va a encargar de almacenar la resta entre cada uno de los datos
        //y la media, todo esto potenciado a la 2
        if (!Vacia()) {
            Nodo tem = inicio;
            int i = 0;
            while (tem != null) {
                cifra = cifra + (Math.pow((tem.getColumna() - suma), 2));
                tem = tem.getSiguiente();
                i++;
            }
        }
        int totalVar = getCantidad() - 1;
        //En esta variable tipo double se divide el resultado de cifra y el totalVar 
        double ult = cifra / totalVar;
        //Le damos un formato decimal para que no nos muestre tantos decimales
        DecimalFormat formato = new DecimalFormat("#.##");
        //Se saca raiz cuadrada y por ultimo se impirme el resultado
        var = Math.sqrt(ult);
        setVar(var);
        System.out.println(formato.format(getVar()));
    }

    public void mostrarVarianza2() {
        double cifra = 0;

        if (!Vacia()) {
            Nodo tem = inicio2;
            int i = 0;
            while (tem != null) {
                cifra = cifra + (Math.pow((tem.getColumna2() - suma2), 2));
                tem = tem.getSiguiente();
                i++;
            }
        }
        int totalVar = getCantidad2() - 1;
        double ult = cifra / totalVar;
        DecimalFormat formato2 = new DecimalFormat("#.##");
        var2 = Math.sqrt(ult);
        setVar2(var2);
        System.out.println(formato2.format(getVar2()));
    }

}
