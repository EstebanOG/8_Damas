/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Modelo {
    private Integer[] posicionInicial;
    private boolean solucion;
    private int[] x,x2;
    
    public Modelo(){
        solucion = true;
        x = new int[8];
        x2 = new int[8];
    }

    public void setPosicionInicial(Integer[] posicionInicial) {
        this.posicionInicial = posicionInicial;
        this.x[posicionInicial[0]] = posicionInicial[1];
    }
    
    public boolean esConveniente(int f, int c) {
        /**
        metodo boolano que verifica si es conveniente poner a la reina en la columna c y
        * fila f
         */
        for (int i = 0; i < f; i++) {
            if (x[i] == c || (i - f) == (x[i] - c) ||(i - f) == (c - x[i])) 
            {
                return false;
            }
        }
        
        if(c==posicionInicial[1]){
            return false;
        }
        return true;
    }
 
    public void imprimeTablero(int[] x) {
        int tam = 8;
        if(solucion){
            System.out.println(Arrays.toString(x));
            this.x2 = x.clone();
            System.out.println("Entra xd");
            solucion = false;
        }
        
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (x[i] == j) {
                    System.out.print("۞ ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[] getX() {
        System.out.println(Arrays.toString(x2));
        return x2;
    }
 
    public void backtracking(int f, int n) { //este metodo va recorriendo los posibles espacio hasta que 
        //encuentra uno donde no se ataquen
        
        for (int c = 0; c < n; c++) {
            if (esConveniente(f, c)) {
                if(f!=posicionInicial[0])
                    x[f] = c;
                //imprimeTablero(x);
                if (f == n - 1) {
                    imprimeTablero(x);
                } else {
                    backtracking(f + 1, n);
                }
            }
        }
//        int c = 0;
//        while(solucion){
//            if (esConveniente(f, c)) {
//                if(f != posicionInicial[0])
//                    x[f] = c;
//                //imprimeTablero(x);
//                if (f == n - 1) {
//                    imprimeTablero(x);
//                    this.solucion = false;
//                } else {
//                    backtracking(f + 1, n);
//                }
//            }
//            c++;
//        }
    }
 
    public void llamaBT() {
        backtracking(0, 8);
    }
 
//    public static void main(String args[]) {
//        Reina R = new Reina();
//        R.llamaBT();
//      
//    }
}
