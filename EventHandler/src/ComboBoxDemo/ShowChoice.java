/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComboBoxDemo;

/**
 *
 * @author ferdiyansyah
 */
import java.awt.*;
import java.awt.event.*;
class ShowChoice implements ItemListener {
    private Label display;
    public ShowChoice(Label d){
        display = d;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
       Object source = e.getSource();
       if(!(source instanceof Choice)){
           return;
       }
       Choice list = (Choice) source;
       String selected = list.getSelectedItem();
       display.setText(selected);
    }
    
}
