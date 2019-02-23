/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * En esta clase se crean las variables 
 * y metodos necesarios para realizar la 
 * tarea de obtener la suma de la columna 
 * mayor dentro de una matriz ingresada por
 * consola, ademas de imprimir el numero
 * de esta, seguido por la suma de los 
 * numeros que la componen.
 * @author ASUS
 */
public class Suma_Columna {
    
    //declaracion de variables
    private static int fil, col;
    private static String matriz;
    
    //declaracion de variables tipo objeto
    private static Scanner sc = new Scanner(System.in);
    private static char[] arrchar;
    private static String[] arrstr;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ingreso();
        obtenerFilCol(matriz);
    }
    
    
    /**
     * Metodo que permite el ingreso de la 
     * matriz mediante scanner.
     */
    public static void ingreso() {
        
        System.out.println("Ingrese la matriz: ");
        matriz = sc.nextLine();
        
    }
    
    /**
     * Metodo que permite el obtener la fila
     * y columna de la cadena recibida por 
     * parametro, apoyandose en el metodo
     * split.
     * @param cad correspondiente a la matriz
     * ingresada.
     */
    public static void obtenerFilCol(String cad) {
       
        arrstr = cad.split(" ");
        
        fil = Integer.parseInt(arrstr[0]);
        col = Integer.parseInt(arrstr[1]);
                
    }
    
    /**
     * 
     * @param mat 
     */
    public static void creandoArray(String mat) {
        
        arrchar = mat.toCharArray();
        
        for(int i = 0; i < arrchar.length; i++) {
            
            if(i < 2) {
                continue;
            }
            else {
                
            }
            
        }
    }
    
}
