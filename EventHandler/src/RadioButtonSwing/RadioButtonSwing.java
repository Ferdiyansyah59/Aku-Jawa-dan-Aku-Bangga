/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadioButtonSwing;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class RadioButtonSwing extends JFrame implements ItemListener{
    JRadioButton sm, md, lg;
    JButton bt;
    
    public RadioButtonSwing(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        ButtonGroup bg = new ButtonGroup();
        sm = new JRadioButton("Small");
        md = new JRadioButton("Medium");
        lg = new JRadioButton("Learge");
        
        bg.add(sm);
        bg.add(md);
        bg.add(lg);
        
        bt =  new JButton("Click Here!");
        bt.setBounds(100, 50, 100, 50);
        JPanel center = new JPanel();
        center.setLayout(null);
        center.add(bt);
        c.add(center, BorderLayout.CENTER);
        
        JPanel north = new JPanel();
        north.add(sm);
        north.add(md);
        north.add(lg);
        c.add(north, BorderLayout.NORTH);
        
        sm.addItemListener(this);
        md.addItemListener(this);
        lg.addItemListener(this);
      
    }
    
    public static void main(String[] args) {
        RadioButtonSwing bs = new RadioButtonSwing("Ferdiyansyah");
        bs.setSize(500, 500);
        bs.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       if(sm.isSelected()){
           bt.setSize(75, 20);
       }else if(md.isSelected()){
           bt.setSize(100,50);
       }else if(lg.isSelected()){
           bt.setSize(150,75);
       }
    }
}
