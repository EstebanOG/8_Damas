/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author Usuario
 */
public class Controlador implements ActionListener{
    
    private Vista vista;
    private Modelo modelo;
    
    public Controlador(Vista vista, Modelo modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.pSuperior.btnIniciar.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("8 Damas");
        vista.setLocationRelativeTo(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.setPosicionInicial(vista.pTablero.getCasillaSeleccionada());
        modelo.llamaBT();
        vista.pTablero.setSolucionTablero(modelo.getX());
        vista.pTablero.ubicarNumeros();
    }
    
}
