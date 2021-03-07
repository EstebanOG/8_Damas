/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PanelSuperior extends JPanel{
    private JLabel lSuperior;
    public JButton btnIniciar;
    
    public PanelSuperior(){
        this.setBounds(0, 0, 800, 100);
        initComponents();
    }
    
    private void initComponents(){
        lSuperior = new JLabel("Rn Dn");
        lSuperior.setBounds(380, 20, 40, 60);
        lSuperior.setFont(new Font("Arial", Font.BOLD, 60));
        this.add(lSuperior);
        
        btnIniciar = new JButton();
        btnIniciar.setLocation(440, 20);
        btnIniciar.setPreferredSize(new Dimension(20,20));
        this.add(btnIniciar);
    }
}
