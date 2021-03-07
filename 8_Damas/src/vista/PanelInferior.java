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
public class PanelInferior extends JPanel{
    private JLabel lInferior;
    public JButton btnBorrar;
    
    public PanelInferior(){
        this.setBounds(0, 500, 800, 100);
        initComponents();
    }
    
    private void initComponents(){
        lInferior = new JLabel("Rb Db");
        lInferior.setBounds(380, 20, 40, 60);
        lInferior.setFont(new Font("Arial", Font.BOLD, 60));
        this.add(lInferior);
        
        btnBorrar = new JButton();
        btnBorrar.setLocation(440, 20);
        btnBorrar.setPreferredSize(new Dimension(20,20));
        this.add(btnBorrar);
    }
}
