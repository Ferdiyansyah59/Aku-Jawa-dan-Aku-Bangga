/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadioButtonAWT;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RadioButton extends JFrame implements ItemListener{
    CheckboxGroup cg1;
    Checkbox c1, c2;
    public RadioButton(String title) {
        super(title);
        cg1 = new CheckboxGroup();
        c1 = new Checkbox("circle", cg1, false);
        c2 = new Checkbox("squere", cg1, false);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(c1);
        c.add(c2);
        
        c1.addItemListener(this);
        c2.addItemListener(this);
        
        
    }
    
    public static void main(String[] args) {
        RadioButton rb = new RadioButton("Ferdiyansyah");
        rb.setSize(500,500);
        rb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rb.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       if(e.getSource() == c1){
           System.out.println("Circle");
       }else {
           System.out.println("Squere");
       }
    }
}
