/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckBox;

/**
 *
 * @author ferdiyansyah
 */
import javax.swing.*;
import java.awt.*;
import static java.awt.SystemColor.control;
import java.awt.event.*;
public class CheckBox extends JFrame implements ItemListener{
    
    private JCheckBox control, cb1, cb2, cb3;
    
    public CheckBox(String title){
        super(title);
       
        control = new JCheckBox("Translate");
        cb1 = new JCheckBox("A");
        cb2 = new JCheckBox("B");
        cb3 = new JCheckBox("C");
        
        FlowLayout fl = new FlowLayout();
        fl.setVgap(25);
        fl.setHgap(25);
        
        Container c = getContentPane();
        c.setLayout(fl);
        c.add(control);
        c.add(cb1);
        c.add(cb2);
        c.add(cb3);
        
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
        control.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(control.isSelected()){
                    cb1.setEnabled(true);
                    cb2.setEnabled(true);
                    cb3.setEnabled(true);
                    System.out.println("Enabled");
                }else {
                    cb1.setEnabled(false);
                    cb2.setEnabled(false);
                    cb3.setEnabled(false);
                    System.out.println("Disabled");
                }
           }
        });
        
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        
    }
    
    public static void main(String[] args) {
        CheckBox cb = new CheckBox("Ferdiyansyah");
        cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cb.setSize(300, 200);
        cb.setVisible(true);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){
       JCheckBox cb = (JCheckBox)e.getItem();
       
       if(e.getStateChange() == ItemEvent.SELECTED){
           System.out.println(cb.getText() + "Selected");
       }else {
           System.out.println(cb.getText() + "Cleared");
       }
       
       if(cb1.isSelected()) {
           System.out.println("1");
       }else if(cb2.isSelected()) {
           System.out.println("2");
       }else if(cb3.isSelected()) {
           System.out.println("3");
       }else {
           System.out.println("None");
       }
    }

}
