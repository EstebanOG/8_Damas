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
    private int[] x, x2;

    public Modelo() {
        solucion = true;
        x = new int[8];
//        for(int i = 0; i<x.length; i++){
//            x[i] = -10;
//        }
        x2 = new int[8];
    }

    public void setPosicionInicial(Integer[] posicionInicial) {
        this.posicionInicial = posicionInicial;
        this.x[posicionInicial[0]] = posicionInicial[1];
    }

    public boolean esConveniente(int f, int c) {
        /**
         * metodo boolano que verifica si es conveniente poner a la reina en la
         * columna c y fila f
         */
        //System.out.println("f:" + f + "c:" + c);
        //System.out.println(Arrays.toString(x));
        if (c == posicionInicial[1]) {
            //System.out.println("Columa o fila");
            return false;
        }

        for (int i = 0; i < f; i++) {
            if (x[i] == c || (i - f) == (x[i] - c) || (i - f) == (c - x[i])) {
                //System.out.println("Primer");
                return false;
            }
        }
        //int n = 1;
        if (f < posicionInicial[0]) {
//            for (int j = f + 1; j < 8; j++) {
//                if (x[j] == c + n || x[j] == c - n) {
//                    System.out.println("SegundoIzquierda");
//                    return false;
//                }
//                n++;
//            }
            int n = 1;
            //System.out.println("Acá");
            //System.out.println("f:"+posicionInicial[0]+" c:"+posicionInicial[1]);
            for (int j = f; j <= posicionInicial[0]; j++) {
                //System.out.println("Se repite:"+j);
                if (f + n == posicionInicial[0] && c + n == posicionInicial[1] || f + n == posicionInicial[0] && c - n == posicionInicial[1]) {
                    //System.out.println("DiagonalIzquierda");
                    return false;
                }
                n++;
            }
        }

//        for (int j = f; j < 8; j++) {
//            if ((j - f) == (c - x[j]) || (j - f) == (x[j] - c)) {
//                System.out.println("Segundo");
//                return false;
//            }
//        }
        //System.out.println("Entra en ... f:" + f + "c:" + c);
        return true;

//        for (int j = f; j<8; j++){
//            if((f - j) == (x[j] - c) || (f - j) == (c - x[j])){
//                return false;
//            }
//        }
    }

    public void imprimeTablero(int[] x) {
        int tam = 8;
        if (solucion) {
            System.out.println(Arrays.toString(x));
            this.x2 = x.clone();
            // System.out.println("Entra xd");
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
//            if(posicionInicial[0] == 0){
//                f=1;
//            }
            if (esConveniente(f, c)) {
                if (f != posicionInicial[0]) {
                    x[f] = c;
                }
                //imprimeTablero(x);
                if (f == n - 1) {
                    imprimeTablero(x);
                } else {
                    backtracking(f + 1, n);
                }
            }else if(f==7 && posicionInicial[0] == 7){
                imprimeTablero(x);
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

    public void setSolucion(boolean solucion) {
        this.solucion = solucion;
    }

}
