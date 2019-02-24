/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
    private static int fil, col , cont = 0;
    private static String matriz;
    
    //declaracion de variables tipo objeto
    private static Scanner sc = new Scanner(System.in);
    private static String[] arrstr;
    private static int[][] matrizn;
    private static ArrayList<Integer> lista = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ingreso();
        obtenerFilCol(matriz);
        creandoArray(matriz);
        formandoMatriz();
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
     * split, quitando los espacios en blanco.
     * @param cad correspondiente a la matriz
     * ingresada.
     */
    public static void obtenerFilCol(String cad) {
       
        realizarSplit(arrstr, cad);
        
        fil = Integer.parseInt(arrstr[0]);
        col = Integer.parseInt(arrstr[1]);
                
    }
    
    /**
     * Metodo que realiza un split a una cadena,
     * quitandole los espacios en blanco,
     * asignando el resultado a un
     * array de tipo string.
     * @param arraystr para almacenar el resultado 
     * del split.
     * @param cadena para aplicarle el metodo
     * split.
     */
    public static void  realizarSplit(String[] arraystr, String cadena) {
        
        arraystr = cadena.split(" ");
        
    }
    
    /**
     * Metodo que recibe la cadena de numeros,
     * aplicando el metodo split, para quitar
     * los espacios en blanco, almacenando los otros 
     * numeros en un array.
     * @param mat siendo este la matriz ingresada
     * por consola.
     */
    public static void creandoArray(String mat) {
        
        realizarSplit(arrstr, mat);
        
        for(int i = 0; i < arrstr.length; i++) {
            
            //si i es menor que 2 no se realiza ninguna
            //accion, siendo 0 y 1, fila y columna 
            if(i < 2) {
                
            }
            else {
                //se agregan los otros numeros a una lista
                lista.add(Integer.parseInt(arrstr[i]));
            }
            
        }
    }
    
    /**
     * Metodo que realiza la tarea de formar una
     * matriz utilizando las variables fil y col.
     * Ademas se utiliza una var tipo contador
     * que aumenta al final del metodo, para
     * realizar la tarea de recorrer la lista de
     * forma correcta en metodo recorreLista.
     */
    public static void formandoMatriz() {
        
        matrizn = new int[fil][col];
        
        for(int f = 0; f < matrizn.length; f++) {
            
            for(int c = 0; c < matrizn[f].length; c++) {     
                
                //se asignan los valores a la matriz
                matrizn[f][c] = recorreLista(cont);
                
                //variables contador 
                cont++;
            
            }
        }
        
    }
    
    /**
     * Metodo que realiza la tarea de obtener 
     * los elementos de la lista, apoyandose con
     * el parametro recibido que seria la
     * la variable contador.
     * @param conta ayuda a recorrer y 
     * obtener los elementos de la lista. 
     * @return var numero con el elemento de la
     * lista obtenido.
     */
    public static int recorreLista(int conta) {
        
        //variable para almacenar
        //los elementos de la lista.
        int numero = 0;
        
        for(; conta < lista.size();) {
            numero = lista.get(conta);
            //se realiza un break para evitar 
            //obtener elementos repetidos
            break;
        }
        
        return numero;
    }

}//fin class
