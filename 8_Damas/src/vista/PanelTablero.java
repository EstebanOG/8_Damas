/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Usuario
 */
public class PanelTablero extends JPanel implements ActionListener {

    private JButton[][] casilla;
    private JButton btnSeleccionado;
    private Border bordeDefault;
    private Integer[] casillaSeleccionada;
    private int[] solucionTablero;

    public PanelTablero() {
        this.setBounds(240, 140, 320, 320);
        this.setBackground(Color.blue);
        casilla = new JButton[8][8];
        casillaSeleccionada = new Integer[2];
        solucionTablero = new int[8];
        btnSeleccionado = null;
        bordeDefault = new LineBorder(Color.black);

        // Se genera tablero
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                casilla[i][j] = new JButton();
                casilla[i][j].setBorder(bordeDefault);
                casilla[i][j].setPreferredSize(new Dimension(20, 20));
                if ((i + j + 1) % 2 == 0) {
                    casilla[i][j].setBackground(new Color(153, 204, 255));
                }
                casilla[i][j].addActionListener(this);
                this.add(casilla[i][j]);
            }
            setLayout(new GridLayout(8, 8));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Pintar borde a la casilla seleccionada
        if (btnSeleccionado == null) {
            btnSeleccionado = (JButton) e.getSource();
            btnSeleccionado.setBorder(new LineBorder(Color.red));
        } else {
            btnSeleccionado.setBorder(bordeDefault);
            btnSeleccionado = (JButton) e.getSource();
            btnSeleccionado.setBorder(new LineBorder(Color.red));
        }
        encontrarPosicionInicial();
    }

    private void encontrarPosicionInicial() {
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                if (casilla[i][j].equals(btnSeleccionado)) {
                    casillaSeleccionada[0] = i;
                    casillaSeleccionada[1] = j;
                }
            }
        }
    }

    public void setSolucionTablero(int[] solucionTablero) {
        this.solucionTablero = solucionTablero;
    }

    public Integer[] getCasillaSeleccionada() {
        return casillaSeleccionada;
    }
    
    public void ubicarNumeros(){
        System.out.println(Arrays.toString(solucionTablero));
        for(int i = 0; i<solucionTablero.length;i++){
            casilla[i][solucionTablero[i]].setText(i+1+"");
        }
//        for (int i = 0; i < casilla.length; i++) {
//            for (int j = 0; j < casilla[i].length; j++) {
//                if (casilla[i][j].equals(btnSeleccionado)) {
//                    casillaSeleccionada[0] = i;
//                    casillaSeleccionada[1] = j;
//                }
//            }
//        }
    }

}
