/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author Usuario
 */
public class Controlador implements ActionListener {

    private Vista vista;
    private Modelo modelo;
    private JButton btnAccion;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.pSuperior.btnIniciar.addActionListener(this);
        this.vista.pInferior.btnBorrar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("8 Damas");
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnAccion = (JButton) e.getSource();
        // Se verifica el botón que activa el evento
        if (btnAccion.equals(vista.pInferior.btnBorrar)) {
            vista.pTablero.limpiarTablero();
        } else {
            modelo.setSolucion(true);
            vista.pTablero.limpiarTablero();
            modelo.setPosicionInicial(vista.pTablero.getCasillaSeleccionada());
            modelo.llamaBT();
            vista.pTablero.setSolucionTablero(modelo.getX());
            vista.pTablero.ubicarNumeros();
        }

    }

}
