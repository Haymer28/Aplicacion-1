/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.pkg1;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author SAMSUNG-PC
 */
public class Aplicacion1 {

   
    public static void main(String[] args) {
        
        Lista lista = new Lista();
        
        
        lista.leerArchivo("C:\\archivo\\numeros.txt");
        lista.listar();
        System.out.print("\n");
        lista.listar2();
        System.out.println("\n");
        lista.mostrarMedia();
        
        
    }
    
}
