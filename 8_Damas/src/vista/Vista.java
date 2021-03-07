/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Vista extends JFrame {

    private JPanel pPrincipal;
    public PanelSuperior pSuperior;
    public PanelInferior pInferior;
    public PanelTablero pTablero;
    

    public Vista() {
        this.setBounds(0, 0, 800, 638);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(Vista.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        pPrincipal = new JPanel();
        pPrincipal.setBounds(0, 0, 800, 600);
        pPrincipal.setLayout(null);
        this.getContentPane().add(pPrincipal);

        pSuperior = new PanelSuperior();
        pPrincipal.add(pSuperior);

        pInferior = new PanelInferior();
        pPrincipal.add(pInferior);

        pTablero = new PanelTablero();
        pPrincipal.add(pTablero);
        
        pPrincipal.repaint();
    }
}
