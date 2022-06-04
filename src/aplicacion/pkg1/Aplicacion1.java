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
        
        int opcion = 0;
        
        lista.leerArchivo("C:\\archivo\\numeros.txt");
        
        try{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1.Mostrar columna 1, media y varianza\n 2.Mostrar columna 2, media y varianza\n"));
            switch(opcion){
                case 1:
                    lista.listar();
                    System.out.println("");
                    System.out.println("Media: ");
                    lista.mostrarMedia();
                    System.out.println("Varianza:");
                    lista.mostrarVarianza();
                    break;
                case 2:
                    lista.listar2();
                    System.out.println("");
                    System.out.println("Media:");
                    lista.mostrarMedia2();
                    System.out.println("Varianza:");
                    lista.mostrarVarianza2();
                    break;
                default:
                    
                    break;
            }
        }
        catch(Exception e){
            
        }
    }
    
}
