/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckBox2;

/**
 *
 * @author ferdiyansyah
 */

import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class CheckBox2 extends JFrame implements ItemListener {
    JTextField jt = new JTextField(20);;
    JLabel lb, hs;
    JCheckBox cb, cb2;
    JPanel panel = new JPanel();
    public CheckBox2(String title) {
        super(title);        
        
        setContentPane(panel);
        
        lb = new JLabel("Nilai Rupiah: ");
        cb = new JCheckBox("Convert to Dollar");
        cb2 = new JCheckBox("Convert to Rupiah");
        hs = new JLabel("Hasil:   0");
        panel.add(lb);
        panel.add(jt);
        panel.add(cb);
        panel.add(cb2);
        panel.add(hs);    
        
        cb.addItemListener(this);
        cb2.addItemListener(this);
        
    }
    
    
    public static void main(String[] args) {
        CheckBox2 cb = new CheckBox2("Ferdiyansyah");
        cb.setSize(1000, 500);
        cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cb.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
         DecimalFormat dc = new DecimalFormat("#.##");
            
        if(e.getStateChange() == ItemEvent.SELECTED){
           if(cb.isSelected()){
                double value = Double.valueOf(jt.getText());
                double hasil = value / 14500;
                double hss = Double.valueOf(dc.format((hasil)));
                System.out.println(hasil);
                hs.setText("Hasil:   " + String.valueOf(hss));
                cb2.setEnabled(false);
            }else if(cb2.isSelected()) {
                lb.setText("Nilai Dollar: ");
                double velue = Double.valueOf(jt.getText());
                double hasil = velue * 14500;
                double hss = Double.valueOf(dc.format(hasil));
                System.out.println(hasil);
                hs.setText("Hasil:   "+ String.valueOf(hss));
                cb.setEnabled(false);
                
            }else{
                System.out.println("Terima Kasih");

            }
       }else {
          cb.setEnabled(true);
          cb2.setEnabled(true);
           System.out.println("Cleared");
       }
       
         
         
            
    }



}
