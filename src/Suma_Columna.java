/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashMap;
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
    private static int fil, col , cont = 0, cont2 = 0, sumacol, totalm = 0, mayor = 0, columna;
    private static String matriz, fila;
    
    //declaracion de variables tipo objeto
    private static Scanner sc = new Scanner(System.in);
    private static String[] arrstr;
    private static int[][] matrizn;
    private static ArrayList<Integer> lista = new ArrayList<>();
    private static ArrayList<Integer> listasum = new ArrayList<>();
    private static HashMap<String, Integer> mapa = new HashMap<>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ingreso();
        obtenerFilCol(matriz);
        creandoArray(matriz);
        formandoMatriz();
        recorremap();
        System.out.println(recorrelisum());
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
       
        arrstr = cad.split(" ");
        
        fil = Integer.parseInt(arrstr[0]);
        col = Integer.parseInt(arrstr[1]);
        
        totalm = fil * col;
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
        
        arrstr = mat.split(" ");
        
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
                
                //se asigna a la variable la fila
                fila = String.valueOf(f);
                
                //se agregan los sgtes datos al mapa
                //fila y columna , numero obtenido del 
                //metodo recorrelista
                mapa.put(String.valueOf(fila.concat(String.valueOf(c))), recorreLista(cont));
                
                //variable contador 
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
    
    /**
     * Metodo que recorre el hashmap(map) para
     * obtener los resultados correspondientes,
     * para poder sumar los valores de las
     * columnas de la matriz ingresada y agregarlos
     * a una lista.
     * 
     */
    public static void recorremap() { 
        
          //mientras cont2 sea menor al total de datos
          // de la matriz, fila x columna.
          do {            
           
            for(String key : mapa.keySet()) {
                
                //si la llave termina igual al cont2
                //entonces se va a ir sumando.
                if(key.endsWith(String.valueOf(cont2))) {       
                    sumacol += mapa.get(key);
                }
                
            }
            //se agrega la suma obtenida a la lista
            listasum.add(sumacol);
            sumacol = 0;
            cont2++;
            
        } while(cont2 < totalm);
        
    }
    
    /**
     * Metodo que recorre la lista de sumas para 
     * obtener la mayor de ellas y su indice
     * correspondiente que seria el numero de columna.
     * @return una cadena conformada por el indice
     * y la suma mayor.
     */
    public static String recorrelisum() {
        
        for(int i = 0; i < listasum.size(); i++) {
            
            //si la suma es mayor entonces
            // se le asigna a la variable mayor
            if (listasum.get(i) > mayor) {
                mayor = listasum.get(i);
                columna = i;
            }
            
        }
        return String.valueOf(columna) + " " + mayor;
        
    }

}//fin class
