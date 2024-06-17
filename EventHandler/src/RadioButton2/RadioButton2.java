/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadioButton2;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
public class RadioButton2 implements ItemListener{
    JLabel label = new JLabel("Makan Apa Kamu Pagi Ini?" ,JLabel.CENTER);
    ButtonGroup grup = new ButtonGroup();
    JRadioButton radio1 = new JRadioButton("A. Roti");
    JRadioButton radio2 = new JRadioButton("B. Nasi Padang");
    JRadioButton radio3 = new JRadioButton("C. Ayam Goreng");
    JRadioButton radio4 = new JRadioButton("D. Tempe Tahu Goreng");
    JRadioButton radio5 = new JRadioButton("E. Jengkol CABE");
    JLabel lab = new JLabel("-");
    public RadioButton2() {
        JFrame frame = new JFrame("Ferdiyansyah");
        frame.setVisible(true);
        frame.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));
        frame.add(label);
        frame.add(radio1);
        radio1.setHorizontalAlignment(JRadioButton.CENTER);
        frame.add(radio2);
        radio2.setHorizontalAlignment(JRadioButton.CENTER);
        frame.add(radio3);
        radio3.setHorizontalAlignment(JRadioButton.CENTER);
        frame.add(radio4);
        radio4.setHorizontalAlignment(JRadioButton.CENTER);
        frame.add(radio5);
        radio5.setHorizontalAlignment(JRadioButton.CENTER);  
        frame.add(lab);
        lab.setHorizontalAlignment(JLabel.CENTER);
        
        grup.add(radio1);
        grup.add(radio2);
        grup.add(radio3);
        grup.add(radio4);
        grup.add(radio5);
        
        radio1.addItemListener(this);
        radio2.addItemListener(this);
        radio3.addItemListener(this);
        radio4.addItemListener(this);
        radio5.addItemListener(this);
        
    }
    
    public static void main(String[] args) {
        RadioButton2 tb = new RadioButton2();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(radio1.isSelected()){
            lab.setText("Pagi Ini Aku Makan Roti");
        }else if(radio2.isSelected()){
            lab.setText("Pagi Ini Aku Makan Nasi Padang");
        }else if(radio3.isSelected()){
            lab.setText("Pagi Ini Aku Makan Ayam Goreng");
        }else if(radio4.isSelected()){
            lab.setText("Pagi Ini Aku Makan Tahu Tempe Goreng");
        }else if(radio5.isSelected()){
            lab.setText("Pagi Ini Aku Makan Jengkol Cabe");
        }
    }
}
