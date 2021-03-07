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
import javax.swing.SwingConstants;

/**
 *
 * @author Usuario
 */
public class PanelLetrasCeldas extends JPanel{
    private JLabel[] numeros;
    public PanelLetrasCeldas(){
        
        this.setBounds(240, 100, 320, 35);
        numeros = new JLabel[8];
        initComponents();
    }
    
    private void initComponents(){
       char letra = 97;
       for(int i = 0; i < numeros.length; i++){
           numeros[i] = new JLabel(Character.toString((char) (letra+i))+"", SwingConstants.CENTER);
           numeros[i].setPreferredSize(new Dimension(20, 20));
           numeros[i].setFont(new Font("Arial", Font.PLAIN, 30));
           this.add(numeros[i]);
           this.setLayout(new GridLayout(0,8));
       }
    }
}
