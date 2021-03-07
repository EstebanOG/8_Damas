/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


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
        if (c == posicionInicial[1]) {
            return false;
        }

        for (int i = 0; i < f; i++) {
            if (x[i] == c || (i - f) == (x[i] - c) || (i - f) == (c - x[i])) {
                return false;
            }
        }
        if (f < posicionInicial[0]) {
            int n = 1;
            for (int j = f; j <= posicionInicial[0]; j++) {
                if (f + n == posicionInicial[0] && c + n == posicionInicial[1] || f + n == posicionInicial[0] && c - n == posicionInicial[1]) {
                    return false;
                }
                n++;
            }
        }
        return true;

    }

    public void imprimeTablero(int[] x) {
        if (solucion) {
            this.x2 = x.clone();
            solucion = false;
        }
    }

    public int[] getX() {
        return x2;
    }

    public void backtracking(int f, int n) { //este metodo va recorriendo los posibles espacio hasta que 
        //encuentra uno donde no se ataquen

        for (int c = 0; c < n; c++) {
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
            } else if (f == 7 && posicionInicial[0] == 7) {
                imprimeTablero(x);
            }
        }
    }

    public void llamaBT() {
        backtracking(0, 8);
    }

    public void setSolucion(boolean solucion) {
        this.solucion = solucion;
    }

}
