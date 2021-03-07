/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PanelNumerosCeldas extends JPanel{
    
    private JLabel[] numeros;
    public PanelNumerosCeldas(){
        
        this.setBounds(210, 140, 20, 320);
        numeros = new JLabel[8];
        initComponents();
    }
    
    private void initComponents(){
       for(int i = 0; i < numeros.length; i++){
           numeros[i] = new JLabel(8-i+"");
           numeros[i].setPreferredSize(new Dimension(20, 20));
           numeros[i].setFont(new Font("Arial", Font.PLAIN, 30));
           this.add(numeros[i]);
           this.setLayout(new GridLayout(8,0));
       }
    }
}
